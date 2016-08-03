package org.zubovm.robot.text.node;

import org.zubovm.robot.ExpandOptionChooser;
import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.util.ListWithHandles;

import java.util.Properties;

/**
 * Created by michael on 02.08.16.
 */
public interface RobotDocumentNode {
    String getText();

    default RobotDocumentNode stepIn() {
        return getFirstChild();
    }

    RobotDocumentNode getFirstChild();

    Rectangle<Integer> getHighlight();

    default RobotDocumentNode stepOut() {
        return getParent();
    }

    default RobotDocumentNode stepPrev() {
        return getHandle().hasPrev() ? getHandle().getPrev().getValue() : this;
    }

    default RobotDocumentNode stepNext() {
        return getHandle().hasNext() ? getHandle().getNext().getValue() : this;
    }

    RobotDocumentNode defaultReplacement();

    default ExpandOptionChooser expand() {
        return null;
    }

    default void replaceWith(RobotDocumentNode newNode) {
        getHandle().setValue(newNode);
    }

    ListWithHandles<RobotDocumentNode>.Handle getHandle();
    RobotDocumentNode getParent();
    Properties getProperties();

    void initHandle(ListWithHandles<RobotDocumentNode>.Handle handle);

    default RobotDocumentNode delete() {
        RobotDocumentNode newNode = defaultReplacement();
        newNode.initHandle(getHandle());
        getHandle().setValue(newNode);
        return newNode;
    }

    default RobotDocumentNode insertBefore() {
        RobotDocumentNode newNode = defaultReplacement();
        newNode.initHandle(getHandle().insertBefore(newNode));
        return newNode;
    }

    default RobotDocumentNode insertAfter() {
        RobotDocumentNode newNode = defaultReplacement();
        newNode.initHandle(getHandle().insertAfter(newNode));
        return newNode;
    }
}
