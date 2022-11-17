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
    public DoubleVector2D(double x, double y) {
        setX(x);
        setY(y);
    }

    /**
     * Multiplies both components of vector by a value.
     * @param value The value to multiply by.
     * @return Multiplied vector.
     */
    public DoubleVector2D multiply(double value) {
        return new DoubleVector2D(x * value, y * value);
    }

    /**
     * Multiplies two vectors together.
     * @param value The vector to multiply by.
     * @return Multiplied vector.
     */
    public DoubleVector2D multiply(DoubleVector2D value) {
        return new DoubleVector2D(x * value.x, y * value.y);
    }

    /**
     * Multiplies both components of vector by a value.
     * @param value The value to multiply by.
     * @return Multiplied vector.
     */
    public DoubleVector2D multiply(int value) {
        return new DoubleVector2D(x * value, y * value);
    }

    /**
     * Multiplies two vectors together.
     * @param value The vector to multiply by.
     * @return Multiplied vector.
     */
    public DoubleVector2D multiply(IntVector2D value) {
        return new DoubleVector2D(x * value.getX(), y * value.getY());
    }

    /**
     * Divides both components of vector by a value.
     * @param value The value to divide by.
     * @return Divided vector.
     */
    public DoubleVector2D divide(double value) {
        return new DoubleVector2D(x / value, y / value);
    }

    /**
     * Divides vector by another vector.
     * @param value The vector to divide by.
     * @return Divided vector.
     */
    public DoubleVector2D divide(DoubleVector2D value) {
        return new DoubleVector2D(x / value.x, y / value.y);
    }

    /**
     * Divides both components of vector by a value.
     * @param value The value to divide by.
     * @return Divided vector.
     */
    public DoubleVector2D divide(int value) {
        return new DoubleVector2D(x / value, y / value);
    }

    /**
     * Divides vector by another vector.
     * @param value The vector to divide by.
     * @return Divided vector.
     */
    public DoubleVector2D divide(IntVector2D value) {
        return new DoubleVector2D(x / value.x, y / value.y);
    }

    /**
     * Adds two vectors together.
     * @param value The vector to add.
     * @return Added vector.
     */
    public DoubleVector2D add(DoubleVector2D value) {
        return new DoubleVector2D(x + value.x, y + value.y);
    }
}
