package org.zubovm.robot.test;

import org.zubovm.robot.RobotDocumentNode;
import org.zubovm.robot.geometry.Rectangle;

/**
 * Created by michael on 02.08.16.
 */
public class EmptyCommandNode implements RobotDocumentNode {
    @Override
    public String getText() {
        return "<команда>";
    }

    @Override
    public RobotDocumentNode stepIn() {
        return this;
    }

    @Override
    public Rectangle<Integer> getHighlight() {
        return new Rectangle<Integer>(1, 1, 9, 1);
    }
}
