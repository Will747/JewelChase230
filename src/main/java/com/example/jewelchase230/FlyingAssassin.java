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
     *
     */
    public FlyingAssassin(Direction inDirection) {
        setDirection(inDirection);
        setImageFromFile("images/FLYING_ASSASSIN_LEFT_FACE.png");
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
            currentDirection = currentDirection.getOppositeDirection(currentDirection);
            setGridPosition(canMove(0-xDiff, 0-yDiff, this, null));
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
}


//        If the Flying Assassin connects with (i.e. occupies
//        the same tile) the player, the player loses. If they
//        connect with another NPC, that NPC is removed
//        from the game.
