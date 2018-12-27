package M8W.OOP.Game.RunnerGame;

import javax.swing.*;
import java.awt.*;

public class Game
{
    private JFrame window;
    private GameScreen screen;

    private Game()
    {
        window = new JFrame("Runner Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(new BorderLayout());
        screen = new GameScreen();
        window.add(screen, BorderLayout.CENTER);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String args[])
    {
        new Game();
    }
}
