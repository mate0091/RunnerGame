package M8W.OOP.Game.RunnerGame;

import M8W.OOP.Game.Engine.GameObject;
import M8W.OOP.Game.Engine.Input;
import M8W.OOP.Game.Engine.Transform;
import M8W.OOP.Game.Graphics.Animation;
import M8W.OOP.Game.Graphics.AnimationSprite;
import M8W.OOP.Game.Graphics.ImageLoader;
import M8W.OOP.Game.Graphics.SpriteSheet;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject
{
    private static final int MAX_SPEED = 13;
    private int gravity = 2;
    public boolean jumping = false;
    public boolean grounded = false;
    private Transform velocity;

    private Animation anim;
    private AnimationSprite[] sprites;

    Player()
    {
        super();

        loadAnimation();

        velocity = new Transform(0, 0);

        position.set(50, 250);
        collisionBox.setLocation(50, 250);
    }

    private void loadAnimation()
    {
        SpriteSheet sheet = new SpriteSheet("/player.png");
        sprites = new AnimationSprite[2];

        sprites[0] = new AnimationSprite(0, sheet.imageAt(0, 0, 16, 16).getScaledInstance(50, 50, Image.SCALE_DEFAULT), 20);
        sprites[1] = new AnimationSprite(1, sheet.imageAt(1, 0, 16, 16).getScaledInstance(50, 50, Image.SCALE_DEFAULT), 20);

        anim = new Animation(sprites);
    }

    public void update()
    {
        super.update();

        if(!grounded)
        {
            velocity.translate(0, gravity);

            if (velocity.getY() > MAX_SPEED)
            {
                velocity.setY(MAX_SPEED);
            }
        }

        else
        {
            if(Input.getInstance().getKeyDown(KeyEvent.VK_UP))
            {
                velocity.setY(-30);
                grounded = false;
            }
        }

        position.translate(velocity);

        anim.updateFrames();
    }

    public void collideWithGround(int x1, int y1, int x2, int y2)
    {
        if(collisionBox.intersects(x1, y1, x2, y2))
        {
            position.setY(y1 - collisionBox.height);
            velocity.setY(0);
            grounded = true;
        }
    }

    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(anim.getCurrentSprite().getImage(), position.getX(), position.getY(), null);

        g2.setColor(Color.RED);
        g2.draw(collisionBox);
    }
}
