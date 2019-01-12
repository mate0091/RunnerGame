package M8W.OOP.Game.Engine;

import java.awt.*;

public abstract class GameState
{
    protected GameStateManager gs;

    public GameState(GameStateManager gs)
    {
        this.gs = gs;
    }

    public abstract void update();
    public abstract void draw(Graphics g);
}
