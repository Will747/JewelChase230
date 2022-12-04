package com.example.jewelchase230;

import com.example.jewelchase230.vectors.IntVector2D;

/**
 * Implements the Flying Assassin. A class to implement the move
 * patterns and events of the AICharater Flying Assassin.
 *
 * @author Caroline Segestaal.
 */
public class FlyingAssassin extends AICharacter {
    /** Left facing image. */
    final static String FACING_LEFT_IMAGE = "images/FLYING_ASSASSIN_LEFT_FACE.png";
    /** Right facing image. */
    final static String FACING_RIGHT_IMAGE = "images/FLYING_ASSASSIN_RIGHT_FACE.png";

    /**
     * Constructs a renderable component.
     *
     */
    public FlyingAssassin(Direction inDirection) {
        setDirection(inDirection);
        setImageFromFile(imageManager(inDirection));
    }

    /**
     * Controls the next move of the Flying Assassin.
     */
    @Override
    public void getNextMove() {
        IntVector2D currentPos = getGridPosition();
        IntVector2D newPos = getMoveDifference(currentDirection);
        int xDiff = newPos.getX();
        int yDiff = newPos.getY();
        IntVector2D potentialPosition = canMove(xDiff, yDiff, this, null);
        if (potentialPosition == currentPos) {
            Direction newDirection = currentDirection.getOppositeDirection(currentDirection);
            currentDirection = newDirection;
            setGridPosition(canMove(0-xDiff, 0-yDiff, this, null));
            setImageFromFile(imageManager(newDirection));
        } else {
            setGridPosition(potentialPosition);
        }
        /* switch (d) {
            case UP:
                IntVector2D newPos = gridPos.add(new IntVector2D(0, -1));
                if (getLevel().checkValidTile(newPos)) {
                    setGridPosition(newPos);
//                    Character npc = getLevel().getSpecificCharacter(
//                            newPos.getX(), newPos.getY());
//
//                    if (getLevel().getPlayer().getGridPosition() == newPos) {
//                        getLevel().gameOver();
//                    }
//
//                    if (npc != null) {
//                        getLevel().removeSpecificNPC(newPos);
//                    }

                } else {
                    super.setDirection(d.getOppositeDirection(d));
                    newPos = gridPos.add(new IntVector2D(0, 1));
                    setGridPosition(newPos);
                }
                break;
            case DOWN:
                newPos = gridPos.add(new IntVector2D(0, 1));
                if (getLevel().checkValidTile(newPos)) {
                    setGridPosition(newPos);
//                    Character npc = getLevel().getSpecificCharacter(
//                            newPos.getX(), newPos.getY());
//
//                    if (getLevel().getPlayer().getGridPosition() == newPos) {
//                        getLevel().gameOver();
//                    }
//                    if (npc != null) {
//                        getLevel().removeSpecificNPC(newPos);
//                    }
                } else {
                    super.setDirection(d.getOppositeDirection(d));
                    newPos = gridPos.add(new IntVector2D(0, -1));
                    setGridPosition(newPos);
                }
                break;
            case LEFT:
                newPos = gridPos.add(new IntVector2D(-1, 0));
                if (getLevel().checkValidTile(newPos)) {
                    setGridPosition(newPos);
//                    Character npc = getLevel().getSpecificCharacter(
//                            newPos.getX(), newPos.getY());
//
//                    if (getLevel().getPlayer().getGridPosition() == newPos) {
//                        getLevel().gameOver();
//                    }
//                    if (npc != null) {
//                        getLevel().removeSpecificNPC(newPos);
//                    }
                } else {
                    super.setDirection(d.getOppositeDirection(d));
                    newPos = gridPos.add(new IntVector2D(1, 0));
                    setGridPosition(newPos);
                }
                break;
            default: //RIGHT
                newPos = gridPos.add(new IntVector2D(1, 0));
                if (getLevel().checkValidTile(newPos)) {
                    setGridPosition(newPos);
//                    Character npc = getLevel().getSpecificCharacter(
//                            newPos.getX(), newPos.getY());
//
//                    if (getLevel().getPlayer().getGridPosition() == newPos) {
//                        getLevel().gameOver();
//                    }
//                    if (npc != null) {
//                        getLevel().removeSpecificNPC(newPos);
//                    }
                } else {
                    super.setDirection(d.getOppositeDirection(d));
                    newPos = gridPos.add(new IntVector2D(-1, 0));
                    setGridPosition(newPos);
                }
                break;
        } */
    }

    /**
     * Gets the correct image depending on the direction.
     * @param d new direction.
     * @return image corresponding with the direction.
     */
    private String imageManager(Direction d) {
        return switch (d) {
            case LEFT -> FACING_LEFT_IMAGE;
            case RIGHT -> FACING_RIGHT_IMAGE;
            default -> FACING_LEFT_IMAGE;
        };
    }
}


//        If the Flying Assassin connects with (i.e. occupies
//        the same tile) the player, the player loses. If they
//        connect with another NPC, that NPC is removed
//        from the game.
