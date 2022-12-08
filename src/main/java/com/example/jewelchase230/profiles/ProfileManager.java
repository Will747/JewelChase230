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
	/** Name of Text File to be read */
	static String profilesFile = "Profiles.txt";

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
			File myFile = new File(profilesFile);
			Scanner input = new Scanner(myFile);

			while (input.hasNextLine()) {
				String data = input.nextLine();
				profilesLineByLineData.add(data);

				String[] lineDataSplit = data.split("\\.", LINEBYLINEDATA_NUMBER_OF_CASES);
				uniqueIDFromFile = Integer.parseInt(lineDataSplit[1]);
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
	 * Overwrites the Profiles.txt file with updated Profile information.
	 * 
	 * @param ProfileManager profile
	 * @throws FileNotFoundException
	 */

	public static void saveProfile(Profile profile) throws IOException {

		BufferedWriter pmWriter = new BufferedWriter(new FileWriter(profilesFile));

		try {

			
			for (int i = 0; i < listOfProfile.size(); i++) {
				pmWriter.write(Profile.profileToString(listOfProfile.get(i)));

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
	 * Deletes a player profile from the player slots by overwriting its line as a
	 * blank profile.
	 * @param Profile
	 * @throws IOException
	 * 
	 */
	public static void deleteProfile(Profile profile) throws IOException {
		listOfProfile.remove(profile);
	}

	public static Profile searchProfile(int playerSlot) {
		// go thru the list and check for if player slot == list i.get(uniqueID)
		for (int i = 0; i <= listOfProfile.size(); i++) {
			if (playerSlot == listOfProfile.get(i).getPlayerProfileSlot())
				;
			return listOfProfile.get(i);
		}
		return null;

	}

	/**
	 * @return The profilesLineByLineData arraylist.
	 */
	public static ArrayList<String> getProfilesLineByLineData() {
		return profilesLineByLineData;
	}

	/**
	 * @return the listOfProfile
	 */
	public static ArrayList<Profile> getListOfProfile() {
		return listOfProfile;
	}

	/**
	 * @return the profileLevel
	 */
}
