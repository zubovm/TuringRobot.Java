package org.zubovm.robot.test;

import org.zubovm.robot.RobotDocumentNode;

/**
 * Created by michael on 02.08.16.
 */
public class EmptyCommandNode implements RobotDocumentNode {
    @Override
    public String getText() {
        return "<команда>";
    }

    @Override
    public RobotDocumentNode stepIn() {
        return this;
    }
}
