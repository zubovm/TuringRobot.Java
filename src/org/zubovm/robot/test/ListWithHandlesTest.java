package org.zubovm.robot.test;

import junit.framework.TestCase;
import org.zubovm.robot.util.ListWithHandles;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by michael on 02.08.16.
 */
public class ListWithHandlesTest extends TestCase {
    public void testAll() {
        ListWithHandles<Integer> lst = new ListWithHandles<>();
        lst.getZero().insertBefore(1);
        lst.getZero().insertBefore(2);
        lst.getZero().insertBefore(3);

        LinkedList<Integer> lstForCheck = new LinkedList<Integer>();
        for (Integer i: lst) {
            lstForCheck.addLast(i);
        }
        assertEquals(lstForCheck, Arrays.asList(1, 2, 3));

        lst.getZero().getPrev().remove();
        lst.getZero().getNext().remove();

        lstForCheck = new LinkedList<Integer>();
        for (Integer i: lst) {
            lstForCheck.addLast(i);
        }
        assertEquals(lstForCheck, Arrays.asList(2));
    }
}
