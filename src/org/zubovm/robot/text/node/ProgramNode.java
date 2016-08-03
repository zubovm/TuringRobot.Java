package org.zubovm.robot.text.node;

import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.text.AbstractCommandNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by michael on 02.08.16.
 */
public class ProgramNode extends AbstractCommandNode {
    private final String name;
    private final List<RobotDocumentNode> children;

    public ProgramNode(String programName) {
        super();
        this.name = programName;
        this.children = Arrays.asList(new EmptyCommandNode(this));
    }

    @Override
    public String getText() {
        return "программа " + name + "\n|<команда>\nконец";
    }

    @Override
    public RobotDocumentNode stepIn() {
        return children.get(0);
    }

    @Override
    public Rectangle<Integer> getHighlight() {
        return new Rectangle<Integer>(0, 0, 10 + name.length(), 3);
    }

    @Override
    public RobotDocumentNode stepOut() {
        return this;
    }

    @Override
    public void replaceWith(RobotDocumentNode robotDocumentNode) {

    }
}
