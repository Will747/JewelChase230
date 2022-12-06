package com.example.jewelchase230;
import com.example.jewelchase230.items.Item;
import com.example.jewelchase230.vectors.IntVector2D;
import java.util.ArrayList;

/**
 * Renders the characters to the game.
 *
 * @author Caroline Segestaaland and Ben Stott.
 */
public abstract class Character extends Sprite {
    /** True if the character is alive. */
    protected boolean isAlive = true;
    /** Bones image. */
    private static final String BONES_IMAGE = "images/BONES.png";
    /**
     * Constructs a renderable component.
     */
    public Character() {
        super();
    }

    /**
     * Checks that the next move is a valid move, if valid, collides
     * with items as expected.
     * @param nextMoveTile The tile to be moved to.
     * @param colourFollow The specific colour the next tile must be.
     * @param currentCharacter The current character attempting to move.
     * @return True if valid move, false if not.
     */
    private boolean validNextMove(final Tile nextMoveTile,
                                  final TileColour colourFollow,
                                  final Character currentCharacter) {
        Tile thisTile = getLevel().getTile(getGridPosition());
        ArrayList<TileColour> thisTileColours = new ArrayList<>();
        ArrayList<TileColour> nextTileColours = nextMoveTile.getTileColours();
        if (colourFollow == null) {
            thisTileColours = thisTile.getTileColours();
        } else {
            thisTileColours.add(colourFollow);
        }
        for (int i = 0; i < thisTileColours.size(); i++) {
            for (int j = 0; j < nextTileColours.size(); j++) {
                if (thisTileColours.get(i) == nextTileColours.get(j)) {
                    return characterCollisionManager(
                            nextMoveTile.getGridPosition(), currentCharacter);
                }
            }
        }
        return false;
    }

    /**
     * Checks if a character can move to a new tile.
     * @param xChange Positive for moving right, negative for moving left.
     * @param yChange Positive for moving down, negative for moving up.
     * @param collisionCharacter The character being moved.
     * @param colourFollow next tile must be of specific colour, null if none.
     * @return new tile position, or current position if invalid move.
     */
    protected IntVector2D canMove(final int xChange, final int yChange,
                                  final Character collisionCharacter,
                                  final TileColour colourFollow) {
        IntVector2D currentPos = getGridPosition();
        if (collisionCharacter instanceof FlyingAssassin) {
            IntVector2D newPos =
                    currentPos.add(new IntVector2D(xChange, yChange));
            if (getLevel().checkValidTile(newPos)
                    && characterCollisionManager(newPos, collisionCharacter)) {
                return newPos;
            } else {
                return currentPos;
            }
        } else {
            int xDiff = 0;
            int yDiff = 0;
            boolean stillInRange = true;
            while (stillInRange) {
                xDiff += xChange;
                yDiff += yChange;
                IntVector2D newPos =
                        currentPos.add(new IntVector2D(xDiff, yDiff));
                //Check the newPos is a valid tile
                if (getLevel().checkValidTile(newPos)) {
                    Tile nextMoveTile = getLevel().getTile(newPos);
                    //Makes sure the new tile has matching colours
                    if (validNextMove(nextMoveTile, colourFollow,
                            collisionCharacter)) {
                        return tileItemManager(nextMoveTile,
                                collisionCharacter);
                    }
                } else {
                    stillInRange = false;
                }
            }
        }
        return getGridPosition();
    }

    /**
     * Manages the logic for moving to a new tile.
     * @param tile tile to be moved to.
     * @param collisionCharacter Character moving to tile.
     * @return new tile position, or current position if invalid move.
     */
    private IntVector2D tileItemManager(Tile tile,
                                        Character collisionCharacter) {
        Item tileItem = tile.getItem();
        IntVector2D tilePos = tile.getGridPosition();
        if (!(tileItem == null)) { // checks tile has an item
            if (tileItem.getCollidable()) {
                itemCollisionManager(tileItem, collisionCharacter);
                return tilePos;
            } else {
                return getGridPosition();
            }
        }
        if (tile.isNextToBomb()) { //Checks tile is near a bomb
            bombManager(tile, collisionCharacter);
        }
        return tilePos;
    }

    /**
     * Manages triggering bombs.
     * @param tile tile with at least 1 bomb trigger.
     * @param collisionCharacter Character triggering the bomb.
     */
    private void bombManager(Tile tile, Character collisionCharacter) {
        ArrayList<Item> bombArray = tile.getBombs();
        for (Item bombInstance : bombArray) {
            itemCollisionManager(bombInstance, collisionCharacter);
        }
    }

    /**
     * Manages collisions between characters and items.
     * @param item Item colliding.
     * @param collisionCharacter Character colliding.
     */
    private void itemCollisionManager(Item item, Character collisionCharacter) {
        if (collisionCharacter instanceof AICharacter) {
            item.doOnThiefCollision();
        } else if (collisionCharacter instanceof Player) {
            item.doOnCollision();
        }
    }

    /**
     * Manages collisions between characters.
     * @param nextTilePosition The position of next moves tile.
     * @param currentCharacter The current character attempting to move.
     * @return True if the player can move, false if not.
     */
    private boolean characterCollisionManager(IntVector2D nextTilePosition,
                                              Character currentCharacter) {
        Character collidingCharacter = getLevel().getSpecificCharacter(
                nextTilePosition.getX(), nextTilePosition.getY());
        if (collidingCharacter != null) {
            if (collidingCharacter instanceof FlyingAssassin) {
                currentCharacter.doOnCollision();
                return true;
            } else if (currentCharacter instanceof FlyingAssassin) {
                collidingCharacter.doOnCollision();
                return true;
            } else if (collidingCharacter.isAlive){
                return false;
            } else {
                return true;
            }
        } else {
            return true;
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

    /**
     * Handles a collision event.
     */
    public void doOnCollision() {
        isAlive = false;
        setImageFromFile(BONES_IMAGE);
    }

    /**
     * Changes the position of the character on the grid and handles collisions.
     * @param inGridPosition New position on the grid.
     */
    @Override
    public void setGridPosition(final IntVector2D inGridPosition) {
        super.setGridPosition(inGridPosition);
    }
}
