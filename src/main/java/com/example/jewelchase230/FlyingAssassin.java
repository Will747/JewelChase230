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
    
    protected void getNextMove(Direction d) {
        switch (d) {
            case UP: if (getGridPosition().getY() < getLevel().getLevelSize().getY()) {
                setGridPosition(new IntVector2D(getGridPosition().getX(), getGridPosition().getY() + 1));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
            case DOWN: if (getGridPosition().getY() > getLevel().getLevelSize().getY()) {
                setGridPosition(new IntVector2D(getGridPosition().getX(), getGridPosition().getY() - 1));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
            case LEFT: if (getGridPosition().getX() > getLevel().getLevelSize().getX()) {
                setGridPosition(new IntVector2D(getGridPosition().getX() - 1, getGridPosition().getY()));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
            case RIGHT: if (getGridPosition().getX() < getLevel().getLevelSize().getX()) {
                setGridPosition(new IntVector2D(getGridPosition().getX() + 1, getGridPosition().getY()));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
        }
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