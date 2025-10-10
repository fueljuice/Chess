public class Board
{
    // TEMPORARY WHEN KING MOVES DELETE KING BEFORE CHECKING FOR A CHECK
    private final int length = 8;
    private final Piece [][] m_Board;
    private boolean state;



    public Board()
    {
        m_Board = new Piece[length][length];
        for(int i = 0 ; i < length ; i++)
        {
            for (int j = 0; j < length ; j++)
            {
                this.m_Board[i][j] = null;
            }
        }
        // make all the board null
        initPawns();

        // put all the pawns on the board


    }
    // returns piece in place it gets
    public Piece getBoard(Position pos)
    {
        return this.m_Board[pos.getRow()][pos.getCol()];
    }

    public void setBoard(Position srcPce, Piece dstPce)
    {
        this.m_Board[dstPce.pos.getRow()][dstPce.pos.getCol()] = dstPce;
        this.m_Board[srcPce.getRow()][srcPce.getCol()] = null;
    }
    
    private void initPawns()
    {
        for(int i = 0 ; i < length ; i++)
        {
            //setBoard(new Pawn(1, i, true));
            //setBoard(new Pawn(7, i, false));
        }
        
        
    }

    public void movePiece(Parser movement)
    {
        if(getBoard(movement.getParsedDst()).isValid(this, movement.getParsedDst()))
        {

        }

    }



}
