package com.example.jewelchase230;

import com.example.jewelchase230.characters.Character;

/**
 * Any object on the grid that can be collided with
 * from the AI or a player.
 *
 * @author Will Kaye
 */
public interface Collidable {
    /**
     * Called when a character collides with this.
     *
     * @param movingCharacter The colliding character.
     */
    void onCollision(Character movingCharacter);

    /**
     * @return Weather the object can currently be collided with.
     */
    boolean isCollidable();
}
