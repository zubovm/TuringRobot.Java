package org.zubovm.robot.text;

import org.zubovm.robot.RobotDocumentNode;
import org.zubovm.robot.geometry.Rectangle;

/**
 * Created by michael on 02.08.16.
 */
public class EmptyCommandNode implements RobotDocumentNode {
    private RobotDocumentNode parent;

    public EmptyCommandNode(RobotDocumentNode parent) {
        this.parent = parent;
    }

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

    @Override
    public RobotDocumentNode stepOut() {
        return parent;
    }

    @Override
    public void replaceWith(RobotDocumentNode robotDocumentNode) {

    }
}
