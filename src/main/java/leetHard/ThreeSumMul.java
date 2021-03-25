package leetHard;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumMul {

    public int threeSumMulti(int[] arr, int target) {
        int counter = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length - 2; i++) {
            countMap.clear();
            int rem = target - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int k = rem - arr[j];
                if (countMap.containsKey(k)) {
                    int p = countMap.get(k);
                    counter = (counter + p) % 1000000007;
                }
                int t = countMap.getOrDefault(arr[j], 0);
                countMap.put(arr[j], t + 1);

            }
        }
        return counter % 1000000007;
    }

    public static void main(String[] args) {
        ThreeSumMul mul = new ThreeSumMul();
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(mul.threeSumMulti(arr, 8));
    }
}
