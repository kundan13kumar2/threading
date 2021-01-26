package leetHard;

import java.util.HashMap;
import java.util.Map;

public class CountPattern {



    //Bill Number :: error
    static Map<Integer, Integer> map = new HashMap<>();


    static int recur(int n, int i) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        int s[] = new int[n+1];

        if (map.containsKey(n))
            return map.get(n);
        for (int j = 1; j <= n; j++)
            s[j] = j * recur(n, j) + recur(n, j - 1);

        map.put(n, s[n]);
        return map.get(n);

    }

    public static void main(String[] args) {
        System.out.println(recur(3,1));
    }

}
