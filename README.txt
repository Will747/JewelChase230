JewelChase230
=============

We created this project for our Software Engineering course at Swansea
University.  
In the course we were tasked with creating a JavaFX jewel chase styled game based on a functional specification given
to us.
First part of the project was designing the game and creating UML diagrams which were then implemented in this part.

Description
===========

A mini jewel chase version with cats in a pub. 

Features: 

-   Game Play with 10 levels
-   High cores tables with top 10 scorers for each level
-   Create and delete profiles
-   Saves high scores and highest level played

Compile
=======

Once downloaded and opened run the class called Main to start the game.
Once in the main menu, click start to create a profile and start a level.

Images
======
(can only be seen in the README.md file, to see images here please click each link)

https://user-images.githubusercontent.com/77969841/206911352-ff499549-0155-4440-9c30-f8844f55182b.jpg
https://user-images.githubusercontent.com/77969841/206911353-33e10a08-e9fe-4eac-8d54-154ad86d59fd.jpg
https://user-images.githubusercontent.com/77969841/206911358-8f025619-98e6-4a80-9f9d-3bfd41790b6e.jpg
https://user-images.githubusercontent.com/77969841/206911351-0e116725-dd40-45fe-abaf-f2837730f005.jpg
https://user-images.githubusercontent.com/77969841/206911359-4a45a49f-99dc-44d6-a08a-1068e16f04c1.jpg
https://user-images.githubusercontent.com/77969841/206911350-5d6346f2-e1b0-450c-adf9-c00b62e4ad8d.jpg

Game Play
=========

As cat in a pub your goal is to collect all the loot (Coins, bag of
coins, beer, cocktail and clocks) and get to the door before the timer
runs out or the smart thief (Animal control) gets there. 

There are three types of NPC's:

- Flying Assasin/Mouse in an airplane: 
    -   Kills the player if they cross paths
    -   Does not interact with loot
- Floor following thief/Dog:
    -   Follows a certain coloured tiles in clockwise pattern
    -   Interacts with loot
    -   Does not kill the player
- Smart Thief/Animal control: 
    -   Takes the shortest path to the nearest loot
    -   Once all loot is collected it takes the shortest path to the
        exit
    -   Does not kil the player but if it reaches the exit befor ethe
        player then the player loses


To unlock the door all loot needs to be picked up and all gates need to be opened.
Each loot type gives a different amount of extra points which are directly added to the players score.

Authors:
========

Daniel Clark 
Will Kaye 
Kellie Robinson
Caroline Segestaal 
Adam Smith
Ben Stott 
Scott Williams
