package org.zubovm.robot.text;

import org.zubovm.robot.text.node.RobotDocumentNode;
import org.zubovm.robot.util.ListWithHandles;

import java.util.Properties;


/**
 * Created by michael on 02.08.16.
 */
public abstract class AbstractCommandNode implements RobotDocumentNode {

    @Override
    public void setProperties(Properties propertyProvider) {
        this.propertyProvider = propertyProvider;
    }

    @Override
    public void setParent(RobotDocumentNode parent) {
        this.parent = parent;
    }

    private Properties propertyProvider;
    protected RobotDocumentNode parent;
    private ListWithHandles<RobotDocumentNode>.Handle handleToSelf;
    private String text = null;
    public ListWithHandles<RobotDocumentNode> children;

    public AbstractCommandNode(RobotDocumentNode parent) {
        this.propertyProvider = parent.getProperties();
        this.parent = parent;
        this.children = new ListWithHandles<>();
    }

    public AbstractCommandNode(Properties propertyProvider) {
        this.propertyProvider = propertyProvider;
        this.parent = this;
        this.children = new ListWithHandles<>();
    }

    //TODO: delete this constructor in the end !
    public AbstractCommandNode() {}

    public void initHandle(ListWithHandles<RobotDocumentNode>.Handle handle) {
        this.handleToSelf = handle;
    }

    public void replaceWith(RobotDocumentNode newNode) {
        handleToSelf.setValue(newNode);
        newNode.initHandle(handleToSelf);
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
        return children.isEmpty() ? this : getFirstChild();
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
