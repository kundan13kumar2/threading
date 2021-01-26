package leetHard;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquare {

     Map<Integer, Integer> map = new HashMap<>();

     int recur(int n) {
        if (n < 4)
            return n;
        if (map.containsKey(n))
            return map.get(n);
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++)
            count = Math.min(count, 1 + recur(n - (i * i)));
        map.put(n, count);
        return map.get(n);
    }


    public static void main(String[] args) {

        System.out.println(new PerfectSquare().recur(100));

    }
}
