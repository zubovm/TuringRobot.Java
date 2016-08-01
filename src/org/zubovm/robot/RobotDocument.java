package org.zubovm.robot;

import org.zubovm.robot.geometry.Rectangle;

/**
 * Created by michael on 31.07.16.
 */
public class RobotDocument {
    private final String programName;
    private RobotDocumentNode currentNode;
    private ProgramNode rootNode;

    public RobotDocument(String programName) {
        this.programName = programName;
        this.currentNode = this.rootNode = new ProgramNode(programName);
    }

    public String getText() {
        return rootNode.getText();
    }

    public Rectangle<Integer> getHighlight() {
        return currentNode.getHighlight();
        //return new Rectangle<Integer>(0, 0, 10 + programName.length(), 3);
    }

    public void stepIn() {
        currentNode = currentNode.stepIn();
    }

    public RobotDocumentNode getCurrentNode() {
        return currentNode;
    }

    public void stepOut() {
        currentNode = currentNode.stepOut();
    }
}
