package org.zubovm.robot.geometry;

/**
 * Created by michael on 15.07.16.
 */
public class Rectangle<T> {
    private final T x;
    private final T y;
    private final T width;
    private final T height;

    public Rectangle(T x, T y, T width, T height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point<T> leftCorner, T width, T height) {
        this(leftCorner.getX(), leftCorner.getY(), width, height);
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public T getWidth() {
        return width;
    }

    public T getHeight() {
        return height;
    }
}
