package org.zubovm.robot.text;

import org.zubovm.robot.geometry.Point;
import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.text.exceptions.GetRectFromNotBuiltNodeException;

/**
 * Created by michael on 14.07.16.
 */
public interface TextNode {
    public Iterable<StringBuilder> getText();
    public Rectangle<Integer> getRect() throws GetRectFromNotBuiltNodeException;
    public void init(Point<Integer> leftUpperCorner) throws GetRectFromNotBuiltNodeException;
}
