public abstract class Piece
{
    protected boolean color; // שחור זה FALSE
    protected Position pos;
// MAJOR FLAW IN ALL THE PIECES: DID NOT CHECK IF THE PIECE EAT THE SAME COLOR AS ITSELF ( also in horse)
// MAJOR FLAW: PIECES NEED TO CHECK IF WHEN THEY MOVE THEY DONT EXPOSE THE KING
// (COULD BE IMPLEMENTED IN PIECE OR BOARD)

// FIXME: FORGOT EN PASSANT

// TODO: CASTLING

    protected abstract boolean isValid(Board board, Position dst); // can it move there?

    protected abstract String getTitle();
    // general purpose constructor
    public Piece(int row, int col, boolean color)
    {
        this.pos = new Position(row, col);
        this.color = color;
    }

    // checks if the player didn't give wierd input
    protected boolean generalCheck(Board board, Position dst)
    {
        // did even move
        if(!this.pos.didMove(dst))
        {
            return false;
        }
        // is in bound
        if (dst.isOutBound())
        {
            return false;
        }

        // did try eat the same color as himself
        if(board.getBoard(dst) != null)
        {
            if (this.color == board.getBoard(dst).color)
                return false;
        }

        return true;
    }

    // false for black, true for white


}
