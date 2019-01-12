package M8W.OOP.Game.Engine;

import M8W.OOP.Game.Engine.GameState;
import M8W.OOP.Game.RunnerGame.MainMenuState;

import java.util.Stack;
import java.awt.Graphics;

public class GameStateManager
{
    private Stack<GameState> statesLoaded;

    public GameStateManager()
    {
        statesLoaded = new Stack<GameState>();
        this.loadState(new MainMenuState(this));
    }

    public void update()
    {
        statesLoaded.peek().update();
    }

    public void paintComponent(Graphics g)
    {
        statesLoaded.peek().draw(g);
    }

    public void loadState(GameState state)
    {
        statesLoaded.push(state);
    }

    public void unLoadState()
    {
        statesLoaded.remove(0);
    }

    public GameState getCurrentState()
    {
        return statesLoaded.peek();
    }

    public void changeState(GameState state)
    {
        loadState(state);
        unLoadState();
    }
}
