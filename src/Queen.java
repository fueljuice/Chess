public class Queen extends Piece
{
    public Queen(int row, int col, boolean color)
    {
        super(row, col, color);

    }
    @Override
    public boolean isValid(Board board, Position dst)
    {
    if(!this.generalCheck(dst))
    {
        return false;
    }

    //check if player did a legal queen move( diagonal or stright only);
    if(!(this.pos.isMoveDiagonal(dst)||this.pos.isMoveStraight(dst)))
    {
        return false;
    }

    //if moved diagonal return true;
    if(this.movingDiagonal(board, dst))
    {
        return true;
    }

    //if moved striaght return true;
    return this.movingStraight(board, dst);







    }


    /// // תזכורת לבדוק אם זה תקין. בגלל מה קורה אם אני רוצה בדיוק לעלות על מישהו. אז לבדוק

    //matrix looks upside down
    /*

    (0,0) (0,1) (0,2) (0,3) (0,4) (0,5) (0,6) (0,7)
    (1,0) (1,1) (1,2) (1,3) (1,4) (1,5) (1,6) (1,7)
    (2,0) (2,1) (2,2) (2,3) (2,4) (2,5) (2,6) (2,7)
    (3,0) (3,1) (3,2) (3,3) (3,4) (3,5) (3,6) (3,7)
    (4,0) (4,1) (4,2) (4,3) (4,4) (4,5) (4,6) (4,7)
    (5,0) (5,1) (5,2) (5,3) (5,4) (5,5) (5,6) (5,7)
    (6,0) (6,1) (6,2) (6,3) (6,4) (6,5) (6,6) (6,7)
    (7,0) (7,1) (7,2) (7,3) (7,4) (7,5) (7,6) (7,7)

     */
    //dia for diagonal


    //checks if possible to move diagonal up, left without going over someone;
    private boolean diaUpLeft(Position dst, Board board)
    {
        for(int i =  1 ; i <Math.abs(dst.getCol()-this.pos.getCol()) -1; i++)
        {
            if(board.getBoard(new Position(this.pos.getRow() - i, this.pos.getCol() - i)) != null)
                return false;
        }

        return true;
    }

    //checks if possible to move diagonal down, left without going over someone;
    private boolean diaDownLeft(Position dst, Board board)
    {
        for(int i =  1 ; i < Math.abs(dst.getCol()-this.pos.getCol()) -1; i++)
        {
            if(board.getBoard(new Position(this.pos.getRow() - i, this.pos.getCol() + i)) != null)
                return false;
        }
        return true;
    }

    //checks if possible to move diagonal down, right without going over someone;
    private boolean diaDownRight(Position dst, Board board)
    {
        for(int i = 0 ; i < Math.abs(dst.getCol()-this.pos.getCol()); i++)
        {
            if (board.getBoard(new Position(this.pos.getRow() + i, this.pos.getCol() + i)) != null)
                return false;
        }
        return true;
    }

    //checks if possible to move diagonal up, right without going over someone;
    private boolean diaUpRight(Position dst, Board board)
    {

        for(int i=1;i<Math.abs(dst.getCol()-this.pos.getCol());i++)
        {
            if(board.getBoard(new Position(this.pos.getRow() + i, this.pos.getCol() - i))!=null)
                return false;
        }
        return true;
    }


    //checks if possible to move straight right without going over someone;
    private boolean checkRight(Board board, Position dst)
    {
        // loops from the current position to dst position
        for(int i = 1 ; i < (dst.getCol() - this.pos.getCol() - 1); i++ )
        {
            // does the way  between the dsttination and current blocked?
            if (board.getBoard(new Position(this.pos.getRow() , this.pos.getCol()+ i)) != null)
                return false;
        }
        return true;
    }

    //checks if possible to move straight left without going over someone;
    private boolean checkLeft(Board board, Position dst)
    {
        for(int i = 1 ; i < (this.pos.getCol() -dst.getCol() - 1); i++ )
        {
            // does the way  between the dsttination and current blocked?
            if (board.getBoard(new Position(this.pos.getRow(), this.pos.getCol() - i)) != null) {
                return false;
            }
        }
        return true;
    }

    //checks if possible to move straight up without going over someone;
    private boolean checkUp(Board board, Position dst)
    {
        // loops from the current position to dst position
        for(int i = 1 ; i < (dst.getRow() - this.pos.getRow() - 1); i++ )
        {
            // does the way  between the dsttination and current blocked?
            if (board.getBoard(new Position(this.pos.getCol() -i , this.pos.getRow())) != null)
                return false;
        }
        return true;
    }

    //checks if possible to move straight down without going over someone;
    private boolean checkDown(Board board, Position dst)
    {
        // loops from the current position to dst position
        for(int i = 1 ; i < (dst.getRow() - this.pos.getRow() - 1); i++ )
        {
            // does the way  between the dsttination and current blocked?
            if (board.getBoard(new Position(this.pos.getCol() + i , this.pos.getRow())) != null)
                return false;
        }
        return true;
    }


    // returns true if player made a legal diagonal move;
    private boolean movingDiagonal(Board board, Position dst)
    {
        // Up and Right
        if(this.pos.isMoveRight(dst) && this.pos.isMoveUp(dst))
        {
            diaDownLeft(dst, board);
        }

        // Up and Left
        if(this.pos.isMoveLeft(dst) && this.pos.isMoveUp(dst))
        {
            return diaUpLeft(dst, board);
        }


        // Down and left
        if(this.pos.isMoveRight(dst) && this.pos.isMoveDown(dst))
        {
            return diaUpRight(dst, board);
        }

        // Down and Right
        if(this.pos.isMoveRight(dst) && this.pos.isMoveDown(dst))
        {
            return diaDownRight(dst, board);
        }
        return false;


    }

    // returns true if player made a legal straight move;
    private boolean movingStraight(Board board, Position dst)
    {
        if(this.pos.isMoveRow(dst))
        {
            if(this.pos.isMoveRight(dst))
            {
                return checkRight(board, dst);
            }


            else
            {
                return checkLeft(board, dst);

            }

        }

        else
        {

            if(this.pos.isMoveUp(dst))
            {
                return checkUp(board, dst);
            }

            else
            {
                return checkDown(board, dst);
            }


        }
    }





}
