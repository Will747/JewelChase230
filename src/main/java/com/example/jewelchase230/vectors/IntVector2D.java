package com.example.jewelchase230.vectors;

/**
 * Two dimensional integer vector.
 *
 * @author Will Kaye
 */
public class IntVector2D extends Vector2D<Integer> {

    /**
     * Constructs a blank vector.
     */
    public IntVector2D() {
    }

    /**
     * Constructs a new instance of vector.
     *
     * @param x Initial X component.
     * @param y Initial Y component.
     */
    public IntVector2D(final int x, final int y) {
        setX(x);
        setY(y);
    }

    /**
     * Adds two vectors together.
     *
     * @param value vector to add.
     * @return sum of both vectors.
     */
    public IntVector2D add(final IntVector2D value) {
        return new IntVector2D(getX() + value.getX(), getY() + value.getY());
    }

    /**
     * Converts this int vector to a double vector.
     *
     * @return Converted double vector.
     */
    public DoubleVector2D toDouble() {
        return new DoubleVector2D(getX(), getY());
    }
}
