package com.example.jewelchase230.profiles;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.jewelchase230.menus.ProfileMenu;

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
	/** BLANK PROFILE LINE */
	private static final String BLANK_PROFILE_STRING = "0.CREATE_PROFILE.0";

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
	 * Overwrites the Profiles.txt file with updated Profile information
	 * 
	 * @param ProfileManager profile
	 * @throws FileNotFoundException
	 */

	public static void saveProfile(Profile profile) throws IOException {

		BufferedWriter pmWriter = new BufferedWriter(new FileWriter(profilesFile));

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
	 * a blank profile.
	 * 
	 */
	public static void deleteProfile(Profile profile) throws IOException {
		BufferedWriter pmWriter = new BufferedWriter(new FileWriter(profilesFile));
		Scanner in = new Scanner(profilesFile);

		try {
			while (in.hasNextLine()) {
				String data = in.nextLine();
				profilesLineByLineData.add(data);

				String[] lineDataSplit = data.split("\\.", LINEBYLINEDATA_NUMBER_OF_CASES);
				uniqueIDFromFile = Integer.parseInt(lineDataSplit[1]);
				if ((listOfProfile.get(ProfileMenu.getProfileSelected())).getUniquePlayerID() == uniqueIDFromFile) {
					pmWriter.write(ProfileMenu.getProfileSelected() + BLANK_PROFILE_STRING);
				}

			}
			pmWriter.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}

	}

	/**
	 * @return The profilesLineByLineData arraylist.
	 */
	public static ArrayList<String> getProfilesLineByLineData() {
		return profilesLineByLineData;
	}

	/**
	 * @return the blankProfile
	 */
	public static String getBlankProfile() {
		return BLANK_PROFILE_STRING;
	}

	/**
	 * @return the profileLevel
	 */
}
