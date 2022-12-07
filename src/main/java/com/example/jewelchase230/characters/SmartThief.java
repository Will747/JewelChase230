package com.example.jewelchase230.characters;


import com.example.jewelchase230.Direction;

public final class SmartThief extends AICharacter {

    /**
     * Constructs a renderable component.
     */
    public SmartThief(Direction d) {
        super();
        setDirection(d);
    }

    @Override
    protected void getNextMove() {
    }
}


//    and their mission within the game is to collect as
//    much loot as possible and reach the exit of the
//    level before the player. They move rather slowly
//        (compared to the player), following the movement
//        rules as set out in Section 3.1, and move as follows:
//        1. They take the valid move in the direction
//        (up, down, left, or right) that is on the short-
//        est path toward the nearest reachable loot or
//        lever.
//        2. If there is loot or levers on the level but they
//        are all unreachable then the thief moves in a
//        random but valid direction.
//        3. Once all loot and levers have been collected,
//        the thief moves in the direction (up, down,
//        left, or right) that is on the shortest path
//        toward the nearest reachable exit. If all ex-
//        its are unreachable then the thief moves in a
//        random but valid direction.