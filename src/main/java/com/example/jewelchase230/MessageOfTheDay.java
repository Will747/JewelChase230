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
            puzzleConnection.disconnect();
        }
        catch (Exception e)
        {
            System.out.println("Error connecting to recieve puzzle.");
        }
        System.out.println(puzzle);
        return puzzle;
    }

    private static String solvePuzzle(String puzzle)
    {
        final int SUFFIX_LENGTH = 6;
        final int A_CHAR_AS_INT = 65;
        final int Z_CHAR_AS_INT = 90;
        final String SUFFIX = "CS-230";
        String solvedPuzzle = "";

        int tempIndex;

        for (int i = 0; i <= puzzle.length() - 1; i++)
        {
            tempIndex = i + 1;
            if ((tempIndex) % 2 == 0)
            {
                if ((((int) puzzle.charAt(i)) + (tempIndex)) > Z_CHAR_AS_INT)
                {
                   solvedPuzzle = solvedPuzzle + ((char) (((A_CHAR_AS_INT + ((tempIndex) - (( Z_CHAR_AS_INT - ((int) puzzle.charAt(i)))))))));
                }
                else
                {
                   solvedPuzzle = solvedPuzzle + ((char) (((int) puzzle.charAt(i)) + (tempIndex)));
                }
            }
            else
            {
                if ((((int) puzzle.charAt(i)) - (tempIndex + 1)) < A_CHAR_AS_INT)
                {
                   solvedPuzzle = solvedPuzzle + ((char) (Z_CHAR_AS_INT - ((tempIndex) - (((int) puzzle.charAt(i)) - A_CHAR_AS_INT))));
                }
                else
                {
                   solvedPuzzle = solvedPuzzle + ((char) (((int) puzzle.charAt(i)) - (tempIndex)));
                }
            }
        }

        int solvedPuzzleLength = puzzle.length() + SUFFIX_LENGTH;
        String solvedPuzzleLengthString = "" + solvedPuzzleLength;
        String solutionQuery = solvedPuzzleLengthString + solvedPuzzle + SUFFIX;
        System.out.println(solvedPuzzle);
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
            messageConnection.disconnect();

        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Error connecting to recieve message of the day.");
        }
        return message;
    }
}
