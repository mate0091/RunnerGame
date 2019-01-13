package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.GameScreen;
import M8W.OOP.Game.Engine.Transform;
import M8W.OOP.Game.Graphics.SpriteSheet;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class MidObstacle extends Obstacle
{
    private SpriteSheet spr;

    private Image[] img;

    public MidObstacle(Transform velocity)
    {
        super(velocity);

        img = new Image[2];

        spr = new SpriteSheet("/obstacle_spr.png");

        int sel = ThreadLocalRandom.current().nextInt(2);

        switch(sel)
        {
            case 0:
                img[0] = spr.imageAt(0, 0, 16, 16).getScaledInstance(64, 64, Image.SCALE_DEFAULT);
                img[1] = spr.imageAt(3, 0, 16, 16).getScaledInstance(64, 64, Image.SCALE_DEFAULT);
                break;
            case 1:
                img[0] = spr.imageAt(1, 0, 16, 16).getScaledInstance(64, 64, Image.SCALE_DEFAULT);
                img[1] = spr.imageAt(3, 1, 16, 16).getScaledInstance(64, 64, Image.SCALE_DEFAULT);
                break;
            default:
                break;
        }

        collisionBox.setBounds(0, 0, 64, 128);

        this.position.setY(600 - 128);
    }

    public void update()
    {
        super.update();
    }

    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(img[0], position.getX(), position.getY(), null);
        g2d.drawImage(img[1], position.getX(), position.getY() + 64, null);
    }
}
