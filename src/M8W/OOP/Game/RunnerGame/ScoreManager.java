package M8W.OOP.Game.RunnerGame;

import java.io.*;

public final class ScoreManager
{
    private int score;
    private int highScore;
    private boolean newHighScoreFlag;

    private static final ScoreManager INSTANCE = new ScoreManager();

    private ScoreManager()
    {
        newHighScoreFlag = false;
        score = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File("PlayerSave.txt")));
            String fileText = reader.readLine();
            highScore = Integer.parseInt(fileText);
            reader.close();
        }
        catch (Exception e)
        {
            highScore = 0;
        }
    }

    public static ScoreManager getInstance()
    {
        return INSTANCE;
    }

    public void incrementScore()
    {
        score++;

        if(score > highScore)
        {
            highScore = score;
            newHighScoreFlag = true;
        }
    }

    public int getScore()
    {
        return score;
    }

    public void resetScore()
    {
        score = 0;
    }

    public int getHighScore()
    {
        return highScore;
    }

    public void saveScore()
    {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("PlayerSave.txt")));
            writer.write(Integer.toString(highScore));
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean newHighScoreObtained()
    {
        return newHighScoreFlag;
    }
}
