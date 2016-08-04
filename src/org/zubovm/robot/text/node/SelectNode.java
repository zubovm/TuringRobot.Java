package org.zubovm.robot.text.node;

import org.zubovm.robot.geometry.Rectangle;
import org.zubovm.robot.text.AbstractCommandNode;

/**
 * Created by michael on 04.08.16.
 */
public class SelectNode extends AbstractCommandNode implements CommandNode {
    @Override
    public Rectangle<Integer> getHighlight() {
        return null;
    }
}
