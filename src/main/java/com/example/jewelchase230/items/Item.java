package com.example.jewelchase230.items;

import com.example.jewelchase230.Main;
import com.example.jewelchase230.Sprite;
import com.example.jewelchase230.vectors.IntVector2D;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Item extends Sprite {

    /**
     * Constructs a new item.
     * @param fileName The file path to image rendered by this item.
     */
    public Item(final String fileName) {
        super();

        if (fileName != null) {
            try {
                Image image = getImageFromFile(fileName);
                setImage(image);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Removes the item from the level
     */
    public void remove() {
        Main.getCurrentLevel().removeItem(this.getGridPosition());
        this.setGridPosition(new IntVector2D(-1, -1));
    }

    /**
     * Default collision for all items
     */
    public void doOnCollision() {
        remove();
    }
}
