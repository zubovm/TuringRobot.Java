package org.zubovm.robot.test;

import org.zubovm.robot.RobotDocument;
import org.zubovm.robot.RobotDocumentNode;
import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.geometry.Util;

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
        assertEquals(text, "программа Program 0\n<команда>\nконец");
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
    }

    public void testTextCut() {
        String str = "0123456789\n01234\n0123456";
        assertEquals("012345\n01234\n012345",
                Util.cutString(str, new Rectangle<Integer>(0, 0, 6, 3)));
        assertEquals("567\n\n56", Util.cutString(str, new Rectangle<Integer>(5, 0, 3, 3)));
        assertEquals("", Util.cutString(str, new Rectangle<Integer>(0, 5, 3, 3)));
    }
}
