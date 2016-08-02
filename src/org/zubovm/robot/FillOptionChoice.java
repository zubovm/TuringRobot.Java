package org.zubovm.robot;

/**
 * Created by michael on 02.08.16.
 */
public class FillOptionChoice {
    private final Class<MoveCommandNode> newNodeClass;
    private final RobotDocumentNode nodeToChange;
    private String label;

    public FillOptionChoice(Class<MoveCommandNode> nodeClass, RobotDocumentNode currentNode) {
        this.newNodeClass = nodeClass;
        this.nodeToChange = currentNode;
    }

    public String getLabel() {
        return label;
    }
}
