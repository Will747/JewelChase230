package com.example.jewelchase230.items;

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

    /*public Item(String name, IntVector2D gridPos) {
        super(gridPos.getX(), gridPos.getY());

    }*/

    public void remove() {
        this.setGridPosition(new IntVector2D(-1, -1));
    }

    public void doOnCollision() {
        remove();
    }
}
