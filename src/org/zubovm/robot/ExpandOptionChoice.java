package org.zubovm.robot;

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
            nodeToChange.replaceWith(newNodeClass.newInstance());
        } catch (InstantiationException e) {
            // TODO this is a bad code too
            e.printStackTrace();
            System.exit(0);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
