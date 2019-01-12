package M8W.OOP.Game.Engine;

import java.awt.*;

public abstract class GameObject
{
    protected Transform position;
    protected Rectangle collisionBox;

    public GameObject()
    {
        position = new Transform(0, 0);
        collisionBox = new Rectangle(0, 0, 50, 50);
    }

    public void update()
    {
        collisionBox.x = position.getX();
        collisionBox.y = position.getY();
    }

    public abstract void draw(Graphics g);

    public Rectangle getBounds()
    {
        return collisionBox;
    }
}
