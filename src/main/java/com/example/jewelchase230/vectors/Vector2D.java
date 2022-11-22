package com.example.jewelchase230.vectors;

/**
 * Two-dimensional vector.
 * @param <E> The type used by x,y coordinates.
 * @author Will Kaye
 */
public class Vector2D<E extends Number> {
    // Components of the vector.
    /** x component. */
    private E x;
    /** y component. */
    private E y;

    /**
     * Constructs a blank instance of Vector2D.
     */
    public Vector2D() {
    }

    /**
     * Constructs an instance of Vector2D.
     * @param inX Initial X component.
     * @param inY Initial Y component.
     */
    public Vector2D(final E inX, final E inY) {
        setX(inX);
        setY(inY);
    }

    /**
     * @return The X component.
     */
    public E getX() {
        return x;
    }

    /**
     * @return The Y component.
     */
    public E getY() {
        return y;
    }

    /**
     * @param inX Changes the X component.
     */
    public void setX(final E inX) {
        x = inX;
    }

    /**
     * @param inY Changes the Y component.
     */
    public void setY(final E inY) {
        y = inY;
    }
}
