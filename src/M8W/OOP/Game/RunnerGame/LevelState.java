package M8W.OOP.Game.RunnerGame;

import java.awt.*;
import java.util.ArrayList;

public class LevelState extends GameState
{
    private Player p;
    private ArrayList<Obstacle> obstacles;

    private Spawner spawner;

    LevelState(GameStateManager gsm)
    {
        super(gsm);

        p = new Player();
        obstacles = new ArrayList<Obstacle>();

        spawner = new Spawner(() ->{
            //spawn enemies
            obstacles.add(new Obstacle());
        }, 20, 2);
    }
    @Override
    void update()
    {
        //handle collision with other objects here
        p.collideWithGround(0, 600, GameScreen.WIDTH, 600);

        if(!obstacles.isEmpty())
        for(Obstacle o : obstacles)
        {
            obstacleCollision(o);
        }

        p.update();

        if(!obstacles.isEmpty())
        for (Obstacle i : obstacles) i.update();

        if(!obstacles.isEmpty())
            for (int i = 0; i < obstacles.size(); i++)
            {
                if(obstacles.get(i) != null)
                {
                    if (obstacles.get(i).getBounds().x + obstacles.get(i).getBounds().width < -100) {
                        obstacles.remove(i);
                    }
                }
            }

        spawner.update();

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

        if(!obstacles.isEmpty())
        for (Obstacle i : obstacles)
            i.draw(g);

        spawner.draw(g);
    }
}
