package org.zubovm.robot;

import org.zubovm.robot.test.EmptyCommandNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by michael on 02.08.16.
 */
public class ProgramNode implements RobotDocumentNode {
    private final String name;
    private final List<RobotDocumentNode> children;

    public ProgramNode(String programName) {
        this.name = programName;
        this.children = Arrays.asList(new EmptyCommandNode());
    }

    @Override
    public String getText() {
        return "программа " + name + "\n<команда>\nконец";
    }

    @Override
    public RobotDocumentNode stepIn() {
        return children.get(0);
    }
}
