import java.lang.*;

public class ClassicGame implements GameFactory {

    public String title = "Classic";

    public ClassicGame()
    {
        createGame();
    }

    public void createGame()
    {
    }

    public String getTitle()
    {
        return this.title;
    }
}
