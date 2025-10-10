public class Knight extends Piece
{

    public Knight(int row, int col, boolean color)
    {
        super(row, col ,color);
    }

    @Override
    public String getTitle()
    {
        return "Knight";
    }

    @Override
    public boolean isValid(Board board, Position dst)
    {
        if(!this.generalCheck(board, dst))
            return false;

        if(this.pos.isOutBound())
            return false;

        if(!this.pos.didMove(dst))
        {
            return false;
        }

        if(this.pos.isMoveUp(dst) && isJumpUp(dst))
            return true;

        if(this.pos.isMoveDown(dst) && isJumpUp(dst))
            return true;

        if(this.pos.isMoveRight(dst) && isJumpUp(dst))
            return true;

        return this.pos.isMoveLeft(dst) && isJumpUp(dst);
    }

    private boolean isJumpUp(Position dst) {
        if (this.pos.getRow() + 2 == dst.getRow())
        {
            return Math.abs(this.pos.getCol() - dst.getCol()) == 1;
        }
        return false;
    }

    private boolean isJumpDown(Position dst)
    {
        if(this.pos.getRow() - 2 == dst.getRow())
        {
            return Math.abs(this.pos.getCol() - dst.getCol()) == 1;
        }
        return false;
    }


    private boolean isJumpRight(Position dst) {
        if (this.pos.getCol() + 2 == dst.getCol()) {
            return Math.abs(this.pos.getRow() - dst.getRow()) == 1;
        }
        return false;
    }

    private boolean isJumpLeft(Position dst) {
        if (this.pos.getCol() - 2 == dst.getCol()) {
            return Math.abs(this.pos.getRow() - dst.getRow()) == 1;
        }
        return false;
    }




}
