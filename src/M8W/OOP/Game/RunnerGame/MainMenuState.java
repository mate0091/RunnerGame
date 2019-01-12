package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.*;
import M8W.OOP.Game.Graphics.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class MainMenuState extends GameState
{
    private int selection = 0;

    private String[] texts = {"Play game", "Exit"};

    private Image background;

    private int currentChoice = 0;

    public MainMenuState(GameStateManager gs)
    {
        super(gs);

        ImageLoader il = new ImageLoader();

        BufferedImage temp = il.load("/main_menu.png");

        background = temp.getScaledInstance(GameScreen.WIDTH, GameScreen.HEIGHT, Image.SCALE_DEFAULT);
    }

    public void update()
    {
        if(Input.getKeyDown(KeyEvent.VK_DOWN) && currentChoice != 1)
        {
            currentChoice++;
        }

        else if(Input.getKeyDown(KeyEvent.VK_UP) && currentChoice != 0)
        {
            currentChoice--;
        }

        if(Input.getKeyDown(KeyEvent.VK_ENTER))
        {
            if(currentChoice == 0)
            {
                gs.changeState(new LevelState(gs));
            }

            else if(currentChoice == 1)
            {
                System.exit(0);
            }
        }
    }


    public void draw(Graphics g)
    {
        g.drawImage(background, 0, 0, null);

        for (int i = 0; i < texts.length; i++)
        {
            if(i == currentChoice)
            {
                g.setColor(Color.GREEN);
            }

            else g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 35));
            g.drawString(texts[i], GameScreen.WIDTH / 2 - 75, GameScreen.HEIGHT / 2 + 220 + 75 * i);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Quit anytime by pressing ESC", GameScreen.WIDTH/2 - 150, GameScreen.HEIGHT/2 + 390);

        g.setFont(new Font("Arial", Font.BOLD, 35));
        g.drawString("Highscore: " + ScoreManager.getInstance().getHighScore(), GameScreen.WIDTH/2 - 100, GameScreen.HEIGHT/2 + 120);
    }
}
