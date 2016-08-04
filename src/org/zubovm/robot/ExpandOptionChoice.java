package org.zubovm.robot;

import org.zubovm.robot.text.node.RobotDocumentNode;

import java.util.Properties;

/**
 * Created by michael on 02.08.16.
 */
public class ExpandOptionChoice {
    private final Class<RobotDocumentNode> newNodeClass;
    private final RobotDocumentNode nodeToChange;

    public String getLabel() {
        return label;
    }

    private String label;

    public ExpandOptionChoice(String label, Class<RobotDocumentNode> nodeClass, RobotDocumentNode currentNode) {
        this.label = label;
        this.newNodeClass = nodeClass;
        this.nodeToChange = currentNode;
    }

    public void expand() {
        try {
            RobotDocumentNode newNode = newNodeClass.newInstance();
            nodeToChange.replaceWith(newNode);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
