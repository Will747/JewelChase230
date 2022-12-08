package com.example.jewelchase230.characters;
import com.example.jewelchase230.*;
import com.example.jewelchase230.vectors.IntVector2D;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Renders the characters to the game.
 *
 * @author Caroline Segestaaland and Ben Stott.
 */
public abstract class Character extends Sprite
        implements Collidable, Serializable {
    /** True if the character is alive. */
    private boolean alive = true;
    /** Bones image. */
    private static final String BONES_IMAGE = "images/BONES.png";
    /**
     * Constructs a renderable component.
     */
    public Character() {
        super();
    }

    /**
     * Checks that the next move is a valid move.
     * @param nextMoveTile The tile to be moved to.
     * @return True if valid move, false if not.
     */
    protected boolean validNextTile(final Tile nextMoveTile) {
        return validNextTile(nextMoveTile, null);
    }

    /**
     * Checks that the next move is a valid move.
     * @param nextMoveTile The tile to be moved to.
     * @param colourFollow The specific colour the next tile must be.
     * @return True if valid move, false if not.
     */
    protected boolean validNextTile(final Tile nextMoveTile,
                                  final TileColour colourFollow) {
        return validNextTile(nextMoveTile, colourFollow,
                getGridPosition(), true);
    }

    /**
     * Compares two tiles and decides if it is possible to move between them.
     * Ignoring the current positions of other characters.
     * @param nextMoveTile The tile to be moved to.
     * @param colourFollow The specific colour the next tile must be.
     * @param currentPos The current position.
     * @param checkCharacters True if other characters should be
     *                        considered.
     * @return True if valid move, false if not.
     */
    protected boolean validNextTile(final Tile nextMoveTile,
                                    final TileColour colourFollow,
                                    final IntVector2D currentPos,
                                    final boolean checkCharacters) {
        Tile thisTile = getLevel().getTile(currentPos);

        // Check if the tile/item can be collided with.
        if (!nextMoveTile.isCollidable()) {
            return false;
        }

        ArrayList<TileColour> thisTileColours = new ArrayList<>();
        ArrayList<TileColour> nextTileColours = nextMoveTile.getTileColours();
        // Select the applicable colours that can be moved to.
        if (colourFollow == null) {
            thisTileColours = thisTile.getTileColours();
        } else {
            thisTileColours.add(colourFollow);
        }

        // Check if the next tile has any matching colours with the current.
        for (int i = 0; i < thisTileColours.size(); i++) {
            for (int j = 0; j < nextTileColours.size(); j++) {
                if (thisTileColours.get(i) == nextTileColours.get(j)) {
                    if (checkCharacters) {
                        return canCharactersCollide(
                                nextMoveTile.getGridPosition());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a character can move to a new tile.
     * @param xChange Positive for moving right, negative for moving left.
     * @param yChange Positive for moving down, negative for moving up.
     * @return new tile position, or current position if invalid move.
     */
    protected IntVector2D canMove(final int xChange, final int yChange) {
        return canMove(getGridPosition(),
                new IntVector2D(xChange, yChange),
                true);
    }

    /**
     * Checks if a character can move in a certain direction from a
     * particular tile.
     * @param startPos The initial position.
     * @param direction The direction the character wants to move in.
     * @param checkCharacters True if characters on the grid should be
     *                        considered.
     * @return The final position after making move or startPos if invalid move.
     */
    protected IntVector2D canMove(final IntVector2D startPos,
                                  final Direction direction,
                                  final boolean checkCharacters) {
        return canMove(startPos, direction.getDirectionVector(),
                checkCharacters);
    }

    /**
     * Checks if a character can move in a certain direction from a
     * particular tile.
     * @param startPos The initial position.
     * @param direction The direction the character wants to move in.
     * @return The final position after making move or startPos if invalid move.
     */
    protected IntVector2D canMove(final IntVector2D startPos,
                                  final Direction direction) {
        return canMove(startPos, direction.getDirectionVector(), true);
    }

    /**
     * Checks if a character can move in a certain direction from a
     * particular tile.
     * @param startPos The initial position.
     * @param direction The direction the character wants to move in.
     * @param checkCharacters True if characters on the grid should be
     *                        considered.
     * @return The final position after making move or startPos if invalid move.
     */
    protected IntVector2D canMove(final IntVector2D startPos,
                                  final IntVector2D direction,
                                  final boolean checkCharacters) {
        int xDiff = 0;
        int yDiff = 0;
        boolean stillInRange = true;
        while (stillInRange) {
            xDiff += direction.getX();
            yDiff += direction.getY();
            IntVector2D newPos =
                    startPos.add(new IntVector2D(xDiff, yDiff));
            //Check the newPos is a valid tile
            if (getLevel().checkTileExists(newPos)) {
                Tile nextMoveTile = getLevel().getTile(newPos);
                //Makes sure the new tile has matching colours
                if (validNextTile(nextMoveTile, null,
                        startPos, checkCharacters)) {
                    return newPos;
                }
            } else {
                stillInRange = false;
            }
        }
        return startPos;
    }

    /**
     * @return True if the character is still alive.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Kills a character.
     */
    public void kill() {
        alive = false;
        setImageFromFile(BONES_IMAGE);
    }

    /**
     * Decides if a character on specific tile can be collied with.
     * @param nextTilePosition The position of the tile.
     * @return True if the player can move, false if not.
     */
    protected boolean canCharactersCollide(final IntVector2D nextTilePosition) {
        Character collidingCharacter =
                getLevel().getSpecificCharacter(nextTilePosition);

        if (collidingCharacter != null) {
            return collidingCharacter.isCollidable() || canKill();
        }

        return true;
    }

    /**
     * Weather the character is able to affect items such as
     * pick up loot.
     * @return True if the player can collect/interact with items.
     */
    public boolean canInteractWithItems() {
        return true;
    }

    /**
     * Weather this character can kill other characters when moving
     * around the grid even if the character cannot be collided with.
     * @return True if this character kills others.
     */
    public boolean canKill() {
        return false;
    }

    /**
     * Weather other objects can collide into this character.
     * @return True if another object (character) can collide with this.
     */
    @Override
    public boolean isCollidable() {
        return !alive;
    }

    /**
     * Handles a collision event.
     * @param character The colliding character.
     */
    @Override
    public void onCollision(final Character character) {
        kill();
    }

    /**
     * Changes the position of the character on the grid and handles collisions.
     * @param inGridPosition New position on the grid.
     */
    @Override
    public void setGridPosition(final IntVector2D inGridPosition) {
        // If the characters coordinates are different trigger a collision
        if (!getGridPosition().equals(inGridPosition)) {
            Level level = getLevel();
            if (level != null) {
                level.onCharacterMove(this, inGridPosition);
            }
        }

        super.setGridPosition(inGridPosition);
    }
}
