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
     * @param x Initial X component.
     * @param y Initial Y component.
     */
    public IntVector2D(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Converts this int vector to a double vector.
     * @return Converted double vector.
     */
    public DoubleVector2D toDouble() {
        return new DoubleVector2D(x, y);
    }
}
