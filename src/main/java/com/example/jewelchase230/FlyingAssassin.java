package com.example.jewelchase230;
import com.example.jewelchase230.vectors.IntVector2D;

/**
 * Implements the Flying Assassin. A class to implement the move
 * patterns and events of the AICharater Flying Assassin.
 *
 * @author Caroline Segestaal.
 */
public class FlyingAssassin extends AICharacter {

    /**
     * Constructs a renderable component.
     * @param d Direction the Flying assassin is facing.
     */
    public FlyingAssassin(final Direction d) {
        super();

        setImageFromFile("images/FLYING_ASSASSIN_LEFT_FACE.png");
    }

    /**
     * Controls the next move of the Flying Assassin.
     *
     * @param d Direction the Flying assassin is facing.
     */
    protected void getNextMove(final Direction d) {
        IntVector2D gridPos = getGridPosition();
        IntVector2D levelSize = getLevel().getLevelSize();

        switch (d) {
            case UP: if (gridPos.getY() < levelSize.getY()) {
                setGridPosition(gridPos.add(new IntVector2D(0, 1)));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
            case DOWN: if (gridPos.getY() > levelSize.getY()) {
                setGridPosition(gridPos.add(new IntVector2D(0, -1)));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
            case LEFT: if (gridPos.getX() > levelSize.getX()) {
                setGridPosition(gridPos.add(new IntVector2D(-1, 0)));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
            default: //RIGHT
                if (gridPos.getX() < levelSize.getX()) {
                setGridPosition(gridPos.add(new IntVector2D(1, 0)));
            } else {
                getNextMove(d.getOppositeDirection(d));
            }
        }
    }

    /**
     * Called just before the grid gets re-rendered.
     *
     * @param time Time since last frame in milliseconds.
     */
    @Override
    public void tick(final int time) {

    }

//    /**
//     * Draws this item to the canvas.
//     *
//     * @param gc GraphicsContext for creating draw class.
//     */
//    @Override
//    public void draw(GraphicsContext gc) {
//        //gc.drawImage(new Image("/images/FLYING_ASSASSIN_LEFT_FACE.png"), 1, 1);
//    }
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
