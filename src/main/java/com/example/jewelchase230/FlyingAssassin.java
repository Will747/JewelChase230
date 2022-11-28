package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

public class FlyingAssassin extends AICharacter {
    /**
     * Constructs a renderable component.
     *
     * @param x X position on the grid.
     * @param y Y position on the grid.
     */
    public FlyingAssassin(int x, int y) {
        super(x, y);
    }

    @Override
    protected void getNextMove(IntVector2D move) {
        super.getNextMove(move);
    }

    private IntVector2D move() {
        if (getGridPosition().getX() < getLevel().getLevelSize().getX()) {

        }
        while (getGridPosition() < getLevel().getLevelSize())

        return new IntVector2D(x,y);
    }
}

//        It moves in a straight line in
//        the direction it is facing until it reaches the edge
//        of the level. On reaching the edge, it rotates 180
//        degrees and continues moving forward. As this
//        NPC is flying, it does not respect the floor move-
//        ment rules and simply always travels straight. The
//        movement is either vertical or horizontal.
//        If the Flying Assassin connects with (i.e. occupies
//        the same tile) the player, the player loses. If they
//        connect with another NPC, that NPC is removed
//        from the game.