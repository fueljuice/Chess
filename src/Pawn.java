public class Pawn extends Piece
{

    public Pawn(int row, int col, boolean color)
    {
        super(row, col ,color);
    }

    // did you kill someone? ( only in special case)
    // are you in bounds?
    // legal movement?

    @Override
    public boolean isValid(Board board, Position dst)
    {
        //in bound?
        if(dst.isOutBound()) return false;

        if(!this.pos.didMove(dst))
        {
            return false;
        }

        //did the pawn kill?
        if(  isKill( board, dst))
        {
            return true;
        }

        //checks special move legality
        if(isSpecial(dst))
        {
            if(board.getBoard(this.pos.incNewPos(1,0) )== null)
                return true;
        }
        // is legal?

        return Math.abs(this.pos.getRow() - dst.getRow()) == 1 && this.pos.getCol() == dst.getCol();

    }

    private boolean isSpecial(Position dst)
    {
        //black is false, white is true
        if( (this.pos.getRow() == 1 && this.color) || (this.pos.getRow() == 6 && !this.color) )
        {
            return (Math.abs(this.pos.getRow() - dst.getRow())  == 2);
        }
        
        return false;
    }



    private boolean isKill(Board board, Position dst)
    {
        if(dst.getRow()-1==this.pos.getRow())
        {
            if(dst.getCol()-1==this.pos.getCol()||dst.getCol()+1==this.pos.getCol())
            {
                return board.getBoard(dst) != null;
            }
        }
        return false;
    }








}
