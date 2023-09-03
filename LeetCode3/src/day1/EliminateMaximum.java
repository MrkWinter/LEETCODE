package day1;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class EliminateMaximum {
    public static void main(String[] args) {
        int[] dist = {1, 3, 4};
        int[] speed = {1, 1, 1};
//        int[] dist = {1, 1, 2, 3};
//        int[] speed = {1, 1, 1, 1};
//        int[] dist =
//                {46, 33, 44, 42, 46, 36, 7, 36, 31, 47, 38, 42, 43, 48, 48, 25, 28, 44, 49, 47, 29, 32, 30, 6, 42, 9, 39, 48, 22, 26, 50, 34, 40, 22, 10, 45, 7, 43, 24, 18, 40, 44, 17, 39, 36};
//        int[] speed =
//                {1, 2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 3, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 8, 1, 1, 1, 3, 6, 1, 3, 1, 1};
//        int[] dist = {3, 2, 4};
//        int[] speed = {5, 3, 2};
        int i = new EliminateMaximum().eliminateMaximum2(dist, speed);
        System.out.println(i);
    }

    public int eliminateMaximum1(int[] dist, int[] speed) {
        int count = 0;
        int minIndex = 0;
        int minNUM = 0;
        for (int i = 0; i < dist.length; i++) {
            //前进
            minNUM = Integer.MAX_VALUE;
            for (int j = 0; j < dist.length; j++) {
                if (dist[j] != Integer.MIN_VALUE) {
                    dist[j] = dist[j] - speed[j];
                    //找最考前值
                    if (dist[j] < minNUM) {
                        minIndex = j;
                        minNUM = dist[j];
                    }
                }
            }
            //杀死
            dist[minIndex] = Integer.MIN_VALUE;
            count++;
            for (int j = 0; j < dist.length; j++) {
                if (dist[j] != Integer.MIN_VALUE && dist[j] <= 0) {
                    return count;
                }
            }
        }
        return count;
    }

    public int eliminateMaximum2(int[] dist, int[] speed) {
        int[] step = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            step[i] = (dist[i] - 1) / speed[i] + 1;
        }
        Arrays.sort(step);
        for (int i = 0; i < step.length; i++) {
            if (step[i] <= i) {
                return i;
            }
        }
        return dist.length;
    }
}
