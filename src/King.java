
// !! THE WHOLE FUNCTION IS FUCKED BECAUSE IT CHECKS IS SAFE BETWEEN THE CUR POISTION AND THE DST
// INSTEAD OF DST AND POTENTIAL RISK!!!!!!!!!!!!!!!!!!!!!!!!!

// SOLUTION : int iteration = Math.min(this.pos.getRow(), this.pos.getRow());

public class King extends Piece
{
    public King(int row, int col, boolean color)
    {
        super(row, col, color);
    }

    @Override
    public String getTitle()
    {
        return "King";
    }

    @Override
    public boolean isValid(Board board, Position dst)
    {
        if(Math.abs(this.pos.getCol() - dst.getCol()) > 1 ||
                Math.abs(this.pos.getRow() - dst.getRow()) > 1)
            return false;

        if(!generalCheck(board, dst))
            return false;

        if(isSafe(board, dst))
            return true;

        return false;
    }

    //check if an enemy piece can eat the king on that square
    // IS THERE NO CHECK?
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
        int iteration = Math.min(dst.getRow(), dst.getCol());
        for(int i =  1 ; i < iteration; i++)
        {

                Piece cur = board.getBoard(new Position(dst.getRow() - i, dst.getCol() - i));
                if (cur != null)
                {
                    return (!cur.getTitle().equals("Queen") && !cur.getTitle().equals("Bishop"))
                            || cur.color == this.color;
                }

        }

        return true;
    }

    //checks if possible to move diagonal down, left without going over someone;
    private boolean isSafeDiaDownLeft(Board board, Position dst)
    {

        //NEED FIX FIX FIX
        int iteration = 0;
        for(int i =  1 ; i < iteration; i++)
        {
            Piece cur = board.getBoard(new Position(dst.getRow() - i, dst.getCol() + i));
            if(cur != null)
            {
                return (!cur.getTitle().equals("Queen") && !cur.getTitle().equals("Bishop"))
                        || cur.color == this.color;
            }


        }
        return true;
    }

    //checks if possible to move diagonal down, right without going over someone;
    private boolean isSafeDiaDownRight(Board board, Position dst)
    {

        // algorithm that checks the iteration length from the destination
        // to the end of the matrix
        int  endcol  = 7;
        if(dst.getRow() < dst.getCol())
            endcol =  7 - Math.abs(dst.getRow() - dst.getCol());
        //int iteration = endcol - dst.getCol();

        int iteration =  7 - Math.max(dst.getCol(), dst.getRow());
        for(int i = 1 ; i <= iteration; i++)
        {
            Piece cur = board.getBoard(new Position(dst.getRow() + i, dst.getCol() + i));
            if (cur != null)
            {
                return (!cur.getTitle().equals("Queen") && !cur.getTitle().equals("Bishop"))
                        || cur.color == this.color;
            }
        }
        return true;
    }

    //checks if possible to move diagonal up, right without going over someone;
    private boolean isSafeDiaUpRight(Board board, Position dst)
    {
        // algorithm that checks the iteration length from the destination
        // to the end of the matrix
        int endcol = dst.getRow() + dst.getCol();
        if(endcol > 7)
            endcol  = 7;
        int iteration = endcol - dst.getCol();


    // maybe <= instead of <
        for(int i=1;i< iteration; i++)
        {
            Piece cur = board.getBoard(new Position(dst.getRow() - i, dst.getCol() + i));
            if(cur != null)
            {
                // returns true if king is safe (can't get eaten).
                return (!cur.getTitle().equals("Queen") && !cur.getTitle().equals("Bishop"))
                        || cur.color == this.color;
            }
        }
        return true;
    }



    //checks if possible to move straight left without going over someone;
    private boolean isSafeLeft(Board board, Position dst)
    {
        // algorithm that checks the iteration length from the destination
        // to the end of the matrix
        int iteration = dst.getCol();

        for(int i = 1 ; i < iteration; i++ )
        {
            // does the way  between the destination and current blocked?
            Piece cur = board.getBoard(new Position(dst.getRow(), dst.getCol() - i));
            if (cur != null)
            {
                return !cur.isValid(board, dst) || cur.color == this.color;
            }
        }
        return true;
    }

    private boolean isSafeRight(Board board, Position dst)
    {
        int iteration = 7 - dst.getCol();

        for(int i = 1 ; i <  iteration; i++ )
        {
            // does the way  between the destination and current blocked?

            Piece cur = board.getBoard(new Position(dst.getRow() , dst.getCol()+ i));
            if (cur != null)
            {
                return !cur.isValid(board, dst) || cur.color == this.color;
            }
        }
        return true;
    }

    //checks if possible to move straight up without going over someone;
    private boolean isSafeUp(Board board, Position dst)
    {
        int iteration = dst.getRow();

        for(int i = 1 ; i <  iteration; i++ )
        {
            // does the way  between the destination and current blocked?
            Piece cur = board.getBoard(new Position(dst.getCol() -i , dst.getRow()));
            if (cur != null) 
            {
                return !cur.isValid(board, dst) || cur.color == this.color;
            }
        }
        return true;
    }

    //checks if possible to move straight down without going over someone;
    private boolean isSafeDown(Board board, Position dst)
    {
        int iteration = 7 - dst.getRow();

        for(int i = 1 ; i <  iteration; i++ )
        {
            // does the way  between the destination and current blocked?
            Piece cur = board.getBoard(new Position(dst.getCol() + i , dst.getRow()));
            if (cur != null)
            {
                return !cur.isValid(board, dst) || cur.color == this.color;
            }
        }
        return true;
    }

    public boolean isSafeHorse(Board board, Position dst)
    {
        return true;
    }


}
