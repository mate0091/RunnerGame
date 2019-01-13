package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.GameObject;
import M8W.OOP.Game.Engine.Timer;
import M8W.OOP.Game.Engine.Transform;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Spawner extends GameObject
{
    //use this to specify after how many seconds the first obstacle appears

    private float deltaBetweenObstacles;
    private float constantSpeedup;
    private float currentSpeed;
    private boolean isDone;
    private float deltaSpeedup;

    private Timer timer;

    public Spawner(int startDelta, float delta, float constantSpeedup, int startSpeed, float deltaSpeedup)
    {
        super();

        this.constantSpeedup = constantSpeedup;
        this.deltaBetweenObstacles = delta;
        this.currentSpeed = startSpeed;
        this.deltaSpeedup = deltaSpeedup;

        this.isDone = false;

        timer = new Timer(startDelta);
    }

    public void update()
    {
        isDone = false;

        super.update();
        timer.update();

        if(timer.isDone())
        {
            //message LevelState to add the generated obstacle to the level
            isDone = true;

            if(currentSpeed < 20)
                currentSpeed += constantSpeedup;

            if(deltaBetweenObstacles > 3.5f)
                deltaBetweenObstacles -=  (deltaSpeedup);

            timer = new Timer((int) (deltaBetweenObstacles));
        }
    }

    public void draw(Graphics g)
    {

    }

    public boolean getIsDone() {
        return isDone;
    }

    public Timer getTimer() {
        return timer;
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }
}
