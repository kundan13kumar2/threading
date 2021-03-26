package leetHard;

import java.util.*;

public class AdvShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        int[] result = new int[A.length];

        Arrays.fill(result, -1);

        Queue<Integer> indexes = new LinkedList<>();
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            map.putIfAbsent(B[i], new LinkedList<>());
            map.get(B[i]).add(i);
        }

        Arrays.sort(A);
        Arrays.sort(B);
        int k = 0;
        int j = 0;
        for (int i = 0; i < B.length; i++) {
            if (A[i] <= B[j]) {
                indexes.add(A[i]);
            } else {
                k = map.get(B[j]).remove();
                result[k] = A[i];
                j++;
            }
        }
        int p = 0;
        while (!indexes.isEmpty()) {
            if (result[p] == -1) {
                result[p] = indexes.remove();

            }
            p++;
        }

        return result;
    }

    public static void main(String[] args) {
        AdvShuffle advShuffle = new AdvShuffle();
        int[] A = {2, 7, 11, 15}, B = {1, 10, 4, 11};
        System.out.println(Arrays.toString(advShuffle.advantageCount(A, B)));
    }
}
