package org.zubovm.robot.test;

import org.zubovm.robot.*;
import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.geometry.Util;
import org.zubovm.robot.text.EmptyCommandNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by michael on 31.07.16.
 */
public class RobotDocumentTest extends junit.framework.TestCase {

    public void testCreate() {
        RobotDocument doc = new RobotDocument("Program 0");
    }

    public void testInitialContent() {
        RobotDocument doc = new RobotDocument("Program 0");
        String text = doc.getText();
        assertEquals(text, "программа Program 0\n|<команда>\nконец");
    }

    public void testInitialHighlight() {
        RobotDocument doc = new RobotDocument("Program 0");
        Rectangle<Integer> highlight = doc.getHighlight();
        assertEquals(Util.cutString(doc.getText(), highlight), doc.getText());
    }

    public void testStepIn() {
        RobotDocument doc = new RobotDocument("Program 0");
        doc.stepIn();
        RobotDocumentNode node = doc.getCurrentNode();
        assertEquals(node.getClass(), EmptyCommandNode.class);
        Rectangle<Integer> highlight = doc.getHighlight();
        assertEquals(highlight, new Rectangle<Integer>(1, 1, 9, 1));
    }

    public void testStepOut() {
        RobotDocument doc = new RobotDocument("Program 0");
        doc.stepIn();
        doc.stepOut();
        RobotDocumentNode node = doc.getCurrentNode();
        assertEquals(node.getClass(), ProgramNode.class);
        doc.stepOut();
        assertEquals(doc.getCurrentNode().getClass(), ProgramNode.class);
    }

    public void testFillNode() {
        RobotDocument doc = new RobotDocument("Program 0");
        doc.stepIn();
        FillOptionChooser chooser = doc.getFillOptionChooser();
        Set<String> optionLabels = new HashSet<>();

        for (FillOptionChoice choice: chooser) {
            optionLabels.add(choice.getLabel());
        }

        assertEquals(optionLabels, new HashSet<>(
                Arrays.asList("шаг на юг", "шаг на север", "шаг на запад", "шаг на восток")));
    }

    public void testTextCut() {
        String str = "0123456789\n01234\n0123456";
        assertEquals("012345\n01234\n012345",
                Util.cutString(str, new Rectangle<Integer>(0, 0, 6, 3)));
        assertEquals("567\n\n56", Util.cutString(str, new Rectangle<Integer>(5, 0, 3, 3)));
        assertEquals("", Util.cutString(str, new Rectangle<Integer>(0, 5, 3, 3)));
    }
}