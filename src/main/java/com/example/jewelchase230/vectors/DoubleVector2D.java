package com.example.jewelchase230.vectors;

/**
 * Two dimensional double vector.
 *
 * @author Will Kaye
 */
public class DoubleVector2D extends Vector2D<Double> {

    /**
     * Constructs a blank vector.
     */
    public DoubleVector2D() {
    }

    /**
     * Constructs a new instance of vector.
     * @param x Initial X component.
     * @param y Initial Y component.
     */
    public DoubleVector2D(final double x, final double y) {
        setX(x);
        setY(y);
    }

    /**
     * Multiplies both components of vector by a value.
     * @param value The value to multiply by.
     * @return Multiplied vector.
     */
    public DoubleVector2D multiply(final double value) {
        return new DoubleVector2D(getX() * value, getY() * value);
    }

    /**
     * Multiplies two vectors together.
     * @param value The vector to multiply by.
     * @return Multiplied vector.
     */
    public DoubleVector2D multiply(final DoubleVector2D value) {
        return new DoubleVector2D(getX() * value.getX(), getY() * value.getY());
    }

    /**
     * Multiplies both components of vector by a value.
     * @param value The value to multiply by.
     * @return Multiplied vector.
     */
    public DoubleVector2D multiply(final int value) {
        return new DoubleVector2D(getX() * value, getY() * value);
    }

    /**
     * Multiplies two vectors together.
     * @param value The vector to multiply by.
     * @return Multiplied vector.
     */
    public DoubleVector2D multiply(final IntVector2D value) {
        return new DoubleVector2D(getX() * value.getX(), getY() * value.getY());
    }

    /**
     * Divides both components of vector by a value.
     * @param value The value to divide by.
     * @return Divided vector.
     */
    public DoubleVector2D divide(final double value) {
        return new DoubleVector2D(getX() / value, getY() / value);
    }

    /**
     * Divides vector by another vector.
     * @param value The vector to divide by.
     * @return Divided vector.
     */
    public DoubleVector2D divide(final DoubleVector2D value) {
        return new DoubleVector2D(getX() / value.getX(), getY() / value.getY());
    }

    /**
     * Divides both components of vector by a value.
     * @param value The value to divide by.
     * @return Divided vector.
     */
    public DoubleVector2D divide(final int value) {
        return new DoubleVector2D(getX() / value, getY() / value);
    }

    /**
     * Divides vector by another vector.
     * @param value The vector to divide by.
     * @return Divided vector.
     */
    public DoubleVector2D divide(final IntVector2D value) {
        return new DoubleVector2D(getX() / value.getX(), getY() / value.getY());
    }

    /**
     * Adds two vectors together.
     * @param value The vector to add.
     * @return Added vector.
     */
    public DoubleVector2D add(final DoubleVector2D value) {
        return new DoubleVector2D(getX() + value.getX(), getY() + value.getY());
    }

    /**
     * Adds a double to both components of this vector.
     * @param value The vector to add.
     * @return Added vector.
     */
    public DoubleVector2D add(final double value) {
        return new DoubleVector2D(getX() + value, getY() + value);
    }

    /**
     * Subtracts one vector from another.
     * @param value The vector to subtract.
     * @return subtracted vector.
     */
    public DoubleVector2D minus(final DoubleVector2D value) {
        return new DoubleVector2D(getX() - value.getX(), getY() - value.getY());
    }
}
