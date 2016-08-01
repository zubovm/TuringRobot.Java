package org.zubovm.robot.explore;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by michael on 18.07.16.
 */
public class ExploreExpectations {

    static int[] prefixFunction(String str) {
        int[] result = new int[str.length() + 1];
        result[0] = -1;
        result[1] = 0;

        for (int i = 2; i < result.length; ++i) {
            int j = i - 1;
            for (; j > 0 && str.charAt(i - 1) != str.charAt(result[j]); j = result[j]) {}
            result[i] = result[j] + 1;
        }

        return result;
    }

    static int[] alterFunction(String str) {
        int[] _prefixFunction = prefixFunction(str);
        System.out.println("prefix function:" + Arrays.toString(_prefixFunction));
        int[] result = new int[str.length()];
        result[0] = 0;
        for (int i = 1; i < result.length; ++i) {
            int j = i;
            for(; j > 0 && str.charAt(i) == str.charAt(_prefixFunction[j]); j = _prefixFunction[j]) {
                //System.out.println("" + i + ": digressed to " + j);
            }
            result[i] = _prefixFunction[j] + 1;
        }
        return result;
    }

    public static int expectationForString(String str) {
        int[] M = new int[str.length()];
        int[] _alterFunction = alterFunction(str);
        M[0]  = 2;
        for (int i = 1; i < M.length; ++i) {
            M[i] = 2;
            for (int j = _alterFunction[i]; j < i; ++j) {
                M[i] += M[j];
            }
        }
        int result = 0;
        //System.out.println("alter function:" + Arrays.toString(_alterFunction));
        //System.out.println("shift expectations:" + Arrays.toString(M));
        for (int m: M) {
            result += m;
        }
        return result;
    }

    public static double checkExpectationForString(String str, int timesToRepeat) {
        int sumM = 0;
        Random randGen = new Random();
        for (int i = 0; i < timesToRepeat; ++i) {
            int M = 0;
            StringBuilder path = new StringBuilder();
            do {
                ++M;
                path.append(randGen.nextBoolean() ? '0' : '1');
            } while (!path.toString().endsWith(str));
            sumM += M;
        }
        return sumM * 1. / timesToRepeat;
    }

    static StringBuilder[] allBinaryStrings(int length) {
        if (length == 0) {
            return new StringBuilder[] {new StringBuilder()};
        } else {
            StringBuilder[] prevResult = allBinaryStrings(length - 1);
            StringBuilder[] result = new StringBuilder[2 * prevResult.length];
            for (int i = 0; i < prevResult.length; ++i) {
                result[2 * i] = new StringBuilder(prevResult[i]);
                result[2 * i].append("0");
                result[2 * i + 1] = prevResult[i];
                result[2 * i + 1].append("1");
            }
            return result;
        }
    }

    static double winWord(int iterations) {
        Random randGet = new Random();
        int wins = 0;
        for (int i = 0; i < iterations; ++i) {
            StringBuilder str = new StringBuilder();
            while (true) {
                str.append(randGet.nextBoolean() ? '0' : '1');
                if (str.toString().endsWith("0110")) {
                    break;
                }
                if (str.toString().endsWith("1010")) {
                    ++wins;
                    break;
                }
            }
        }
        return wins * 1. / iterations;
    }

    public static void main(String[] args) {
        Random randGenerator = new Random();
        int stepSum = 0;
        for (int i = 0; i < 1000; ++i) {
            int eaglesInARow = 0;
            int steps = 0;
            while (true) {
                if (randGenerator.nextBoolean()) {
                    ++eaglesInARow;
                } else {
                    eaglesInARow = 0;
                }
                ++steps;
                if (eaglesInARow == 2) {
                    stepSum += steps;
                    break;
                }
            }
        }
        System.out.println(stepSum * 0.001);
        System.out.println("prefix:");
        System.out.println(Arrays.toString(prefixFunction("0101011")));
        System.out.println(expectationForString("00"));
        System.out.println(expectationForString("01"));
        System.out.println(Arrays.toString(prefixFunction("01")));
        System.out.println(Arrays.toString(alterFunction("01")));
        System.out.println(Arrays.toString(allBinaryStrings(5)));

        for (StringBuilder sb: allBinaryStrings(6)) {
            System.out.println("" + sb.toString() + ":" + expectationForString(sb.toString())
                + ":" + checkExpectationForString(sb.toString(), 100));

        }
        System.out.println(""+expectationForString("0101")+":"+checkExpectationForString("0101", 1000000));
        System.out.println(winWord(1000000));
    }
}
