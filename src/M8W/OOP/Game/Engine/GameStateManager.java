package M8W.OOP.Game.Engine;

import M8W.OOP.Game.Engine.GameState;
import M8W.OOP.Game.RunnerGame.MainMenuState;

import java.util.Stack;
import java.awt.Graphics;

public final class GameStateManager
{
    private Stack<GameState> statesLoaded;

    private static final GameStateManager INSTANCE = new GameStateManager();

    private GameStateManager()
    {
        statesLoaded = new Stack<GameState>();
        loadState(new MainMenuState());
    }

    public static GameStateManager getInstance()
    {
        return INSTANCE;
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
