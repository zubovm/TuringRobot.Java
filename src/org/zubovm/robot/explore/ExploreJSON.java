package org.zubovm.robot.explore;

import net.sf.json.JSONArray;

/**
 * Created by michael on 04.08.16.
 */
public class ExploreJSON {

    public static void main(String[] args) {
        JSONArray jsonArray = JSONArray.fromObject(
                "[\n" +
                "   [ 'org.zubovm.robot.node.WhileNode' ,[]],\n" +
                "   [ 'org.zubovm.robot.node.SelectNode',[]],\n" +
                "   [ 'org.zubovm.robot.node.BrushNode' ,[]],\n" +
                "   [ 'шаг на', " +
                "       [\n" +
                "           ['org.zubovm.robot.node.MoveNorthNode', []],\n" +
                "           ['org.zubovm.robot.node.MoveSouthNode', []],\n" +
                "           ['org.zubovm.robot.node.MoveWestNode',  []],\n" +
                "           ['org.zubovm.robot.node.MoveEastNode',  []]\n" +
                "       ]\n" +
                "   ]\n" +
                "]\n");
        for (Object o: jsonArray) {
            System.out.println(o.getClass().getName());
            if (o instanceof JSONArray) {
                for (Object o1: (JSONArray)o) {
                    System.out.println('\t' + o1.getClass().getName());
                }
            }
        }
    }
}
