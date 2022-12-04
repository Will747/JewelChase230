package com.example.jewelchase230.profiles;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class manages the handling of Profiles, including the .txt files of
 * which Profiles will be written/read from during saving and loading.
 *
 * @author Kellie Robinson
 */

public class ProfileManager {

	/** ArrayList which holds each line of the Profiles.txt File */
	static ArrayList<String> profilesLineByLineData = new ArrayList<String>();
	/** ArrayList which holds a list of Profiles */
	public static ArrayList<Profile> listOfProfile = new ArrayList<Profile>();
	/** Integer which holds a user's unique player ID */
	static int uniqueIDFromFile;
	/** Final int variable which holds the total number of 'splits' to be done */
	public static final int LINEBYLINEDATA_NUMBER_OF_CASES = 4;

	// Reads each line of the text file "Profile.txt"
	/**
	 * Reads content from file and stores them appropriately to be handled in the
	 * makeProfile method
	 * 
	 * @return lineDataSplit
	 * @throws FileNotFoundException
	 */

	public static void readLines() {
		try {
			File myFile = new File("Profiles.txt");
			Scanner input = new Scanner(myFile);

			while (input.hasNextLine()) {
				String data = input.nextLine();
				profilesLineByLineData.add(data);

				String[] lineDataSplit = data.split("\\.", LINEBYLINEDATA_NUMBER_OF_CASES);
				uniqueIDFromFile = Integer.parseInt(lineDataSplit[0]);
				Profile tempProfile = new Profile(lineDataSplit);
				listOfProfile.add(tempProfile);
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println(listOfProfile.size());
	}

	
	
	/**
	 * Overwrites the Profiles.txt file with updated Profile information
	 * 
	 * @param ProfileManager profile
	 * @throws FileNotFoundException
	 */

	public static void saveProfile(Profile profile) throws IOException {
		
		
		BufferedWriter pmWriter = new BufferedWriter(new FileWriter("Profiles.txt"));

		
		try {
			pmWriter.write(Profile.profileToString(profile));
			pmWriter.newLine();
			for (int i = 0; i <= profilesLineByLineData.size(); i++) {
				pmWriter.write(profilesLineByLineData.get(i));

				if (i != profilesLineByLineData.size()) {
					pmWriter.newLine();
				}
			}

			pmWriter.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes a player profile from the player slots by overwriting its line as
	 * null
	 * 
	 */
	public static void deleteProfile(Profile profile) {

	}

	/**
	 * @return The profilesLineByLineData arraylist.
	 */
	public static ArrayList<String> getProfilesLineByLineData() {
		return profilesLineByLineData;
	}

	/**
	 * @return the profileLevel
	 */
}
