package org.zubovm.robot.test;

import net.sf.json.JSONArray;
import org.zubovm.robot.*;
import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.geometry.Util;
import org.zubovm.robot.text.node.*;
import org.zubovm.robot.util.MenuTreeNode;

import java.awt.*;
import java.util.*;

/**
 * Created by michael on 31.07.16.
 */
public class RobotDocumentTest extends junit.framework.TestCase {


    private Properties props;

    public void testCreate() {
        RobotDocument doc = new RobotDocument("Program 0", props);
    }

    public void testInitialContent() {
        RobotDocument doc = new RobotDocument("Program 0", props);
        String text = doc.getText();
        assertEquals(text, "программа Program 0\n|<команда>\nконец");
    }

    public void testInitialHighlight() {
        RobotDocument doc = new RobotDocument("Program 0", props);
        Rectangle<Integer> highlight = doc.getHighlight();
        assertEquals(Util.cutString(doc.getText(), highlight), doc.getText());
    }

    public void testStepIn() {
        RobotDocument doc = new RobotDocument("Program 0", props);
        doc.stepIn();
        RobotDocumentNode node = doc.getCurrentNode();
        assertEquals(node.getClass(), EmptyCommandNode.class);
        Rectangle<Integer> highlight = doc.getHighlight();
        assertEquals(highlight, new Rectangle<Integer>(1, 1, 9, 1));
    }

    public void testStepOut() {
        RobotDocument doc = new RobotDocument("Program 0", props);
        doc.stepIn();
        doc.stepOut();
        RobotDocumentNode node = doc.getCurrentNode();
        assertEquals(node.getClass(), ProgramNode.class);
        doc.stepOut();
        assertEquals(doc.getCurrentNode().getClass(), ProgramNode.class);
    }

    public void testNodeExpander() {
        RobotDocument doc = new RobotDocument("Program 0", props);
        doc.stepIn();
        ExpandOptionChooser chooser = doc.getCurrentNode().expand();
        Set<String> optionLabels = new HashSet<>();

        for (ExpandOptionChoice choice: chooser) {
            optionLabels.add(choice.getLabel());
        }

        assertEquals(optionLabels, new HashSet<>(
                Arrays.asList("юг", "север", "запад", "восток", "закрасить", "пока", "выбор")));
    }

    public void testNodeExpand() throws ClassNotFoundException {
        RobotDocument doc = new RobotDocument("Program 0", props);
        doc.stepIn();
        SortedSet<ExpandOptionChoice> optionLabels = new TreeSet<>(
                (lhs, rhs) -> lhs.getLabel().compareTo(rhs.getLabel()));
        ExpandOptionChooser expander = new ExpandOptionChooser(
                        MenuTreeNode.readMenuFromJSON(
                            JSONArray.fromObject(props.getProperty("empty.command.base.menu")),
                            props),
                        doc.getCurrentNode());
        optionLabels.addAll(expander.flatChoices());

        optionLabels.first().expand();
        assertEquals(doc.getCurrentNode().getClass(), MoveEastNode.class);
    }

    public void testSimpleNavigationAndExpanding() {
        RobotDocument doc = new RobotDocument("HelloRobot", props);
        doc.stepIn();
        doc.insertBefore();
        doc.insertAfter();
        doc.stepPrev();
        doc.expand().expandByLabel("север");
        doc.stepNext();
        doc.expand().expandByLabel("юг");
        doc.stepNext();
        doc.expand().expandByLabel("восток");
        assertEquals(doc.getText(),
                "программа HelloRobot\n" +
                "|шаг на север\n" +
                "|шаг на юг\n" +
                "|шаг на восток\n" +
                "конец"
                );
    }

    public void testTextCut() {
        String str = "0123456789\n01234\n0123456";
        assertEquals("012345\n01234\n012345",
                Util.cutString(str, new Rectangle<Integer>(0, 0, 6, 3)));
        assertEquals("567\n\n56", Util.cutString(str, new Rectangle<Integer>(5, 0, 3, 3)));
        assertEquals("", Util.cutString(str, new Rectangle<Integer>(0, 5, 3, 3)));
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        props = new Properties();
        props.setProperty("empty.command.base.menu",
                "[\n" +
                        "   [ 'org.zubovm.robot.text.node.WhileNode' ,[]],\n" +
                        "   [ 'org.zubovm.robot.text.node.SelectNode',[]],\n" +
                        "   [ 'org.zubovm.robot.text.node.BrushNode' ,[]],\n" +
                        "   [ 'шаг на', " +
                        "       [\n" +
                        "           ['org.zubovm.robot.text.node.MoveNorthNode', []],\n" +
                        "           ['org.zubovm.robot.text.node.MoveSouthNode', []],\n" +
                        "           ['org.zubovm.robot.text.node.MoveWestNode',  []],\n" +
                        "           ['org.zubovm.robot.text.node.MoveEastNode',  []]\n" +
                        "       ]\n" +
                        "   ]\n" +
                "]\n");
        props.setProperty("org.zubovm.robot.text.node.WhileNode.menu.label", "пока");
        props.setProperty("org.zubovm.robot.text.node.SelectNode.menu.label", "выбор");
        props.setProperty("org.zubovm.robot.text.node.BrushNode.menu.label", "закрасить");
        props.setProperty("org.zubovm.robot.text.node.MoveNorthNode.menu.label", "север");
        props.setProperty("org.zubovm.robot.text.node.MoveSouthNode.menu.label", "юг");
        props.setProperty("org.zubovm.robot.text.node.MoveWestNode.menu.label", "запад");
        props.setProperty("org.zubovm.robot.text.node.MoveEastNode.menu.label", "восток");

        props.setProperty("org.zubovm.robot.text.node.EmptyCommandNode.text", "<команда>");
        props.setProperty("org.zubovm.robot.text.node.WhileNode.text", "пока");
        props.setProperty("org.zubovm.robot.text.node.SelectNode.text", "выбор");
        props.setProperty("org.zubovm.robot.text.node.BrushNode.text", "закрасить");
        props.setProperty("org.zubovm.robot.text.node.MoveNorthNode.text", "шаг на север");
        props.setProperty("org.zubovm.robot.text.node.MoveSouthNode.text", "шаг на юг");
        props.setProperty("org.zubovm.robot.text.node.MoveWestNode.text", "шаг на запад");
        props.setProperty("org.zubovm.robot.text.node.MoveEastNode.text", "шаг на восток");
    }
}