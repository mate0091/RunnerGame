package M8W.OOP.Game.Graphics;

public class Animation
{
    private int currentFrame;
    private int currentIndex;
    private AnimationSprite[] sprite;

    public Animation(AnimationSprite[] sprite)
    {
        this.sprite = sprite;
        currentIndex = 0;
        currentFrame = 0;
    }

    public AnimationSprite getCurrentSprite()
    {
        return sprite[currentIndex];
    }

    public void updateFrames()
    {
        if(currentFrame == sprite[currentIndex].getFrameCount())
        {
            currentFrame = 0;

            if(currentIndex == sprite.length - 1)
            {
                currentIndex = 0;
            }

            else currentIndex++;
        }

        currentFrame++;
    }
}
