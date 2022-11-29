package com.example.jewelchase230;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Runtime.Version;
import java.net.*;

/**
 * This class interacts with the message of the day API for it to be displayed.
 * @author Adam Smith.
 */

public class MessageOfTheDay
{
    /**
     * Returns the string containing the message of the day.
     * @return getSolution() the method that gets the message from the API.
     */
    public static String messageOfTheDay()
    {
        return getSolution();
    }

    public static void main(String[] args)
    {
        System.out.println(getSolution());
    }

    /**
     * Submits a get request to the message of the day API and returns the puzzle that needed to be solved.
     * @return puzzle the puzzle that is solved to get the message of the day.
     */
    private static String getPuzzle()
    {
        String puzzle = "";
        // Tries to connect to the API and returns an error code if it fails.
        try
        {
            // The creation of the URL and the connection made using it.
            // Sets the method the request uses.
            URL puzzleURL = new URL("http://cswebcat.swansea.ac.uk/puzzle");
            HttpURLConnection puzzleConnection = (HttpURLConnection)puzzleURL.openConnection();
            puzzleConnection.setRequestMethod("GET");

            // Readers used to get the reponse from the API when a request is accepted.
            InputStreamReader puzzleInputReader = new InputStreamReader(puzzleConnection.getInputStream());
            BufferedReader puzzleBufferedReader = new BufferedReader(puzzleInputReader);
            StringBuilder puzzleResponse = new StringBuilder();

            // Appends a string builder with the response from the API.
            while ((puzzle = puzzleBufferedReader.readLine()) != null)
            {
                puzzleResponse.append(puzzle);
            }
            
            // Closes the readers and sets a string to the puzzle from the API.
            puzzleInputReader.close();
            puzzleBufferedReader.close();
            puzzle = puzzleResponse.toString();
            // puzzle = "CAB";
            // Disconnects from the API.
            puzzleConnection.disconnect();
        }
        catch (Exception e)
        {
            System.out.println("Error connecting to recieve puzzle.");
        }
        System.out.println(puzzle);
        return puzzle;
    }

    /**
     * Solves the puzzle so that it can be sent as a parameter to the API to get the message of the day.
     * @param puzzle the puzzle returned from the first API request.
     * @return solutionQuery the solved puzzle and formated with extra information needed for the final API request.
     */
    private static String solvePuzzle(String puzzle)
    {
        // Constants for the ascii values of characters and the extra information needed.
        final int SUFFIX_LENGTH = 6;
        final int A_CHAR_AS_INT = 65;
        final int Z_CHAR_AS_INT = 90;
        final String SUFFIX = "CS-230";
        String solvedPuzzle = "";

        int tempIndex;

        // Loops through the length of the puzzle changing the characters to there solution.
        for (int i = 0; i <= puzzle.length() - 1; i++)
        {
            tempIndex = i + 1;
            // The method for changing characters if at an even index (start from 1).
            if ((tempIndex) % 2 == 0)
            {
                if ((((int) puzzle.charAt(i)) + (tempIndex)) > Z_CHAR_AS_INT)
                {
                    // Hanles the changing of characets if they wrap around the alphabet.
                   solvedPuzzle = solvedPuzzle +  ((char) (((((A_CHAR_AS_INT + ((tempIndex) - (( Z_CHAR_AS_INT - ((int) puzzle.charAt(i)))))))))));
                }
                else
                {
                   solvedPuzzle = solvedPuzzle + ((char) (((int) puzzle.charAt(i)) + (tempIndex)));
                }
            }
            // The method for changing characters if at an odd index (start from 1).
            else
            {
                if ((((int) puzzle.charAt(i)) - (tempIndex + 1)) < A_CHAR_AS_INT)
                {
                    // Handles the changing of characters if they wrap around the alphabet.
                   solvedPuzzle = solvedPuzzle + ((char) ((Z_CHAR_AS_INT - ((tempIndex) - (((int) puzzle.charAt(i)) - A_CHAR_AS_INT)))));
                }
                else
                {
                   solvedPuzzle = solvedPuzzle + ((char) (((int) puzzle.charAt(i)) - (tempIndex)));
                }
            }
        }

        // Sets variables to values used to consruct the query.
        int solvedPuzzleLength = puzzle.length() + SUFFIX_LENGTH;
        String solvedPuzzleLengthString = "" + solvedPuzzleLength;
        String solutionQuery = solvedPuzzleLengthString + solvedPuzzle + SUFFIX;
        System.out.println(solvedPuzzle);
        return solutionQuery;
    }

    /**
     * Submits an API requests with the solution as the parameter and returns the message of the day if correct.
     * @return message the message of the day from the API.
     */
    private static String getSolution()
    {
        // Varibles needed to construct the query.
        // Calls the first request method to ge the solved puzzle.
        String solvedPuzzleQuery = solvePuzzle(getPuzzle());
        String message = "";
        String messageURL = "http://cswebcat.swansea.ac.uk/message?solution=";

        // Tries a connection to the API and returns an error code if there is an error.
        try
        {
            // Constructs the URL with the correct query as well as opens the connection.
            // Sets the request method to GET.
            URI  tempURI = new URI (messageURL + solvedPuzzleQuery);
            URL finalMessageURL = tempURI.toURL();
            HttpURLConnection messageConnection = (HttpURLConnection)finalMessageURL.openConnection();
            messageConnection.setRequestMethod("GET");

            // Readers used to get the response from the API.
            InputStreamReader messageInputReader = new InputStreamReader(messageConnection.getInputStream());
            BufferedReader messageBufferedReader = new BufferedReader(messageInputReader);
            StringBuilder messageResponse = new StringBuilder();

            // Appends a string builder as long as theres a response.
            while ((message = messageBufferedReader.readLine()) != null)
            {
                messageResponse.append(message);
            }

            // Closes the readers and disconnects from the API.
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
