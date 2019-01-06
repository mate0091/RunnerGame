package M8W.OOP.Game.RunnerGame;

import java.awt.*;

public class LevelState extends GameState
{
    private Player p;
    private Obstacle o;

    LevelState(GameStateManager gsm)
    {
        super(gsm);

        p = new Player();
        o = new Obstacle();
    }
    @Override
    void update()
    {
        //handle collision with other objects here
        p.collideWithGround(0, 600, GameScreen.WIDTH, 600);
        obstacleCollision(o);

        p.update();
        o.update();
    }

    void obstacleCollision(GameObject other)
    {
        if(p.getBounds().intersects(other.getBounds()))
        {
            gs.changeState(new MainMenuState(gs));
        }
    }

    @Override
    void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine(0, 600, GameScreen.WIDTH, 600);
        p.draw(g);
        o.draw(g);
    }
}
