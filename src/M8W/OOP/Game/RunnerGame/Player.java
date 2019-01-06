package M8W.OOP.Game.RunnerGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject
{
    private static final int MAX_SPEED = 13;
    private int gravity = 2;
    public boolean jumping = false;
    public boolean grounded = false;
    private Transform velocity;

    Player()
    {
        super();

        velocity = new Transform(0, 0);

        position.set(50, 250);
        collisionBox.setLocation(50, 250);
    }

    public void update()
    {
        super.update();

        position.translate(velocity);

        if(!grounded)
        {
            velocity.translate(0, gravity);

            if (velocity.getY() > MAX_SPEED)
            {
                velocity.setY(MAX_SPEED);
            }
        }

        else
        {
            if(Input.getKeyDown(KeyEvent.VK_UP))
            {
                velocity.setY(-30);
                grounded = false;
            }
        }
    }

    public void collideWithGround(int x1, int y1, int x2, int y2)
    {
        if(collisionBox.intersects(x1, y1, x2, y2))
        {
            position.setY(y1 - collisionBox.height);
            velocity.setY(0);
            grounded = true;
        }
    }

    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLUE);
        g2.fillRect(position.getX(), position.getY(), 50, 50);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.PLAIN, 25));
        g2.drawString("Position: ", 0, 25);
        g2.drawString(Integer.toString(position.getX()), 100, 25);
        g2.drawString(Integer.toString(position.getY()), 150, 25);

        g2.setColor(Color.RED);
        g2.draw(collisionBox);
    }
}
