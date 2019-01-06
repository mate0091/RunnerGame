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

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Quit anytime by pressing ESC", GameScreen.WIDTH/2 - 150, GameScreen.HEIGHT/2 + 390);
    }
}
