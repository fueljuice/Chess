public class Rook extends Piece
{
    public Rook(int row, int col, boolean color)
    {
        super(row, col, color);

    }

    @Override
    public String getTitle()
    {
        return "Rook";
    }



    @Override
    public boolean isValid(Board board, Position dst)
    {
        if(!generalCheck(board, dst))
            return false;


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




}
