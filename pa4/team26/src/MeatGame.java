import java.lang.*;

public class MeatGame implements GameFactory {

    private String title = "Meatopoly";

    public MeatGame()
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
