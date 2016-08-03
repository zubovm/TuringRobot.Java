package org.zubovm.robot.text.node;

import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.text.AbstractCommandNode;

/**
 * Created by michael on 03.08.16.
 */
public class BrushNode extends AbstractCommandNode implements CommandNode {
    @Override
    public Rectangle<Integer> getHighlight() {
        return null;
    }
}
