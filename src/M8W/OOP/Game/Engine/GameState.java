package M8W.OOP.Game.Engine;

import java.awt.*;

public abstract class GameState
{
    public GameState()
    {
    }

    public abstract void update();
    public abstract void draw(Graphics g);
}
