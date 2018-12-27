package M8W.OOP.Game.RunnerGame;

import java.awt.*;
import java.awt.event.KeyListener;

public abstract class GameState
{
    protected GameStateManager gs;

    protected GameState(GameStateManager gs)
    {
        this.gs = gs;
    }

    abstract void update();
    abstract void draw(Graphics g);
}
