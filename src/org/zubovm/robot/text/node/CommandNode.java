package org.zubovm.robot.text.node;

/**
 * Created by michael on 03.08.16.
 */
public interface CommandNode extends RobotDocumentNode {
    @Override
    default RobotDocumentNode delete() {
        RobotDocumentNode newNode = new EmptyCommandNode(getParent());
        newNode.initHandle(getHandle());
        getHandle().setValue(newNode);
        return newNode;
    }

    @Override
    default RobotDocumentNode insertBefore() {
        RobotDocumentNode newNode = new EmptyCommandNode(getParent());
        newNode.initHandle(getHandle().insertBefore(newNode));
        return newNode;
    }

    @Override
    default RobotDocumentNode insertAfter() {
        RobotDocumentNode newNode = new EmptyCommandNode(getParent());
        newNode.initHandle(getHandle().insertAfter(newNode));
        return newNode;
    }
}
