package org.zubovm.robot.text;

import org.zubovm.robot.geometry.Point;
import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.text.exceptions.GetRectFromNotBuiltNodeException;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by michael on 15.07.16.
 */
public class StringTextNode implements LineTextNode {
    private String text;
    private Rectangle<Integer> cachedRect = null;

    public StringTextNode(String text) {
        this.text = text;
    }

    @Override
    public StringBuilder getLine() {
        return new StringBuilder(text);
    }

    @Override
    public void init(Point<Integer> leftUpperCorner) {
        cachedRect = new Rectangle<Integer>(leftUpperCorner, text.length(), 1);
    }

    @Override
    public Iterable<StringBuilder> getText() {
        return Arrays.asList(new StringBuilder(text));
    }

    @Override
    public Rectangle<Integer> getRect() throws GetRectFromNotBuiltNodeException {
        if (cachedRect == null) {
            throw new GetRectFromNotBuiltNodeException();
        }
        return cachedRect;
    }
}
