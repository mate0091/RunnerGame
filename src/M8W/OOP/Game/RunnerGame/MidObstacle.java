package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.Transform;

import java.awt.*;

public class MidObstacle extends Obstacle
{
    public MidObstacle(Transform velocity)
    {
        super(velocity);

        this.position.setY(500);
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
