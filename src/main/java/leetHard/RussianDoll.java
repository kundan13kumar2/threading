package leetHard;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int counter = 1;
        int[] lis = new int[envelopes.length];
        Arrays.fill(lis, 1);

        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
            counter = Math.max(counter, lis[i]);
        }
        return counter;
    }

    public static void main(String[] args) {
        //int[][] envelopes = new int[][]{{15, 8}, {2, 20}, {2, 14}, {4, 17}, {8, 19}, {8, 9}, {5, 7}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {16, 1}, {18, 13}, {14, 17}, {18, 19}};
        int[][] envelopes = new int[][]{{1, 1}, {1, 1}, {1, 1}, {1, 1}};
        RussianDoll doll = new RussianDoll();
        System.out.println(doll.maxEnvelopes(envelopes));
    }
}
