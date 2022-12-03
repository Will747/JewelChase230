package com.example.jewelchase230.profiles;

public class Profile {
	
	/**
	 * This class manages the Profiles. Includes various constructor methods of Profiles, some functions to handle said objects, and getters and setters. 
	 *
	 * @author Kellie Robinson
	 */
	
	
	
	private Integer uniquePlayerID;
	private String playerProfileSlot;
	private String playerName;
	private Integer levelReached;
	
	
	
	
	/**
	 * Constructor of Profile 
	 * @param uniquePlayerID
	 * @param playerProfileSlot
	 * @param playerName
	 * @param levelReached
	 * @param overallScore
	 * @param currentLevel
	 */
	  public Profile(Integer uniquePlayerID, String playerProfileSlot, String playerName, Integer levelReached) {
		  this.uniquePlayerID = uniquePlayerID;
		  this.playerProfileSlot = playerProfileSlot;
		  this.playerName = playerName; 
		  this.levelReached = levelReached;
		 
		  

		  
	}
	  /**
	   * Constructor of Profile
	   * @param lineDataSplit
	   */
	  public Profile(String[] lineDataSplit) { 
		  uniquePlayerID = Integer.parseInt(lineDataSplit[0]);
		  playerProfileSlot = lineDataSplit[1]; 
		  playerName = lineDataSplit[2]; 
		  levelReached = Integer.parseInt(lineDataSplit[3]);
		 
		  
	  }
	  
	 
	  
	  

	  /**
	   * Method which takes a Profile object and returns it to a String format seperating each variable with a '.'.
	   * This will be fed into the saveProfile() function.
	   * @param profile
	   * @return profileToString
	   */
	  public static String profileToString(Profile profile) { 
		  String profileToString = (profile.getUniquePlayerID() + "." + profile.getPlayerProfileSlot() + "." + profile.getPlayerName()
+ "." + profile.getLevelReached());
		return profileToString;		 
	  }
	  
	   
	  /**
	   * Method which takes an Array lineDataSplit and converts it to a String with periods ('.') between each variable.
	   * @param lineDataSplit
	   * @return lineDataSplitToString
	   */
	    public String toString(String[] lineDataSplit) { 
	      String lineDataSplitToString = lineDataSplit[0] + "." + lineDataSplit[1] + "." + lineDataSplit[2] + "." + lineDataSplit[3]; 
	      
	      return lineDataSplitToString;
	  } 
	  
	  
	
	  /**
	   * Method which clones an object 
	   */
	    public Object clone(){  
	        try{  
	            return super.clone();  
	        }catch(Exception e){ 
	            return null; 
	        }
	    }
	  
	  
	  
	  
	/**
	 * @return the playerProfileSlot
	 */
	public String getPlayerProfileSlot() {
		return playerProfileSlot;
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @return the levelReached
	 */
	public Integer getLevelReached() {
		return levelReached;
	}

	

	/**
	 * @return the uniquePlayerID
	 */
	public Integer getUniquePlayerID() {
		return uniquePlayerID;
	}

	/**
	 * @param playerProfileSlot the playerProfileSlot to set
	 */
	public void setPlayerProfileSlot(String playerProfileSlot) {
		this.playerProfileSlot = playerProfileSlot;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @param levelReached the levelReached to set
	 */
	public void setLevelReached(Integer levelReached) {
		this.levelReached = levelReached;
	}

	

	/**
	 * @param uniquePlayerID the uniquePlayerID to set
	 */
	public void setUniquePlayerID(Integer uniquePlayerID) {
		this.uniquePlayerID = uniquePlayerID;
	}
	
}
