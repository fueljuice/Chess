
// !! THE WHOLE FUNCTION IS FUCKED BECAUSE IT CHECKS IS SAFE BETWEEN THE CUR POISTION AND THE DST
// INSTEAD OF DST AND POTENTIAL RISK!!!!!!!!!!!!!!!!!!!!!!!!!

// SOLUTION I THOUGHT OF: RUN A LOOP OF THE ENTIRE MAP (FOR 1 -> 8) AND CATCH ERROR AND RETURN FALSE
// AND ENCOUNTERING A NON THREAT RETURNS SAFE (TRUE) (NOT YET IMPLEMENTED)

public class King extends Piece
{
    public King(int row, int col, boolean color)
    {
        super(row, col, color);
    }

    @Override
    public boolean isValid(Board board, Position dst)
    {
        if(Math.abs(this.pos.getCol() - dst.getCol()) > 1 ||
                Math.abs(this.pos.getRow() - dst.getRow()) > 1)
            return false;

        if(!generalCheck(dst))
            return false;

        if(isSafe(board, dst))
            return true;

        return false;
    }

    //check if an enemy piece can eat the king on that square
    private boolean isSafe(Board board,Position dst)
    {
        return iSafeStraight(board, dst) && isSafeDiagnoul(board, dst) && isSafeHorse(board, dst);
    }

    private boolean isSafeDiagnoul(Board board, Position dst)
    {
        return isSafeDiaDownLeft(board, dst) && isSafeDiaDownRight(board, dst) &&
                isSafeDiaUpLeft(board, dst) && isSafeDiaUpRight(board, dst);

    }

    private boolean iSafeStraight(Board board, Position dst)
    {
        return !isSafeRight(board, dst) && !isSafeLeft(board, dst)
                && !isSafeUp(board, dst) && isSafeDown(board, dst);

    }


    //checks if possible to move diagonal up, left without going over someone;
    private boolean isSafeDiaUpLeft(Board board, Position dst)
    {
        for(int i =  1 ; i <Math.abs(dst.getCol() - this.pos.getCol()) -1; i++)
        {
            Piece cur = board.getBoard(new Position(this.pos.getRow() - i, this.pos.getCol() - i));
            if(cur != null)
            {
                if (cur.isValid(board, this.pos) && cur.color != this.color)
                    return false;
            }
        }

        return true;
    }

    //checks if possible to move diagonal down, left without going over someone;
    private boolean isSafeDiaDownLeft(Board board, Position dst)
    {
        for(int i =  1 ; i < Math.abs(dst.getCol()-this.pos.getCol()) -1; i++)
        {
            Piece cur = board.getBoard(new Position(this.pos.getRow() - i, this.pos.getCol() + i));
            if(cur != null)
            {
                if (cur.isValid(board, this.pos) && cur.color != this.color)
                    return false;
            }


        }
        return true;
    }

    //checks if possible to move diagonal down, right without going over someone;
    private boolean isSafeDiaDownRight(Board board, Position dst)
    {
        for(int i = 0 ; i < Math.abs(dst.getCol()-this.pos.getCol()); i++)
        {
            Piece cur = board.getBoard(new Position(this.pos.getRow() + i, this.pos.getCol() + i));
            if (cur != null)
            {
                if (cur.isValid(board, this.pos) && cur.color != this.color)
                    return false;
            }
        }
        return true;
    }

    //checks if possible to move diagonal up, right without going over someone;
    private boolean isSafeDiaUpRight(Board board, Position dst)
    {

        for(int i=1;i<Math.abs(dst.getCol()-this.pos.getCol());i++)
        {
            Piece cur = board.getBoard(new Position(this.pos.getRow() + i, this.pos.getCol() - i));
            if(cur != null)
            {
                if (cur.isValid(board, this.pos) && cur.color != this.color)
                    return false;
            }
        }
        return true;
    }



    //checks if possible to move straight left without going over someone;
    private boolean isSafeLeft(Board board, Position dst)
    {
        for(int i = 1 ; i < (this.pos.getCol() -dst.getCol() - 1); i++ )
        {
            // does the way  between the destination and current blocked?
            Piece cur = board.getBoard(new Position(this.pos.getRow(), this.pos.getCol() - i));
            if (cur != null)
            {
                if (cur.isValid(board, this.pos) && cur.color != this.color)
                    return false;
            }
        }
        return true;
    }

    private boolean isSafeRight(Board board, Position dst)
    {
        // loops from the current position to dst position
        for(int i = 1 ; i < (dst.getCol() - this.pos.getCol() - 1); i++ )
        {
            // does the way  between the destination and current blocked?

            Piece cur = board.getBoard(new Position(this.pos.getRow() , this.pos.getCol()+ i));
            if (cur != null)
            {
                if (cur.isValid(board, this.pos) && cur.color != this.color)
                    return false;
            }
        }
        return true;
    }

    //checks if possible to move straight up without going over someone;
    private boolean isSafeUp(Board board, Position dst)
    {
        // loops from the current position to dst position
        for(int i = 1 ; i < (dst.getRow() - this.pos.getRow() - 1); i++ )
        {
            // does the way  between the destination and current blocked?
            Piece cur = board.getBoard(new Position(this.pos.getCol() -i , this.pos.getRow()));
            if (cur != null) 
            {
                if (cur.isValid(board, this.pos) && cur.color != this.color)
                    return false;
            }
        }
        return true;
    }

    //checks if possible to move straight down without going over someone;
    private boolean isSafeDown(Board board, Position dst)
    {
        // loops from the current position to dst position
        for(int i = 1 ; i < (dst.getRow() - this.pos.getRow() - 1); i++ )
        {
            // does the way  between the destination and current blocked?
            Piece cur = board.getBoard(new Position(this.pos.getCol() + i , this.pos.getRow()));
            if (cur != null)
            {
                if (cur.isValid(board, this.pos) && cur.color != this.color)
                    return false;
            }
        }
        return true;
    }

    public boolean isSafeHorse(Board board, Position dst)
    {
        return true;
    }





}
