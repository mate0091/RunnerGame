package M8W.OOP.Game.RunnerGame;

import java.awt.*;

public class Obstacle extends GameObject
{
    private Transform velocity;

    Obstacle()
    {
        super();
        position.set(GameScreen.WIDTH + 20, 550);
        collisionBox.setLocation(GameScreen.WIDTH + 20, 550);
        velocity = new Transform(-5, 0);
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