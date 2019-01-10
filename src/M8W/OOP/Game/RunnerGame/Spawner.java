package M8W.OOP.Game.RunnerGame;

import java.awt.*;

public class Spawner extends GameObject
{
    //use this to specify after how many seconds the first obstacle appears

    private int constantSpeedup;
    private int deltaBetweenObstacles;

    private Runnable ObstacleSpawner;

    private Timer timer;

    public Spawner(Runnable ObstacleSpawner, int delta, int speedup)
    {
        super();

        this.ObstacleSpawner = ObstacleSpawner;

        deltaBetweenObstacles = delta;
        constantSpeedup = speedup;

        timer = new Timer(deltaBetweenObstacles, Timer.Type.Once, () -> ObstacleSpawner.run());
    }

    public void update()
    {
        super.update();

        timer.update();

        if(timer.isDone())
        {
            if(deltaBetweenObstacles > 10)
            {
                deltaBetweenObstacles -= constantSpeedup;
            }

            timer = new Timer(deltaBetweenObstacles, Timer.Type.Once, () -> ObstacleSpawner.run());
        }
    }

    public void draw(Graphics g)
    {
        timer.draw(g);
    }
}
