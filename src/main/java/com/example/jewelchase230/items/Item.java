package com.example.jewelchase230.items;
import com.example.jewelchase230.Collidable;
import com.example.jewelchase230.characters.Character;
import com.example.jewelchase230.Sprite;

import java.io.Serializable;


/**
 * The default class for all items.
 *
 * @author Ben Stott and Scott Williams
 */
public abstract class Item extends Sprite implements Collidable {

    /** Image for when the bomb has exploded. */
    private static final String ASHES_IMAGE = "images/BOMB_ASHES.png";

    /** True if the player can be on the same tile as item. */
    private boolean isCollidable = true;

    /** True if the item has been hit by an explosion. */
    private boolean hasExploded = false;

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

    /** @return hasExploded. */
    public boolean hasExploded() {
        return hasExploded;
    }

    /**
     * Sets 'hasExploded' to true.
     */
    public void setHasExploded() {
        hasExploded = true;
    }

    /**
     * Returns if the item can be shared with a character.
     * @return True if collidable, False if not.
     */
    @Override
    public boolean isCollidable() {
        return isCollidable;
    }

    /**
     * Change the collidable state of the item.
     * @param newCollidable The new collide condition for the item.
     */
    public void setCollidable(final boolean newCollidable) {
        isCollidable = newCollidable;
    }

    /**
     * Removes the item from the level.
     */
    public void remove() {
        if (!(hasExploded)) {
            getLevel().removeItem(getGridPosition());
        } else {
            doOnExplosionCollision();
        }
    }

    /**
     * Default player collision for all items.
     * @param collidingCharacter The character colliding with this item.
     */
    public void onCollision(final Character collidingCharacter) {
        remove();
    }

    /**
     * Default explosion collision for all items.
     */
    public void doOnExplosionCollision() { //put explode in tile
        hasExploded = true;
        isCollidable = true;
        setImageFromFile(ASHES_IMAGE);
    }
}
