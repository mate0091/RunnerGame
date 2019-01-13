package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class LevelState extends GameState
{
    private Player p;
    private ArrayList<Obstacle> obstacles;

    private Spawner spawner;

    private Random random;

    public LevelState()
    {
        super();

        random = new Random();

        ScoreManager.getInstance().resetScore();

        p = new Player();
        obstacles = new ArrayList<Obstacle>();

        spawner = new Spawner(20, 20f, 0.2f, 7, 0.2f);
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
            obstacleCollision(o);
        }

        p.update();

        if(!obstacles.isEmpty())
        for (Obstacle i : obstacles) i.update();

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

            System.out.println(spawner.getCurrentSpeed());

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

    public void obstacleCollision(GameObject other)
    {
        if(p.getBounds().intersects(other.getBounds()))
        {
            ScoreManager.getInstance().saveScore();
            GameStateManager.getInstance().changeState(new MainMenuState());
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 35));
        g.drawString("Score: " + ScoreManager.getInstance().getScore(), 64, 32);
        g.drawLine(0, 600, GameScreen.WIDTH, 600);

        spawner.getTimer().draw(g);

        p.draw(g);

        if(!obstacles.isEmpty())
        for (Obstacle i : obstacles)
            i.draw(g);

        spawner.draw(g);
    }
}
