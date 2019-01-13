package M8W.OOP.Game.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private BufferedImage image;

    public SpriteSheet(String path)
    {
        this.image = new ImageLoader().load(path);
    }

    public BufferedImage imageAt(int c, int r, int w, int h)
    {
        return this.image.getSubimage(c * w, r * h, w, h);
    }
}
