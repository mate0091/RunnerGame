package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.GameScreen;
import M8W.OOP.Game.Engine.Transform;
import M8W.OOP.Game.Graphics.Animation;
import M8W.OOP.Game.Graphics.AnimationSprite;
import M8W.OOP.Game.Graphics.SpriteSheet;

import java.awt.*;

public class HighObstacle extends Obstacle
{
    //setup sprites, animation
    private Animation anim;
    private AnimationSprite[] sprites;
    private SpriteSheet spr;


    public HighObstacle(Transform velocity)
    {
        super(velocity);

        loadAnimation();

        collisionBox.setBounds(0, 0, 64, 64);

        this.position.setY(390);
    }

    private void loadAnimation()
    {
        spr = new SpriteSheet("/obstacle_spr.png");
        sprites = new AnimationSprite[3];

        sprites[0] = new AnimationSprite(0, spr.imageAt(2, 0, 16, 16).getScaledInstance(64, 64, Image.SCALE_DEFAULT), 15);
        sprites[1] = new AnimationSprite(1, spr.imageAt(0, 1, 16, 16).getScaledInstance(64, 64, Image.SCALE_DEFAULT), 15);
        sprites[2] = new AnimationSprite(2, spr.imageAt(1, 1, 16, 16).getScaledInstance(64, 64, Image.SCALE_DEFAULT), 15);

        anim = new Animation(sprites);
    }

    public void update()
    {
        super.update();
        anim.updateFrames();
    }

    public void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(anim.getCurrentSprite().getImage(), position.getX(), position.getY(), null);
    }
}
