package org.zubovm.robot;

import org.zubovm.robot.text.node.RobotDocumentNode;

/**
 * Created by michael on 02.08.16.
 */
public class ExpandOptionChoice {
    private final Class<RobotDocumentNode> newNodeClass;
    private final RobotDocumentNode nodeToChange;
    private String label;

    public ExpandOptionChoice(Class<RobotDocumentNode> nodeClass, RobotDocumentNode currentNode) {
        this.newNodeClass = nodeClass;
        this.nodeToChange = currentNode;
        try {
            label = (String) newNodeClass.getField("label").get(null);
        } catch (NoSuchFieldException e) {
            //TODO: this is a bad code !
            e.printStackTrace();
            System.exit(0);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public String getLabel() {
        return label;
    }

    public void expand() {
        try {
            nodeToChange.replaceWith(
                    newNodeClass.getConstructor(RobotDocumentNode.class).newInstance(nodeToChange.getParent()));
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
