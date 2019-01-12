package M8W.OOP.Game.Engine;

import M8W.OOP.Game.Engine.GameObject;
import M8W.OOP.Game.Engine.GameScreen;

import java.awt.*;

public class Timer extends GameObject
{
    private long currentTime = 0L;
    private long coolDown;
    private Runnable function;
    private boolean terminated = false;
    private int amount = 0;
    private int currentAmount = 0;

    public enum Type
    {
        Once(),
        Fixed(),
        Infinite()
    }

    Type type;

    public Timer(int deciSeconds, Type t, Runnable function)
    {
        coolDown = deciSeconds * 6L * GameScreen.targetTime;
        this.function = function;
        position.set(60, 60);
        this.type = t;
    }

    public Timer(int deciSeconds, int repeatAmount, Runnable function)
    {
        this(deciSeconds, Type.Fixed, function);
        amount = repeatAmount - 1;
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
        if(!terminated)  function.run();

        if(currentAmount == amount && type != Type.Infinite) terminated = true;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString(Long.toString(currentTime), position.getX(), position.getY());
    }

    public boolean isDone()
    {
        return terminated;
    }
}
