package org.zubovm.robot.util;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by michael on 02.08.16.
 */
public class ListWithHandles<E> implements Iterable<E> {

    public boolean isEmpty() {
        return getZero().next == getZero();
    }

    public class Handle {
        private Handle prev;
        private Handle next;
        private E value;

        Handle(E value) {
            this.value = value;
            this.prev = this;
            this.next = this;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Handle getNext() {
            return next;
        }

        public Handle getPrev() {
            return prev;
        }

        public Handle insertBefore(E newValue) {
            Handle newHandle = new Handle(newValue);

            newHandle.next = this;
            newHandle.prev = prev;
            prev.next = newHandle;
            prev = newHandle;

            return newHandle;
        }

        public Handle insertAfter(E newValue) {
            Handle newHandle = new Handle(newValue);

            newHandle.prev = this;
            newHandle.next = next;
            next.prev = newHandle;
            next = newHandle;

            return newHandle;
        }

        public boolean hasNext() {
            return next == ListWithHandles.this.zero;
        }

        public boolean hasPrev() {
            return prev == ListWithHandles.this.zero;
        }

        public Handle remove() {
            if (ListWithHandles.this.zero != this) {
                prev.next = next;
                next.prev = prev;

                return prev;
            } else {
                return this;
            }
        }
    }

    Handle zero = new Handle(null);

    public ListWithHandles() {}

    public Handle getZero() {
        return zero;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Handle ptr = zero;

            @Override
            public boolean hasNext() {
                return ptr.getNext() != zero;
            }

            @Override
            public E next() {
                ptr = ptr.getNext();
                return ptr.getValue();
            }
        };
    }
}
