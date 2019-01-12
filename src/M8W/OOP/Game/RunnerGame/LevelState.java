package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class LevelState extends GameState
{
    private Player p;
    private ArrayList<Obstacle> obstacles;

    private Spawner spawner;

    public LevelState(GameStateManager gsm)
    {
        super(gsm);

        ScoreManager.getInstance().resetScore();
        p = new Player();
        obstacles = new ArrayList<Obstacle>();

        spawner = new Spawner(() ->{
            //spawn enemies
            obstacles.add(new Obstacle(new Transform(-5, 0)));
        }, 20, 2);
    }

    @Override
    public void update()
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
                    if (obstacles.get(i).getBounds().x + obstacles.get(i).getBounds().width < -100)
                    {
                        ScoreManager.getInstance().incrementScore();
                        obstacles.remove(i);
                    }
                }
            }

        spawner.update();

        if (Input.getKeyDown(KeyEvent.VK_ESCAPE)) {
            gs.changeState(new MainMenuState(gs));
        }
    }

    public void obstacleCollision(GameObject other)
    {
        if(p.getBounds().intersects(other.getBounds()))
        {
            ScoreManager.getInstance().saveScore();
            gs.changeState(new MainMenuState(gs));
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 35));
        g.drawString("Score: " + ScoreManager.getInstance().getScore(), 64, 32);
        g.drawLine(0, 600, GameScreen.WIDTH, 600);

        p.draw(g);

        if(!obstacles.isEmpty())
        for (Obstacle i : obstacles)
            i.draw(g);

        spawner.draw(g);
    }
}
