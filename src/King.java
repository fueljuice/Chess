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

        if(isDanger(board, dst))
            return false;

        return true;
    }

    //check if an enemy piece can eat the king on that square
    private boolean isDanger(Board board,Position dst)
    {

        return true;
    }

    private boolean isDangerDiagnoul(Board board, Position dst)
    {

        return true;
    }

    private boolean isDangerStraight(Board board, Position dst)
    {


        return true;
    }



}
