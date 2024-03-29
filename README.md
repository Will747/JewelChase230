# JewelChase230
We created this project for our Software Engineering course at Swansea University.  <br />
In the course we were tasked with creating a JavaFX jewel chase styled game based on a functional specification given to us. <br />
First part of the project was designing the game and creating UML diagrams which were then implemented in this part.

# Description
A mini jewel chase version with cats in a pub.
<br />
<br />
<b> Features: </b>
- Game Play with 7 levels of increasing difficulty
- High score tables with top 10 scorers for each level
- Create and delete profiles
- Saves high scores and highest level played

# Technologies
This project was created using:
- Java 17
- JavaFX 17.2

# Compile
Once downloaded and opened run the class called Main to start the game. <br />
Once in the main menu, click start to create a profile and start a level.

# Images
![java_ehXdDwo20P](https://user-images.githubusercontent.com/77969841/206911352-ff499549-0155-4440-9c30-f8844f55182b.jpg)
![java_eL0ViOyOuh](https://user-images.githubusercontent.com/77969841/206911353-33e10a08-e9fe-4eac-8d54-154ad86d59fd.jpg)
![java_RTJqTfzxeo](https://user-images.githubusercontent.com/77969841/206911358-8f025619-98e6-4a80-9f9d-3bfd41790b6e.jpg)
![java_bt9AJoq2Av](https://user-images.githubusercontent.com/77969841/206911351-0e116725-dd40-45fe-abaf-f2837730f005.jpg)
![java_SY3qLQxj9i](https://user-images.githubusercontent.com/77969841/206911359-4a45a49f-99dc-44d6-a08a-1068e16f04c1.jpg)
![java_92RfSB6VkT](https://user-images.githubusercontent.com/77969841/206911350-5d6346f2-e1b0-450c-adf9-c00b62e4ad8d.jpg)

# Game Play
As cat in a pub your goal is to collect all the loot (Coins, bag of coins, beer, cocktail and clocks) 
and get to the door before the timer runs out or the smart thief (Animal control) gets there.
<br />
<br />
There are three types of NPC's:
- <b> Flying Assasin/Mouse in an airplane: </b>
  - Kills the player if they cross paths
  - Does not interact with loot
- <b> Floor following thief/Dog: </b>
  - Follows a certain coloured tiles in clockwise pattern
  - Interacts with loot
  - Does not kill the player
- <b> Smart Thief/Animal control: </b>
  - Takes the shortest path to the nearest loot
  - Once all loot is collected it takes the shortest path to the exit
  - Does not kil the player but if it reaches the exit befor ethe player then the player loses
<br />
<br />
To unlock the door all loot needs to be picked up and all gates need to be opened. <br />
Each loot type gives a different amount of extra points which are directly added to the players score. <br />


# Authors:
Daniel Clark <br />
Will Kaye <br />
Kellie Robinson <br />
Caroline Segestaal <br />
Adam Smith <br />
Ben Stott <br />
Scott Williams <br />

