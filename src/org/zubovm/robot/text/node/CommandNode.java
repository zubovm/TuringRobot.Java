package org.zubovm.robot.text.node;

/**
 * Created by michael on 03.08.16.
 */
public interface CommandNode extends RobotDocumentNode {
    @Override
    default RobotDocumentNode defaultReplacement() {
        return new EmptyCommandNode(getParent(), getProperties());
    }
}
