package org.zubovm.robot.text;

import org.zubovm.robot.geometry.Rectangle;
import java.util.List;

/**
 * Created by michael on 14.07.16.
 */
public class BoundedText {
    private final List<StringBuilder> text;
    private final Rectangle<Integer> rect;

    public BoundedText(List<StringBuilder> text, Rectangle<Integer> rect) {
        this.text = text;
        this.rect = rect;
    }

    public Rectangle<Integer> getRect() {
        return rect;
    }
}
