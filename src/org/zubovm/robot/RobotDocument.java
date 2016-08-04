package org.zubovm.robot;

import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.text.node.ProgramNode;
import org.zubovm.robot.text.node.RobotDocumentNode;
import org.zubovm.robot.util.ListWithHandles;

import java.util.Properties;

/**
 * Created by michael on 31.07.16.
 */
public class RobotDocument {
    private ListWithHandles<RobotDocumentNode>.Handle currentHandle;
    private ProgramNode rootNode;

    public RobotDocument(String programName, Properties properties) {
        this.rootNode = new ProgramNode(programName, properties);
        ListWithHandles<RobotDocumentNode> rootList = new ListWithHandles<>();
        rootNode.initHandle(rootList.getZero().insertBefore(rootNode));
        //TODO incorporate initHandle into insertBefore and others extracting Handlable interface
        this.currentHandle = rootNode.getHandle();
    }

    public String getText() {
        return rootNode.getText();
    }

    public Rectangle<Integer> getHighlight() {
        return getCurrentNode().getHighlight();
        //return new Rectangle<Integer>(0, 0, 10 + programName.length(), 3);
    }

    public void stepIn() {
        currentHandle = currentHandle.getValue().stepIn().getHandle();
    }

    public RobotDocumentNode getCurrentNode() {
        return currentHandle.getValue();
    }

    public void stepOut() {
        currentHandle = currentHandle.getValue().stepOut().getHandle();
    }

    public void insertBefore() {
        getCurrentNode().insertBefore();
    }

    public void insertAfter() {
        getCurrentNode().insertAfter();
    }

    public void stepPrev() {
        currentHandle = getCurrentNode().stepPrev().getHandle();
        //TODO: may be stepPrev() and all that should return handle instead of node ?
    }

    public void stepNext() {
        currentHandle = getCurrentNode().stepNext().getHandle();
    }

    public ExpandOptionChooser expand() {
        return getCurrentNode().expand();
    }
}
