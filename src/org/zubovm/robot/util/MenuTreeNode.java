package org.zubovm.robot.util;

/**
 * Created by michael on 02.08.16.
 */
public class MenuTreeNode<E> {

    public final Iterable<MenuTreeNode<E>> children;
    public final Class value;
    public final String label;

    public MenuTreeNode(String label, Class<? extends E> value, Iterable<MenuTreeNode<E>> children) {
        this.value = value;
        this.children = children;
        this.label = label;
    }
}
