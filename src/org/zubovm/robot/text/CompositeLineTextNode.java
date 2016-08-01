package org.zubovm.robot.text;

import org.w3c.dom.Text;
import org.zubovm.robot.geometry.Point;
import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.text.exceptions.GetRectFromNotBuiltNodeException;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by michael on 15.07.16.
 */
public class CompositeLineTextNode implements LineTextNode {

    private final Iterable<LineTextNode> children;
    private StringBuilder cachedLine;
    private Rectangle<Integer> cachedRect;

    public CompositeLineTextNode(Iterable<LineTextNode> children) {
        this.children = children;
    }

    @Override
    public void init(Point<Integer> leftUpperCorner) throws GetRectFromNotBuiltNodeException {
        cachedLine = new StringBuilder();
        int width = 0;
        for (LineTextNode child: children) {
            width += child.getRect().getWidth();
            cachedLine.append(child.getLine());
        }
    }

    @Override
    public Iterable<StringBuilder> getText() {
        return Arrays.asList(cachedLine);
    }

    @Override
    public Rectangle<Integer> getRect() throws GetRectFromNotBuiltNodeException {
        return cachedRect;
    }

    @Override
    public StringBuilder getLine() {
        return cachedLine;
    }
}
