package org.zubovm.robot;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by michael on 02.08.16.
 */
public class FillOptionChooser implements Iterable<FillOptionChoice> {
    private final Iterable<FillOptionChoice> choices;

    public FillOptionChooser(Iterable<FillOptionChoice> choices) {
        this.choices = choices;
    }
    @Override
    public Iterator<FillOptionChoice> iterator() {
        return choices.iterator();
    }
}
