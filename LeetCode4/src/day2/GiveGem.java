package day2;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class GiveGem {
    public static void main(String[] args) {
        int[] gem = {3, 1, 2};
        int[][] operations = {{0, 2}, {2, 1}, {2, 0}};
        System.out.println(new GiveGem().giveGem(gem, operations));
    }

    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int l = operation[0];
            int m = operation[1];
            gem[m] += gem[l] / 2;
            gem[l] = gem[l] - gem[l] / 2;
        }
        int min = gem[0];
        int max = gem[1];
        if (min > max) {
            min = max ^ min;
            max = max ^ min;
            min = max ^ min;
        }
        for (int i = 2; i < gem.length; i++) {
            if (gem[i] > max) {
                max = gem[i];
            }
            if (gem[i] < min) {
                min = gem[i];
            }
        }
        return max - min;
    }
}
