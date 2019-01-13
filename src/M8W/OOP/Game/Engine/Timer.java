package M8W.OOP.Game.Engine;

import M8W.OOP.Game.Engine.GameObject;
import M8W.OOP.Game.Engine.GameScreen;

import java.awt.*;

public class Timer extends GameObject
{
    private long currentTime = 0L;
    private long coolDown;
    private boolean terminated = false;
    private int amount = 0;
    private int currentAmount = 0;

    public Timer(int deciSeconds)
    {
        coolDown = deciSeconds * 6L * GameScreen.targetTime;
        position.set(60, 60);
    }

    public void update()
    {
        super.update();

        currentTime += GameScreen.targetTime;

        if(currentTime >= coolDown)
        {
            currentTime = 0;
            fireEvent();
            currentAmount++;
        }

    }

    private void fireEvent()
    {
        if(currentAmount == amount) terminated = true;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString(Long.toString(currentTime), position.getX(), position.getY());

        if(terminated)
        {
            g.drawString("Terminated", position.getX() + 100, position.getY());
        }
    }

    public boolean isDone()
    {
        return terminated;
    }
}
