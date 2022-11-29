package com.example.jewelchase230.profiles;

public class ProfileScore {
/**int which holds the highest score of a player */ 
private int highestScore; 
/** Integer which holds the player's unique ID */
private int userUniqueID;


/**
 * @return the highestScore
 */
public int getHighestScore() {
	return highestScore;
}
/**
 * @return the userName
 */
public int getUserName() {
	return userUniqueID;
}
/**
 * @param highestScore the highestScore to set
 */
public void setHighestScore(int highestScore) {
	this.highestScore = highestScore;
}
/**
 * @param userName the userName to set
 */
public void setUserName(int userUniqueID) {
	this.userUniqueID = userUniqueID;
} 
	
}
