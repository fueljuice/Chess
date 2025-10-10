public class Parser
{
    private Position parsedDst;

    public Position getParsedDst()
    {
        return parsedDst;
    }




    // parse user input into commands. for example "Ba4":
    //1. parse "a4" = [3, 0]
    //2. parse B for bishop piece
    //3. check which bishop (or non) can go to [3,0] ("a4")
}
