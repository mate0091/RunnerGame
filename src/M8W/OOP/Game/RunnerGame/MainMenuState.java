package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Graphics.ImageLoader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class MainMenuState extends GameState
{
    private int selection = 0;

    private String[] texts = {"Play game", "Exit"};

    private Image background;

    private int currentChoice = 0;

    MainMenuState(GameStateManager gs)
    {
        super(gs);

        ImageLoader il = new ImageLoader();

        BufferedImage temp = il.load("/main_menu.png");

        background = temp.getScaledInstance(GameScreen.WIDTH, GameScreen.HEIGHT, Image.SCALE_DEFAULT);
    }

    @Override
    public void update()
    {
        if(currentChoice == 2)
        {
            currentChoice = 1;
        }

        else if(currentChoice == -1)
        {
            //set to beginning
            currentChoice = 0;
        }

        if(Input.getKeyDown(KeyEvent.VK_DOWN))
        {
            currentChoice++;
        }

        else if(Input.getKeyDown(KeyEvent.VK_UP))
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

        if(Input.getKeyDown(KeyEvent.VK_ESCAPE))
        {
            System.exit(0);
        }
    }

    @Override
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
            g.drawString(texts[i], GameScreen.WIDTH / 2 - 75, GameScreen.HEIGHT / 2 + 135 + 75 * i);
        }
    }
}
