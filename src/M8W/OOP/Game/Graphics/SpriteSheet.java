package M8W.OOP.Game.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet
{
    private BufferedImage image;

    public SpriteSheet(BufferedImage image)
    {
        this.image = image;
    }

    public SpriteSheet(String path)
    {
        try
        {
            this.image = ImageIO.read(getClass().getResource(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public BufferedImage imageAt(int c, int r, int w, int h)
    {
        return this.image.getSubimage(c * w, r * h, w, h);
    }
}
