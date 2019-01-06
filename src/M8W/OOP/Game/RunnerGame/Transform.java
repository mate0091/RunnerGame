package M8W.OOP.Game.RunnerGame;

public class Transform
{
    private int x;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int y;

    public Transform(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Transform()
    {
        this(GameScreen.WIDTH / 2, GameScreen.HEIGHT / 2);
    }

    public void translate(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    public void translate(Transform transform)
    {
        this.x += transform.x;
        this.y += transform.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
