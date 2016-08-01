package org.zubovm.robot.geometry;

/**
 * Created by michael on 15.07.16.
 */
public class Point<T> {
    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    private final T x;
    private final T y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }
}
