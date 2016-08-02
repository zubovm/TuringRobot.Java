package org.zubovm.robot;

import org.zubovm.robot.geometry.Rectangle;

/**
 * Created by michael on 02.08.16.
 */
public class MoveCommandNode implements RobotDocumentNode {
    public static final Class<RobotDocumentNode>[] ALL_THE_RIGHT_MOVES = new Class[] {
        MoveNorthNode.class, MoveSouthNode.class, MoveWestNode.class, MoveEastNode.class
    };

    @Override
    public String getText() {
        return null;
    }

    @Override
    public RobotDocumentNode stepIn() {
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
