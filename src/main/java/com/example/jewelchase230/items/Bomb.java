package com.example.jewelchase230.items;

import com.example.jewelchase230.Tile;
import com.example.jewelchase230.vectors.IntVector2D;

import java.util.ArrayList;

/**
 * A class to implement bombs and provide function when interacted with.
 *
 * @author Ben Stott
 */
public class Bomb extends Item {

    /** The bomb image. */
    private static final String BOMB_IMAGE = "images/BOMB.png";

    /** The time until the bomb explodes. */
    private int time;

    /** Array of all neighbouring tiles to this bomb. */
    private ArrayList<Tile> neighbouringTiles = getNeighbouringTiles();

    /**
     * Constructs a new bomb.
     * @param inTime The time delay until the bomb explodes.
     */
    public Bomb(final int inTime) {
        super(BOMB_IMAGE);
        setCollidable(false);
        time = inTime;
        setTriggers(getGridPosition());
    }

    /**
     * Sets the time until the bomb explodes.
     * @param newTime The time.
     */
    public void setTime(final int newTime) {
        this.time = newTime;
    }

    /**
     * @return The time until the bomb explodes.
     */
    public int getTime() {
        return this.time;
    }

    /**
     * Check if item type is valid to be removed.
     * @param item Item to have type checked if it's valid to be removed.
     * @return True if item can be removed, false if it cannot.
     */
    private Boolean checkValidRemove(Item item) {
        if (item instanceof Gate || item instanceof Door) {
            return false;
        }
        return true;
    }

    /**
     * Gets every neighbouring tile to this bombs position.
     * @return Every neighbouring tile.
     */
    public ArrayList<Tile> getNeighbouringTiles() {
        final IntVector2D maxSize = getLevel().getLevelSize();
        ArrayList<Tile> tileArray = new ArrayList<>();
        final IntVector2D thisPos = getGridPosition();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (!(x == 0 && x == 0)) {
                    IntVector2D tempVector = thisPos.add(new IntVector2D(x, y));
                    if (!(tempVector.getX() < 0 || tempVector.getY() < 0) &&
                    !(tempVector.getX() >= maxSize.getX() || tempVector.getY() >= maxSize.getY())) {
                        tileArray.add(getLevel().getTile(tempVector));
                    }
                }
            } 
        }
        return tileArray;
    }

    /**
     * Set or remove bomb triggers from neighbouring tiles.
     * @param bombPosInTile Current bomb position if triggerd, null if not.
     */
    private void setTriggers(IntVector2D bombPosInTile) {
        for (Tile tileInstance : neighbouringTiles) {
            tileInstance.setNextToBomb(bombPosInTile);
        }
    }

    /**
     * Explosion removing all items on the same row and column, expect gates and doors.
     */
    public void explode() {
        setTriggers(null);
        ArrayList<Item> itemArray = getLevel().getAllItems();
        final int currentXCoordinate = getGridPosition().getX();
        final int currentYCoordinate = getGridPosition().getY();
        for (Item itemInstance : itemArray) {
            int itemInstanceX = itemInstance.getGridPosition().getX();
            int itemInstanceY = itemInstance.getGridPosition().getX();
            if (itemInstanceX == currentXCoordinate || itemInstanceY == currentYCoordinate) {
                if (itemInstance instanceof Bomb) {
                    Bomb newBomb = (Bomb) itemInstance;
                    newBomb.explode();
                }
                if (checkValidRemove(itemInstance)) {
                    itemInstance.remove();
                }
            }
        }
    }

    /**
     * Counts down from 3 then explodes.
     */
    @Override
    public void doOnCollision() {
        for (int i = 0; i < 3; i++) { //change when there are different bomb countdown images
            tick(1000);
            //change image
        }
        explode();
        remove();
    }

    /**
     * Thief collision is the same as player collision for bombs.
     */
    @Override
    public void doOnThiefCollision() {
        doOnCollision();
    }
}
