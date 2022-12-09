package com.example.jewelchase230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * This class interacts with the message of the day API for it to be displayed.
 *
 * @author Adam Smith and Will Kaye
 */
public final class MessageOfTheDay {
    /**
     * 'A' ASCII character value.
     */
    private static final int A_CHAR_AS_INT = 'A';

    /**
     * 'Z' ASCII character value.
     */
    private static final int Z_CHAR_AS_INT = 'Z';

    /**
     * Suffix that gets added to the end of the puzzle.
     */
    private static final String SUFFIX = "CS-230";

    private MessageOfTheDay() {
    }

    /**
     * Returns the string containing the message of the day.
     *
     * @return String with today's message on.
     */
    public static String getMessageOfTheDay() {
        return getSolution();
    }

    /**
     * Submits a get request to the message of the day API and returns the
     * puzzle that needed to be solved.
     *
     * @return puzzle the puzzle that is solved to get the message of the day.
     */
    private static String getPuzzle() {
        String puzzle = "";
        // Tries to connect to the API and returns an error code if it fails.
        try {
            // The creation of the URL and the connection made using it.
            URL puzzleURL = new URL("http://cswebcat.swansea.ac.uk/puzzle");
            puzzle = makeRequest(puzzleURL);
        } catch (Exception e) {
            System.out.println("Error connecting to receive puzzle.");
        }
        return puzzle;
    }

    private static String makeRequest(final URL url) throws IOException {
        String result;

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Readers used to get the response when a request is accepted.
        InputStreamReader inputReader =
                new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        StringBuilder puzzleResponse = new StringBuilder();

        // Appends a string builder with the response from the API.
        while ((result = bufferedReader.readLine()) != null) {
            puzzleResponse.append(result);
        }

        // Closes the readers and sets a string to the puzzle from the API.
        inputReader.close();
        bufferedReader.close();
        result = puzzleResponse.toString();
        // Disconnects from the API.
        connection.disconnect();

        return result;
    }

    /**
     * Solves the puzzle so that it can be sent as a parameter to
     * the API to get the message of the day.
     *
     * @param puzzle the puzzle returned from the first API request.
     * @return solutionQuery the solved puzzle and formatted with extra
     * information needed for the final API request.
     */
    private static String solvePuzzle(final String puzzle) {
        StringBuilder solvedPuzzle = new StringBuilder();

        // Loops through the puzzle changing the characters to their solution.
        for (int i = 0; i < puzzle.length(); i++) {
            char shiftedCharacter;
            int characterNum = (i + 1);
            if (characterNum % 2 == 0) {
                // Shift forward
                shiftedCharacter = (char) (puzzle.charAt(i) + characterNum);
                if (shiftedCharacter > Z_CHAR_AS_INT) {
                    shiftedCharacter -= Z_CHAR_AS_INT;
                    shiftedCharacter += A_CHAR_AS_INT - 1;
                }

            } else {
                // Shift backwards
                shiftedCharacter = (char) (puzzle.charAt(i) - characterNum);
                if (shiftedCharacter < A_CHAR_AS_INT) {
                    int numFromA = A_CHAR_AS_INT - shiftedCharacter - 1;
                    shiftedCharacter = (char) (Z_CHAR_AS_INT - numFromA);
                }

            }
            solvedPuzzle.append(shiftedCharacter);
        }

        // Sets variables to values used to construct the query.
        int solvedPuzzleLength = puzzle.length() + SUFFIX.length();
        String solvedPuzzleLengthString = String.valueOf(solvedPuzzleLength);
        String solutionQuery = solvedPuzzleLengthString + solvedPuzzle + SUFFIX;
        System.out.println(solvedPuzzle);
        return solutionQuery;
    }

    /**
     * Submits an API requests with the solution as the parameter and
     * returns the message of the day if correct.
     *
     * @return message the message of the day from the API.
     */
    private static String getSolution() {
        // Variables needed to construct the query.
        // Calls the first request method to ge the solved puzzle.
        String solvedPuzzleQuery = solvePuzzle(getPuzzle());
        String message = "";
        String messageURL = "http://cswebcat.swansea.ac.uk/message?solution=";

        try {
            // Builds URL with the correct query and opens a connection.
            URI tempURI = new URI(messageURL + solvedPuzzleQuery);
            URL finalMessageURL = tempURI.toURL();
            message = makeRequest(finalMessageURL);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(
                    "Error connecting or solving message of the day.");
        }
        return message;
    }
}
