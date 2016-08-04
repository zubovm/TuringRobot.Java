package org.zubovm.robot.text.node;

import net.sf.json.JSONArray;
import org.zubovm.robot.ExpandOptionChooser;
import org.zubovm.robot.text.AbstractCommandNode;
import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.util.MenuTreeNode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

/**
 * Created by michael on 02.08.16.
 */
public class EmptyCommandNode extends AbstractCommandNode implements CommandNode {

    public static Collection<MenuTreeNode<RobotDocumentNode>> menu = Arrays.asList(
                new MenuTreeNode<RobotDocumentNode>("пока", MoveNorthNode.class, null),
                new MenuTreeNode<RobotDocumentNode>("выбор", MoveNorthNode.class, null),
                new MenuTreeNode<>("шаг на", null,
                        Arrays.asList(
                                new MenuTreeNode<>("север", MoveNorthNode.class, null),
                                new MenuTreeNode<>("юг", MoveNorthNode.class, null),
                                new MenuTreeNode<>("восток", MoveNorthNode.class, null),
                                new MenuTreeNode<RobotDocumentNode>("запад", MoveNorthNode.class, null)
                        )));

    public EmptyCommandNode(RobotDocumentNode parent) {
        super(parent);
    }


    @Override
    public Rectangle<Integer> getHighlight() {
        return new Rectangle<Integer>(1, 1, 9, 1);
    }

    @Override
    public ExpandOptionChooser expand() {
        try {
            return new ExpandOptionChooser(
                    MenuTreeNode.readMenuFromJSON(
                            JSONArray.fromObject(getProperties().getProperty("empty.command.base.menu")),
                            getProperties()),
                    this);
        } catch (ClassNotFoundException e) {
            //TODO: extend this with logging and catching at the top - or better provide a senseful exception instead
            throw new AssertionError(e);
        }
    }
};

