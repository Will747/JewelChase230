package com.example.jewelchase230.items;

import com.example.jewelchase230.Sprite;
import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.image.Image;
import java.util.ArrayList;

import java.io.FileNotFoundException;

/**
 * The default class for all items.
 *
 * @author Ben Stott and Scott Williams
 */
public abstract class Item extends Sprite {

    /** True if the player can be on the same tile as item. */
    private boolean isCollidable = true;

    /**
     * Constructs a new item without image to render.
     */
    public Item() {
    }

    /**
     * Constructs a new item.
     * @param fileName The file path to image rendered by this item.
     */
    public Item(final String fileName) {
        super();

        if (fileName != null) {
            setImageFromFile(fileName);
        }
    }

    /**
     * Returns if the tile the item is on can be shared with a player.
     * @return True if collidable, False if not.
     */
    public boolean getCollidable() {
        return isCollidable;
    }

    /**
     * Change the collidable state of the item.
     * @param newCollidable The new collide condition for the item.
     */
    public void setCollidable(boolean newCollidable) {
        isCollidable = newCollidable;
    }


    /**
     * Checks if all loot and levers have been collected and opens the door if they have.
     */
    public void checkIfDoorOpen() {
        ArrayList<Lever> leverArray = getLevel().getAllItemsOfType(Lever.class);
        ArrayList<Loot> lootArray = getLevel().getAllItemsOfType(Loot.class);
        if (leverArray.size() == 0 && lootArray.size() == 0) {
            ArrayList<Door> doorArray = getLevel().getAllItemsOfType(Door.class);
            for (Door doorInstance : doorArray) {
                doorInstance.setIsDoorOpen(true);
            }
        }
    }

    /**
     * Removes the item from the level.
     */
    public void remove() {
        getLevel().removeItem(getGridPosition());
        this.setGridPosition(new IntVector2D(-1, -1));
    }

    /**
     * Default player collision for all items.
     */
    public void doOnCollision() {
        remove();
    }

    public void doOnExplosionCollision() {
        remove();
    }

    /**
     * Default thief collision for all items.
     */
    public void doOnThiefCollision() {
        remove();
    }
}
