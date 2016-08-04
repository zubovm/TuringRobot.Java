package org.zubovm.robot.text.node;

import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.text.AbstractCommandNode;

/**
 * Created by michael on 02.08.16.
 */
public class MoveNorthNode extends AbstractCommandNode implements CommandNode {

    @Override
    public RobotDocumentNode stepIn() {
        return null;
    }

    @Override
    public RobotDocumentNode getFirstChild() {
        return null;
    }

    @Override
    public Rectangle<Integer> getHighlight() {
        return null;
    }

    @Override
    public RobotDocumentNode stepOut() {
        return null;
    }

    @Override
    public void replaceWith(RobotDocumentNode robotDocumentNode) {

    }
}
