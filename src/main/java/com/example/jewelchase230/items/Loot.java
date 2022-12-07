package com.example.jewelchase230.items;

import com.example.jewelchase230.characters.Character;
import com.example.jewelchase230.characters.Player;

/**
 * A collectable item that holds a reward when collected.
 *
 * @author Will Kaye and Ben Stott
 */
public class Loot extends Item {
    /** The type of loot. */
    private LootType type;

    /**
     * Constructs a new item of loot.
     * Randomly selecting the type.
     */
    public Loot(int rarity) {
        super();
        switch (rarity) {
            case 1: {
                type = LootType.Coins;
                break;
            }
            case 2: {
                type = LootType.Bag;
                break;
            }
            case 3: {
                type = LootType.Beer;
                break;
            }
            case 4: {
                type = LootType.Cocktail;
                break;
            }
        }
        // type = LootType.getRandomType();
        setImageFromFile(type.getImage());
    }

    /**
     * Triggered when a player collides with loot.
     */
    @Override
    public void onCollision(final Character collidingCharacter) {
        if (collidingCharacter instanceof Player) {
            getLevel().incrementPlayerScore(type.getValue());
        }

        remove();
        checkIfDoorOpen();
    }

    /** Explosion collision for loot. */
    @Override
    public void doOnExplosionCollision() {
        checkIfDoorOpen();
        super.doOnExplosionCollision();
    }
}
