package com.example.jewelchase230;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Runtime.Version;
import java.net.*;

public class MessageOfTheDay
{
    public static String messageOfTheDay()
    {
        return getSolution();
    }

    private static String getPuzzle()
    {
        String puzzle = "";
        try
        {
            URL puzzleURL = new URL("http://cswebcat.swansea.ac.uk/puzzle");
            HttpURLConnection puzzleConnection = (HttpURLConnection)puzzleURL.openConnection();
            puzzleConnection.setRequestMethod("GET");

            InputStreamReader puzzleInputReader = new InputStreamReader(puzzleConnection.getInputStream());
            BufferedReader puzzleBufferedReader = new BufferedReader(puzzleInputReader);
            StringBuilder puzzleResponse = new StringBuilder();

            while ((puzzle = puzzleBufferedReader.readLine()) != null)
            {
                puzzleResponse.append(puzzle);
            }
            
            puzzleInputReader.close();
            puzzleBufferedReader.close();
            puzzle = puzzleResponse.toString();
        }
        catch (Exception e)
        {
            System.out.println("Error connecting to recieve puzzle.");
        }
        return puzzle;
    }

    private static String solvePuzzle(String puzzle)
    {
        final int SUFFIX_LENGTH = 6;
        final String SUFFIX = "CS-230";
        String solvedPuzzle = "";

        for (int i = 0; i < puzzle.length(); i++)
        {
            int temp = i;
            if ((temp + 1) % 2 == 0)
            {
                if ((((int) puzzle.charAt(i)) + (temp + 1)) > 90)
                {
                   solvedPuzzle =solvedPuzzle + ((char) (((65 + (temp + 1 - (( 90 - ((int) puzzle.charAt(i)))))))));
                }
                else
                {
                   solvedPuzzle =solvedPuzzle + ((char) (((int) puzzle.charAt(i)) + (temp + 1)));
                }
            }
            else
            {
                if ((((int) puzzle.charAt(i)) - (temp + 1)) < 65)
                {
                   solvedPuzzle =solvedPuzzle + ((char) (90 - ((temp + 1) - (((int) puzzle.charAt(i)) - 65))));
                }
                else
                {
                   solvedPuzzle =solvedPuzzle + ((char) (((int) puzzle.charAt(i)) - (temp + 1)));
                }
            }
        }

        int solvedPuzzleLength = puzzle.length() + SUFFIX_LENGTH;
        String solvedPuzzleLengthString = "" + solvedPuzzleLength;
        String solutionQuery = solvedPuzzleLengthString + solvedPuzzle + SUFFIX;
        return solutionQuery;
    }

    private static String getSolution()
    {
        String solvedPuzzleQuery = solvePuzzle(getPuzzle());
        String message = "";
        String messageURL = "http://cswebcat.swansea.ac.uk/message?solution=";

        try
        {
            URI  tempURI = new URI (messageURL + solvedPuzzleQuery);
            URL finalMessageURL = tempURI.toURL();
            HttpURLConnection messageConnection = (HttpURLConnection)finalMessageURL.openConnection();
            messageConnection.setRequestMethod("GET");

            InputStreamReader messageInputReader = new InputStreamReader(messageConnection.getInputStream());
            BufferedReader messageBufferedReader = new BufferedReader(messageInputReader);
            StringBuilder messageResponse = new StringBuilder();

            while ((message = messageBufferedReader.readLine()) != null)
            {
                messageResponse.append(message);
            }

            messageInputReader.close();
            messageBufferedReader.close();
            message = messageResponse.toString();

        }
        catch (Exception e)
        {
            System.out.println("Error connecting to recieve message of the day.");
        }
        return message;
    }
}
