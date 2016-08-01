package org.zubovm.robot.text;

import org.zubovm.robot.geometry.Point;
import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.text.exceptions.GetRectFromNotBuiltNodeException;

/**
 * Created by michael on 16.07.16.
 */
public class BoxTextNode implements TextNode {

    //public BoxTextNode(Iterable<TextNode>)

    @Override
    public Iterable<StringBuilder> getText() {
        return null;
    }

    @Override
    public Rectangle<Integer> getRect() throws GetRectFromNotBuiltNodeException {
        return null;
    }

    @Override
    public void init(Point<Integer> leftUpperCorner) throws GetRectFromNotBuiltNodeException {

    }
}
