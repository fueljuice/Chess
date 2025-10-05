public abstract class Piece
{
    protected boolean color; // שחור זה FALSE
    protected Position pos;

    protected abstract boolean isValid(Board board, Position dst); // can it move there?

    // general purpous constructor
    public Piece(int row, int col, boolean color)
    {
        this.pos = new Position(row, col);
        this.color = color;
    }

    // checks if the player didn't give wierd input
    protected boolean generalCheck(Position dst)
    {
        if (dst.isOutBound())
        {return false;
        }

        return this.pos.didMove(dst);
    }

}
