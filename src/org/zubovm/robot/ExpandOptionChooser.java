package org.zubovm.robot;

import java.util.Iterator;

/**
 * Created by michael on 02.08.16.
 */
public class ExpandOptionChooser implements Iterable<ExpandOptionChoice> {
    private final Iterable<ExpandOptionChoice> choices;

    public ExpandOptionChooser(Iterable<ExpandOptionChoice> choices) {
        this.choices = choices;
    }
    @Override
    public Iterator<ExpandOptionChoice> iterator() {
        return choices.iterator();
    }
}
