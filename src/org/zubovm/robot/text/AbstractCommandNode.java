package org.zubovm.robot.text;

import org.zubovm.robot.text.node.RobotDocumentNode;
import org.zubovm.robot.util.ListWithHandles;

import java.util.Properties;


/**
 * Created by michael on 02.08.16.
 */
public abstract class AbstractCommandNode implements RobotDocumentNode {

    private Properties propertyProvider;
    protected RobotDocumentNode parent;
    private ListWithHandles<RobotDocumentNode>.Handle handleToSelf;
    private String text = null;
    private ListWithHandles<RobotDocumentNode> children;

    public AbstractCommandNode(RobotDocumentNode parent, Properties propProvider) {
        this.propertyProvider = propProvider;
        this.parent = parent;
        this.children = new ListWithHandles<>();
    }

    public AbstractCommandNode() {
        parent = this;
    }

    public void initHandle(ListWithHandles<RobotDocumentNode>.Handle handle) {
        this.handleToSelf = handle;
    }

    public void replaceWith(RobotDocumentNode newNode) {
        handleToSelf.setValue(newNode);
    }

    @Override
    public RobotDocumentNode getParent() {
        return parent;
    }

    @Override
    public Properties getProperties() {
        return propertyProvider;
    }

    @Override
    public RobotDocumentNode stepOut() {
        return parent;
    }

    @Override
    public String getText() {
        if (text == null) {
            text = propertyProvider.getProperty(getClass().getName()+".");
        }
        return text;
    }

    @Override
    public RobotDocumentNode stepIn() {
        return this;
    }

    @Override
    public RobotDocumentNode getFirstChild() {
        return children.iterator().next();
    }

    @Override
    public ListWithHandles<RobotDocumentNode>.Handle getHandle() {
        return handleToSelf;
    }
}
