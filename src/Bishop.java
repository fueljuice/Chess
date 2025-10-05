public class Bishop extends Piece
{
    public Bishop(int row, int col, boolean color)
    {
        super(row, col, color);
    }

    @Override
    public boolean isValid(Board board, Position dst)
    {
        if(!generalCheck(dst))
            return false;

        if(!this.pos.didMove(dst))
        {
            return false;
        }

        // isDiagonal?
            if(!this.pos.isMoveDiagonal(dst))
                return false;

        // Upper left diagonal
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

        // Up and Right
        return diaDownLeft(dst, board);
    }

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


    /// // תזכורת לבדוק אם זה תקין. בגלל מה קורה אם אני רוצה בדיוק לעלות על מישהו. אז לבדוק
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












}
