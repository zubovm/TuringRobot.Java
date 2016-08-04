package org.zubovm.robot.text.node;

import org.zubovm.robot.ExpandOptionChooser;
import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.util.ListWithHandles;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Properties;

/**
 * Created by michael on 02.08.16.
 */
public interface RobotDocumentNode {
    String getText();

    default LinkedList<StringBuilder> getLines() {
        return new LinkedList<>(Arrays.asList(new StringBuilder(getText())));
    }

    default RobotDocumentNode stepIn() {
        return getChildren() != null ? getFirstChild() : this;
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
        //TODO: may be empty expander will be better ?
    }

    default void replaceWith(RobotDocumentNode newNode) {
        newNode.setParent(getParent());
        newNode.setProperties(getProperties());
        newNode.initHandle(getHandle());
        getHandle().setValue(newNode);
    }

    void setProperties(Properties propertyProvider);

    void setParent(RobotDocumentNode parent);

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

    ListWithHandles<RobotDocumentNode> getChildren();
}
