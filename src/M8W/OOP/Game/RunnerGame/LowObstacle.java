package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.Transform;

import java.awt.*;

public class LowObstacle extends Obstacle
{
    public LowObstacle(Transform velocity)
    {
        super(velocity);

        this.position.setY(550);
    }

    public void update()
    {
        super.update();
    }

    public void draw(Graphics g)
    {
        super.draw(g);
    }
}
