package com.example.jewelchase230;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Runtime.Version;
import java.net.*;

public class MessageOfTheDay
{
    public static String messageOfTheDay(String[] args)
    {
        return getSolution();
    }

    private static String getPuzzle()
    {
        try
        {
            URL puzzleURL = new URL("http://cswebcat.swansea.ac.uk/puzzle");
            HttpURLConnection puzzleConnection = (HttpURLConnection)puzzleURL.openConnection();
            puzzleConnection.setRequestMethod("GET");
            String puzzle = "";

            InputStreamReader puzzleInputReader = new InputStreamReader(puzzleConnection.getInputStream());
            BufferedReader puzzleBufferedReader = new BufferedReader(puzzleInputReader);
            StringBuilder puzzleResponse = new StringBuilder();

            while ((puzzle = puzzleBufferedReader.readLine()) != null)
            {
                puzzleResponse.append(puzzle);
            }
            
            puzzleInputReader.close();
            puzzleBufferedReader.close();
        }
        catch (Exception e)
        {
            System.out.println("Error connecting to recieve puzzle.");
        }

    }

    private static String getSolution()
    {

    }
}
