package M8W.OOP.Game.Graphics;

import java.awt.*;

public class AnimationSprite
{
    private int index;
    private Image image;
    private int frameCount;

    public AnimationSprite(int index, Image image, int frameCount)
    {
        this.image = image;
        this.frameCount = frameCount;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Image getImage() {
        return image;
    }

    public int getFrameCount() {
        return frameCount;
    }
}
