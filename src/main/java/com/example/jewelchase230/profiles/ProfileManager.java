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

public final class ProfileManager {
	/** ArrayList which holds a list of Profiles. */
	private static ArrayList<Profile> listOfProfile = new ArrayList<>();

	/** Name of Text File to be read. */
	private static final String PROFILES_FILE = "Profiles.txt";

	private ProfileManager() {
	}

	// Reads each line of the text file "Profile.txt"
	/**
	 * Reads content from file and stores them appropriately to be
	 * handled in the makeProfile method.
	 */
	public static void readLines() {
		try {
			File myFile = new File(PROFILES_FILE);
			Scanner input = new Scanner(myFile);
			ArrayList<String> profilesLineByLineData =
					new ArrayList<>();

			while (input.hasNextLine()) {
				String data = input.nextLine();
				profilesLineByLineData.add(data);

				String[] lineDataSplit = data.split("\\.");
				Profile tempProfile =
						new Profile(lineDataSplit);
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
	 * @throws FileNotFoundException When the profile file cannot be
	 * written to.
	 */

	public static void saveProfiles() throws IOException {
		FileWriter fileWriter = new FileWriter(PROFILES_FILE);
		BufferedWriter pmWriter = new BufferedWriter(fileWriter);

		try {
			for (Profile profile : listOfProfile) {
				String profileData = profile.toString();
				pmWriter.write(profileData);
				pmWriter.newLine();
			}
			pmWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * Adds a new profile to the manager.
	 * @param profile New profile being added.
	 */
	public static void addProfile(final Profile profile) {
		listOfProfile.add(profile);
	}

	/**
	 * Deletes a player profile.
	 * @param profile Profile to be deleted.
	 */
	public static void deleteProfile(final Profile profile) {
		listOfProfile.remove(profile);
	}

	/**
	 * @return the listOfProfile
	 */
	public static ArrayList<Profile> getListOfProfile() {
		return listOfProfile;
	}
}
