public class Position
{
    // **THE CLASS DOESN'T CONSIDER NO MOVEMENT**
    public final int GRID = 8;
    private int row, col;
    public Position(int row, int col)
    {
        this.row=row;
        this.col=col;
    }
    //return row
    public int getRow()
    {
        return this.row;
    }
    //returns col
    public int getCol()
    {
        return this.row;
    }

    //set row
    public void setRow(int row)
    {
        this.row=row;
    }

    //set col
    public void setCol(int col)
    {
        this.col=col;
    }

    //checks if out of bound
    public boolean isOutBound()
    {
        if(this.col>=0 && this.col<GRID)
        {
            if(this.row>=0 && this.row<GRID)
            {
                return true;
            }
        }
        return false;
    }

    // checks if moves on a row
    public boolean isMoveRow(Position des)
    {
        // moves in a row?
        return des.row == this.row;
    }
    // checks if moves on a col
    public boolean isMoveCol(Position des)
    {
        // moves in a row?
        return des.col == this.col ;
    }


    //checks if moves right
    public boolean isMoveRight(Position des)
    {
        return des.row > this.row;
    }
    //checks if moves left
    public boolean isMoveLeft(Position des)
    {
        return des.row < this.row;
    }
    // checks if moves up
    public boolean isMoveUp(Position des)
    {
        return des.col > this.col;
    }
    // checks if moves down
    public boolean isMoveDown(Position des)
    {
        return des.col < this.col;
    }

    public boolean didMove(Position dst)
    {
        return this.row==dst.row || this.col!=dst.col;
    }

    public Position incNewPos(int rowInc, int colInc)
    {
        return new Position(this.row+rowInc, this.col+colInc);
    }


    public boolean isMoveDiagonal(Position dst)
    {
        if (Math.abs(this.col-dst.col)==Math.abs(this.row-dst.row))
        {
            return true;
        }
        return false;
    }

    public boolean isMoveStraight(Position dst)
    {
        return isMoveCol(dst) || isMoveRow(dst);
    }




}
