package M8W.OOP.Game.RunnerGame;

import java.awt.*;
import java.awt.image.BufferedImage;

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
