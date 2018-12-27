package M8W.OOP.Game.RunnerGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenuState extends GameState
{
    private int selection = 0;

    private String[] texts = {"Play game", "Exit"};

    MainMenuState(GameStateManager gs)
    {
        super(gs);
    }

    @Override
    public void update()
    {
        if(Input.getKeyDown(KeyEvent.VK_SPACE))
        {
            System.out.println("SPACE PRESSED");

            gs.changeState(new LevelState(gs));
        }

        else if(Input.getKeyDown(KeyEvent.VK_ENTER))
        {
            System.out.println("EXIT");

            System.exit(0);
        }
    }

    @Override
    public void draw(Graphics g)
    {
        for (int i = 0; i < texts.length; i++)
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 50));
            g.drawString(texts[i], GameScreen.WIDTH / 2 - 125, GameScreen.HEIGHT / 2 - 100 + 150 * i);
        }
    }
}
