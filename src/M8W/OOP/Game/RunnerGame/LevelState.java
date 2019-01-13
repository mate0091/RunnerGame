package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.*;
import M8W.OOP.Game.Graphics.ImageLoader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class LevelState extends GameState
{
    private Player p;
    private ArrayList<Obstacle> obstacles;
    private Image background;
    private Spawner spawner;
    private Random random;

    public LevelState()
    {
        super();

        background = new ImageLoader().load("/level_background.png").getScaledInstance(GameScreen.WIDTH, GameScreen.HEIGHT, Image.SCALE_DEFAULT);

        random = new Random();

        ScoreManager.getInstance().resetScore();

        p = new Player();
        obstacles = new ArrayList<Obstacle>();

        spawner = new Spawner(15, 20f, 0.2f, 10, 0.2f);
    }

    @Override
    public void update()
    {
        //handle collision with other objects here
        p.collideWithGround(0, 600, GameScreen.WIDTH, 600);

        spawner.update();

        if(!obstacles.isEmpty())
        for(Obstacle o : obstacles)
        {
            if(o != null) p.collideWithObstacle(o);
        }

        p.update();

        if(!obstacles.isEmpty())
        for (Obstacle i : obstacles)
        {
            if(i != null) i.update();
        }

        if(!obstacles.isEmpty())
            for (int i = 0; i < obstacles.size(); i++)
            {
                Obstacle current = obstacles.get(i);

                if(current != null)
                {
                    if (current.getBounds().x + current.getBounds().width < 0)
                    {
                        obstacles.remove(i);
                    }

                    if(current.getBounds().x < p.getBounds().x && !current.wasJumpedOver)
                    {
                        ScoreManager.getInstance().incrementScore();
                        current.wasJumpedOver = true;
                    }
                }
            }

        if(spawner.getIsDone())
        {
            Obstacle o = null;

            int obstacleIndex = random.nextInt(3);

            switch (obstacleIndex)
            {
                case 0:
                    o = new HighObstacle(new Transform((int) (-spawner.getCurrentSpeed()), 0));
                    break;
                case 1:
                    o = new MidObstacle(new Transform((int) (-spawner.getCurrentSpeed()), 0));
                    break;
                case 2:
                    o = new LowObstacle(new Transform((int) (-spawner.getCurrentSpeed()), 0));
                    break;
                default:
                    break;
            }

            obstacles.add(o);
        }

        if (Input.getInstance().getKeyDown(KeyEvent.VK_ESCAPE)) {
            GameStateManager.getInstance().changeState(new MainMenuState());
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(background, 0, 0, null);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 35));
        g.drawString("Score: " + ScoreManager.getInstance().getScore(), 64, 64);
        g.drawLine(0, 600, GameScreen.WIDTH, 600);

        p.draw(g);

        if(!obstacles.isEmpty())
        for (Obstacle i : obstacles)
            if(i != null) i.draw(g);
    }
}
