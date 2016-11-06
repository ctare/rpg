package core.util;

import java.util.Random;

/**
 * Created by ctare on 2016/11/05.
 */
public class RandomUtil {
    private static final Random randomGenerator = new Random();
    public static int randint(int bound){
        return randomGenerator.nextInt(bound);
    }

    public static int randint(int start, int end){
        return randomGenerator.nextInt(end - start) + start;
    }

    public static boolean probability(int percentage){
        return Math.random() < percentage / 100.0;
    }

    public static boolean headOrTail(){
        return probability(50);
    }
}
