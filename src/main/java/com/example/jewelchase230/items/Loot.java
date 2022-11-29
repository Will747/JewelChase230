package com.example.jewelchase230.items;

/**
 * A collectable item that holds a reward when collected.
 *
 * @author Will Kaye
 */
public class Loot extends Item {
    /** The type of loot. */
    private final LootType type;

    /**
     * Constructs a new item of loot.
     * Randomly selecting the type.
     */
    public Loot() {
        super();
        type = LootType.getRandomType();
        setImageFromFile(type.getImage());
    }

    /**
     * Triggered when a thief collides with this item.
     */
    @Override
    public void doOnCollision() {
        super.doOnCollision();

        // Increment player score if the player collided here.
        checkIfDoorOpen();
    }
}
