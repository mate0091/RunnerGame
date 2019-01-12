package M8W.OOP.Game.Engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public final class Input implements KeyListener
{
    private class Key
    {
        private boolean down;

        public Key()
        {
            down = false;
        }

        public boolean isDown()
        {
            return down;
        }

        public void trigger(boolean value)
        {
            down = value;
        }
    }

    private static final Input INSTANCE = new Input();

    private Key spaceKey;
    private Key upKey;
    private Key downKey;
    private Key enterKey;
    private Key escapeKey;

    private Input()
    {
        spaceKey = new Key();
        upKey = new Key();
        downKey = new Key();
        enterKey = new Key();
        escapeKey = new Key();
    }

    public static Input getInstance()
    {
        return INSTANCE;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case VK_SPACE:
                spaceKey.trigger(true);
                break;
            case VK_UP:
                upKey.trigger(true);
                break;
            case VK_DOWN:
                downKey.trigger(true);
                break;
            case VK_ENTER:
                enterKey.trigger(true);
                break;
            case VK_ESCAPE:
                escapeKey.trigger(true);
                break;
                default:
                    break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case VK_SPACE:
                spaceKey.trigger(false);
                break;
            case VK_UP:
                upKey.trigger(false);
                break;
            case VK_DOWN:
                downKey.trigger(false);
                break;
            case VK_ENTER:
                enterKey.trigger(false);
                break;
            case VK_ESCAPE:
                escapeKey.trigger(false);
                break;
            default:
                break;
        }
    }

    public boolean getKeyDown(int value)
    {
        boolean current = false;

        switch (value)
        {
            case VK_SPACE:
                current = spaceKey.isDown();
                break;
            case VK_UP:
                current = upKey.isDown();
                break;
            case VK_DOWN:
                current = downKey.isDown();
                break;
            case VK_ENTER:
                current = enterKey.isDown();
                break;
            case VK_ESCAPE:
                current = escapeKey.isDown();
                break;
            default:
                break;
        }

        return current;
    }
}
