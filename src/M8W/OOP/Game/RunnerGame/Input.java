package M8W.OOP.Game.RunnerGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Input implements KeyListener
{
    public static boolean[] keys = {false, false, false, false, false, false};

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case VK_SPACE:
                keys[0] = true;
                break;
            case VK_UP:
                keys[1] = true;
                break;
            case VK_DOWN:
                keys[2] = true;
                break;
            case VK_ENTER:
                keys[3] = true;
                break;
            case VK_ESCAPE:
                keys[4] = true;
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
                keys[0] = false;
                break;
            case VK_UP:
                keys[1] = false;
                break;
            case VK_DOWN:
                keys[2] = false;
                break;
            case VK_ENTER:
                keys[3] = false;
                break;
            case VK_ESCAPE:
                keys[4] = false;
                break;
            default:
                break;
        }
    }

    public static boolean getKeyDown(int value)
    {
        boolean current = false;

        switch (value)
        {
            case VK_SPACE:
                current = keys[0];
                break;
            case VK_UP:
                current = keys[1];
                break;
            case VK_DOWN:
                current = keys[2];
                break;
            case VK_ENTER:
                current = keys[3];
                break;
            case VK_ESCAPE:
                current = keys[4];
                break;
            default:
                break;
        }

        return current;
    }
}
