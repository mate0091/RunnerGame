package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.GameScreen;
import M8W.OOP.Game.Engine.GameState;
import M8W.OOP.Game.Engine.GameStateManager;
import M8W.OOP.Game.Engine.Input;
import M8W.OOP.Game.Graphics.ImageLoader;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverState extends GameState
{
    private Image background;
    private String[] texts = {"Retry", "Exit"};
    private int currentChoice;

    public GameOverState()
    {
        super();

        background = new ImageLoader().load("/game_over.png").getScaledInstance(GameScreen.WIDTH, GameScreen.HEIGHT, Image.SCALE_DEFAULT);
        currentChoice = 0;
    }

    @Override
    public void update()
    {
        if(Input.getInstance().getKeyDown(KeyEvent.VK_DOWN) && currentChoice != 1)
        {
            currentChoice++;
        }

        else if(Input.getInstance().getKeyDown(KeyEvent.VK_UP) && currentChoice != 0)
        {
            currentChoice--;
        }

        if(Input.getInstance().getKeyDown(KeyEvent.VK_ENTER))
        {
            if(currentChoice == 0)
            {
                GameStateManager.getInstance().changeState(new LevelState());
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
            g.drawString(texts[i], GameScreen.WIDTH / 2 - 48, GameScreen.HEIGHT / 2 + 240 + 75 * i);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 35));
        g.drawString("Your score: " + ScoreManager.getInstance().getScore(), GameScreen.WIDTH/2 - 100, GameScreen.HEIGHT/2 + 50);

        if(ScoreManager.getInstance().newHighScoreObtained())
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 35));
            g.drawString("New Highscore", GameScreen.WIDTH/2 - 120, GameScreen.HEIGHT/2 + 120);
        }

        else
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 35));
            g.drawString("Highscore: " + ScoreManager.getInstance().getHighScore(), GameScreen.WIDTH/2 - 110, GameScreen.HEIGHT/2 + 120);
        }
    }
}
