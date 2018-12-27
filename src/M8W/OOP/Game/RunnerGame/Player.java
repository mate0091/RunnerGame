package M8W.OOP.Game.RunnerGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject
{
    Player()
    {
        super();
    }

    @Override
    public void update()
    {
        if(Input.getKeyDown(KeyEvent.VK_DOWN))
        {
            position.translate(0, 3);
        }

        else if (Input.getKeyDown(KeyEvent.VK_UP))
        {
            position.translate(0, -3);
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(position.getX() - 25, position.getY() - 25, 50, 50);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("Position: ", 0, 25);
        g.drawString(Integer.toString(position.getX()), 100, 25);
        g.drawString(Integer.toString(position.getY()), 150, 25);
    }
}
