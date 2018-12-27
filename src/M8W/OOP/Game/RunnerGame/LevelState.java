package M8W.OOP.Game.RunnerGame;

import java.awt.*;

public class LevelState extends GameState
{
    private Player p;

    LevelState(GameStateManager gsm)
    {
        super(gsm);

        p = new Player();
    }
    @Override
    void update()
    {
        p.update();
    }

    @Override
    void draw(Graphics g)
    {
        p.draw(g);
    }
}
