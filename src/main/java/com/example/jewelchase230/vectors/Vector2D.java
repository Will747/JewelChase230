package com.example.jewelchase230.vectors;

/**
 * Two-dimensional vector.
 * @param <E> The type used by x,y coordinates.
 * @author Will Kaye
 */
public class Vector2D<E extends Number> {
    // Components of the vector.
    protected E x;
    protected E y;

    /**
     * Constructs a blank instance of Vector2D.
     */
    public Vector2D() {
    }

    /**
     * Constructs an instance of Vector2D.
     * @param x Initial X component.
     * @param y Initial Y component.
     */
    public Vector2D(E x, E y) {
        setX(x);
        setY(y);
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
     * @param x Changes the X component.
     */
    public void setX(E x) {
        this.x = x;
    }

    /**
     * @param y Changes the Y component.
     */
    public void setY(E y) {
        this.y = y;
    }
}
