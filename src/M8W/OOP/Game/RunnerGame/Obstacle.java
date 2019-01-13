package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.GameObject;
import M8W.OOP.Game.Engine.GameScreen;
import M8W.OOP.Game.Engine.Transform;

import java.awt.*;

public class Obstacle extends GameObject
{
    protected Transform velocity;
    public boolean wasJumpedOver;

    public Obstacle(Transform velocity)
    {
        super();
        position.set(GameScreen.WIDTH + 20, 550);
        collisionBox.setLocation(GameScreen.WIDTH + 20, 550);
        this.velocity = velocity;
        wasJumpedOver = false;
    }

    public void update()
    {
        super.update();

        position.translate(velocity);
    }

    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.RED);
        g2.draw(collisionBox);

        g2.setColor(Color.BLACK);
        g2.fillRect(position.getX(), position.getY(), 50, 50);
    }
}
