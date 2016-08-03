package org.zubovm.robot.text;

import org.zubovm.robot.text.node.RobotDocumentNode;
import org.zubovm.robot.util.ListWithHandles;

/**
 * Created by michael on 02.08.16.
 */
public abstract class AbstractCommandNode implements RobotDocumentNode {

    protected RobotDocumentNode parent;
    private ListWithHandles<RobotDocumentNode>.Handle handleToSelf;

    public AbstractCommandNode(RobotDocumentNode parent) {
        this.parent = parent;
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
    public RobotDocumentNode stepOut() {
        return parent;
    }

    @Override
    public RobotDocumentNode stepIn() {
        return this;
    }

    @Override
    public ListWithHandles<RobotDocumentNode>.Handle getHandle() {
        return handleToSelf;
    }
}
