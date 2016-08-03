package org.zubovm.robot.text.node;

import org.zubovm.robot.geometry.Rectangle;

/**
 * Created by michael on 02.08.16.
 */
public class MoveNorthNode  implements RobotDocumentNode {
    public static String label = "шаг на север";

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
