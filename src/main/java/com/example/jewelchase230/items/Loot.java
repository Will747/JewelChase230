package com.example.jewelchase230.items;

import com.example.jewelchase230.vectors.IntVector2D;

/**
 * A collectable item that holds a reward when collected.
 *
 * @author Will Kaye and Ben Stott
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
     * Triggered when a player collides with loot
     */
    @Override
    public void doOnCollision() {
        getLevel().getPlayer().addToActiveScore(type.getValue());
        remove();
        checkIfDoorOpen();
    }

    /**
     * Triggered when a thief collides with loot.
     */
    @Override
    public void doOnThiefCollision() {
        remove();
        checkIfDoorOpen();
    }

    @Override 
    public void doOnExplosionCollision() {
        makeAsh();
        checkIfDoorOpen();
    }
}
