package M8W.OOP.Game.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader
{
    public BufferedImage load(String path)
    {
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
}
