package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.Transform;

import java.awt.*;

public class HighObstacle extends Obstacle
{
    //setup sprites


    public HighObstacle(Transform velocity)
    {
        super(velocity);

        this.position.setY(450);
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
