package org.zubovm.robot;

import org.zubovm.robot.geometry.Rectangle;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by michael on 31.07.16.
 */
public class RobotDocument {
    private RobotDocumentNode currentNode;
    private ProgramNode rootNode;
    private ExpandOptionChooser expandOptionChooser;

    public RobotDocument(String programName) {
        this.currentNode = this.rootNode = new ProgramNode(programName);
        this.expandOptionChooser = new ExpandOptionChooser(
                Arrays.stream(MoveCommandNode.ALL_THE_RIGHT_MOVES).map(
                        nodeClass -> new ExpandOptionChoice(nodeClass, currentNode)).collect(Collectors.toList())
                );
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

    public ExpandOptionChooser getExpandOptionChooser() {
        return expandOptionChooser;
    }
}
