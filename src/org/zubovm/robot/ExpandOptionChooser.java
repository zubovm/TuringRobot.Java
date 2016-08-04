package org.zubovm.robot;

import org.zubovm.robot.text.node.RobotDocumentNode;
import org.zubovm.robot.util.MenuTreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by michael on 02.08.16.
 */
public class ExpandOptionChooser implements Iterable<ExpandOptionChoice> {
    private final Iterable<MenuTreeNode<RobotDocumentNode>> choices;
    private final RobotDocumentNode target;

    public ExpandOptionChooser(Iterable<MenuTreeNode<RobotDocumentNode>> choices, RobotDocumentNode target) {
        this.choices = choices;
        this.target = target;
    }
    @Override
    public Iterator<ExpandOptionChoice> iterator() {
        return flatChoices().iterator();
    }

    public Collection<ExpandOptionChoice> flatChoices() {
        return flatChoices(choices);
    }

    public Collection<ExpandOptionChoice> flatChoices(Iterable<MenuTreeNode<RobotDocumentNode>> tree) {
        Queue<ExpandOptionChoice> result = new ArrayDeque<>();
        for (MenuTreeNode<RobotDocumentNode> menuNode: tree) {
            if (menuNode.value != null) {
                result.add(new ExpandOptionChoice(menuNode.label, menuNode.value, target));
            } else {
                result.addAll(flatChoices(menuNode.children));
            }
        }
        return result;
    }
}
