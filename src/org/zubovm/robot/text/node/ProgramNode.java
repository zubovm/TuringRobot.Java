package org.zubovm.robot.text.node;

import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.text.AbstractCommandNode;

import java.util.Properties;

/**
 * Created by michael on 02.08.16.
 */
public class ProgramNode  extends AbstractCommandNode implements CommandNode  {
    private final String name;

    public ProgramNode(String programName, Properties properties) {
        super(properties);
        RobotDocumentNode emptyCommand = new EmptyCommandNode(this);
        emptyCommand.initHandle(children.getZero().insertBefore(emptyCommand));
        this.name = programName;
    }

    @Override
    public String getText() {
        return "программа " + name + "\n|<команда>\nконец";
    }

    @Override
    public Rectangle<Integer> getHighlight() {
        return new Rectangle<Integer>(0, 0, 10 + name.length(), 3);
    }

    @Override
    public RobotDocumentNode stepOut() {
        return this;
    }
}
