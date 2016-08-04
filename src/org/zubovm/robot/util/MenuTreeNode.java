package org.zubovm.robot.util;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.zubovm.robot.text.node.RobotDocumentNode;

import java.util.ArrayDeque;
import java.util.Properties;

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

    //TODO: move these method out from this class to break dependence
    public static Iterable<MenuTreeNode<RobotDocumentNode>> readMenuFromJSON(JSONArray jsonArray, Properties props) throws ClassNotFoundException {
        ArrayDeque<MenuTreeNode<RobotDocumentNode>> readMenu = new ArrayDeque<>();
        for (Object o: jsonArray) {
            readMenu.add(readMenuNodeFromJSON((JSONArray) o, props));
        }
        return readMenu;
    }

    public static MenuTreeNode<RobotDocumentNode> readMenuNodeFromJSON(JSONArray jsonArray, Properties props) throws ClassNotFoundException {
        String labelOrClassName = jsonArray.getString(0);
        JSONArray children = jsonArray.getJSONArray(1);
        if (children.size() == 0) {
            return new MenuTreeNode<RobotDocumentNode>(
                    props.getProperty(labelOrClassName+".menu.label"),
                    (Class<? extends RobotDocumentNode>)Class.forName(labelOrClassName),
                    null);
        } else {
            return new MenuTreeNode<RobotDocumentNode>(
                    labelOrClassName,
                    null,
                    readMenuFromJSON(children, props)
            );
        }
    }
}
