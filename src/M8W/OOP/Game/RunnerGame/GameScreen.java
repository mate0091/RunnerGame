package M8W.OOP.Game.RunnerGame;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel implements Runnable
{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    private long targetTime = 1000 / 60;

    private Thread th; //thread to limit framerate
    private boolean isRunning = false;
    private GameStateManager stateManager;
    private Input input;

    public GameScreen()
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
        setFocusable(true);

        isRunning = true;
        th = new Thread(this);
        th.start();
    }

    @Override
    public void run()
    {
        input = new Input();
        this.addKeyListener(input);

        stateManager = new GameStateManager();

        while(isRunning)
        {
            //Game loop
            //get current time and last time and do the subtraction
            long now = System.nanoTime();

            update();
            repaint();

            long elapsed = (System.nanoTime() - now) / 1000000;
            long wait = targetTime - elapsed;

            if(wait < 0) wait = 0;

            try
            {
                Thread.sleep(wait);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void update()
    {
        stateManager.update();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.clearRect(0, 0, WIDTH, HEIGHT);

        stateManager.paintComponent(g);
    }

    public boolean getIsRunning()
    {
        return isRunning;
    }
}
