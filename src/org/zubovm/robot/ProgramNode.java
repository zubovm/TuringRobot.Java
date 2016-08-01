package org.zubovm.robot;

import java.util.LinkedList;

/**
 * Created by michael on 02.08.16.
 */
public class ProgramNode implements RobotDocumentNode {
    private final String name;
    private final LinkedList<RobotDocumentNode> children;

    public ProgramNode(String programName) {
        this.name = programName;
        this.children = new LinkedList<RobotDocumentNode>();
    }

    @Override
    public String getText() {
        return "программа " + name + "\n<команда>\nконец";
    }

    @Override
    public RobotDocumentNode stepIn() {
        return null;
    }
}
