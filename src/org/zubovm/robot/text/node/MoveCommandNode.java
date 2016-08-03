package org.zubovm.robot.text.node;

import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.text.AbstractCommandNode;

/**
 * Created by michael on 02.08.16.
 */
public abstract class MoveCommandNode extends AbstractCommandNode {
    public static final Class<RobotDocumentNode>[] ALL_THE_RIGHT_MOVES = new Class[] {
        MoveNorthNode.class, MoveSouthNode.class, MoveWestNode.class, MoveEastNode.class
    };

    public MoveCommandNode(RobotDocumentNode parent) {
        super(parent);
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public Rectangle<Integer> getHighlight() {
        return null;
    }
}
