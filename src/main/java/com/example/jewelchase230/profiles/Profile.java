package com.example.jewelchase230.profiles;

public class Profile {

	
	private Integer uniquePlayerID;
	private String playerProfileSlot;
	private String playerName;
	private Integer levelReached;
	private Integer overallScore;
	
	
	  public Profile(Integer uniquePlayerID, String playerProfileSlot, String playerName, Integer levelReached, Integer overallScore) {
		  this.uniquePlayerID = uniquePlayerID;
		  this.playerProfileSlot = playerProfileSlot;
		  this.playerName = playerName; 
		  this.levelReached = levelReached;
		  this.overallScore = overallScore;  
		  
		  

		  
	}

	  public Profile(String[] lineDataSplit) { 
		  uniquePlayerID = Integer.parseInt(lineDataSplit[0]);
		  playerProfileSlot = lineDataSplit[1]; 
		  playerName = lineDataSplit[2]; 
		  levelReached = Integer.parseInt(lineDataSplit[3]);
		  overallScore = Integer.parseInt(lineDataSplit[4]);
		  
	  }
	  
	  //tostring for saving profile -- then go into PM and change save file to just be called on the toString
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
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
	 * @return the overallScore
	 */
	public Integer getOverallScore() {
		return overallScore;
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
	 * @param overallScore the overallScore to set
	 */
	public void setOverallScore(Integer overallScore) {
		this.overallScore = overallScore;
	}

	/**
	 * @param uniquePlayerID the uniquePlayerID to set
	 */
	public void setUniquePlayerID(Integer uniquePlayerID) {
		this.uniquePlayerID = uniquePlayerID;
	}
	
}
