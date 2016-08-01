package org.zubovm.robot.geometry;

/**
 * Created by michael on 31.07.16.
 */
public class Util {
    public static String[] cutStrings(String[] strings, Rectangle<Integer> frame) {
        int cutSize = Math.max(0, Math.min(frame.getHeight(), strings.length - frame.getY()));
        String[] result = new String[cutSize];

        for (int stringNum = 0; stringNum < result.length; ++stringNum) {
            String string = strings[stringNum + frame.getY()];
            result[stringNum] = string.substring(
                    Math.min(frame.getX(), string.length()),
                    Math.min(frame.getX() + frame.getWidth(), string.length()));
        }
        return result;
    }

    public static String[] splitString(String string) {
        return string.split("\\R");
    }

    public static String join(String[] strings) {
        return String.join("\n", strings);
    }

    public static String cutString(String string, Rectangle<Integer> frame) {
        return join(cutStrings(splitString(string), frame));
    }
}
