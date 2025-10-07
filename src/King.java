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

    private boolean isSafeDiagnoul(Board board, Position dst)
    {

        return true;
    }

    private boolean iSafeStraight(Board board, Position dst)
    {
        Piece cur;
        for(int i = 1; i < Math.abs(this.pos.getCol() - dst.getCol()) - 1 ; i++)
        {
            cur = board.getBoard(new Position(this.pos.getCol(), this.pos.getRow()));
            if(board.getBoard(new Position(this.pos.getCol(), this.pos.getRow())) != null)
            {
                if(cur.isValid(board, this.pos))
                    return false;

            }
        }
        return true;
    }



}
