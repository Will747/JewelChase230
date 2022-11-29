package com.example.jewelchase230.items;

import com.example.jewelchase230.Sprite;
import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.image.Image;
import java.util.ArrayList;

import java.io.FileNotFoundException;

public abstract class Item extends Sprite {

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

    /**
     * Default thief collision for all items.
     */
    public void doOnThiefCollision() {
        remove();
    }
}
