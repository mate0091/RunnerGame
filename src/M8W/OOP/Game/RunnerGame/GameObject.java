package M8W.OOP.Game.RunnerGame;

import java.awt.*;

public abstract class GameObject
{
    protected Transform position;

    public GameObject()
    {
        position = new Transform();
    }

    public abstract void update();

    public abstract void draw(Graphics g);
}
