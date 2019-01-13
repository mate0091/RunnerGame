package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.GameScreen;
import M8W.OOP.Game.Engine.Transform;
import M8W.OOP.Game.Graphics.SpriteSheet;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class LowObstacle extends Obstacle
{
    private SpriteSheet spr;

    private Image img;

    public LowObstacle(Transform velocity)
    {
        super(velocity);

        spr = new SpriteSheet("/obstacle_spr.png");

        int sel = ThreadLocalRandom.current().nextInt(4);

        switch(sel)
        {
            case 0:
                img = spr.imageAt(2, 1, 16, 16).getScaledInstance(64, 64, Image.SCALE_DEFAULT);
                break;
            case 1:
                img = spr.imageAt(0, 2, 16, 16).getScaledInstance(64, 64, Image.SCALE_DEFAULT);
                break;
            case 2:
                img = spr.imageAt(1, 2, 16, 16).getScaledInstance(64, 64, Image.SCALE_DEFAULT);
                break;
            case 3:
                img = spr.imageAt(2, 2, 16, 16).getScaledInstance(64, 64, Image.SCALE_DEFAULT);
                break;

        }

        collisionBox.setBounds(0, 0, 64, 64);

        this.position.setY(600 - 64);
    }

    public void update()
    {
        super.update();
    }

    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(img, position.getX(), position.getY(), null);
    }
}
