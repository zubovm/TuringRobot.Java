package org.zubovm.robot;

import org.zubovm.robot.geometry.Rectangle;

/**
 * Created by michael on 02.08.16.
 */
public interface RobotDocumentNode {
    String getText();
    RobotDocumentNode stepIn();
    Rectangle<Integer> getHighlight();
    RobotDocumentNode stepOut();
}
