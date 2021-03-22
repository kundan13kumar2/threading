package leetHard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CircularPermutation {

    String getGreyCode(int myNum, int numOfBits) {
        if (numOfBits == 1)
            return String.valueOf(myNum);

        if (myNum >= Math.pow(2, (numOfBits - 1)))
            return "1" + getGreyCode((int) (Math.pow(2, (numOfBits))) - myNum - 1, numOfBits - 1);
        else
            return "0" + getGreyCode(myNum, numOfBits - 1);

    }

    int getGreyCode(int myNum) {

        int numOfBits = (int) (Math.log(myNum) / Math.log(2)) + 1;
        String greyCode = getGreyCode(myNum, numOfBits);
        return Integer.parseInt(greyCode, 2);
    }

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> result = new ArrayList<>();
        int k = (int) Math.pow(2, n);
        int[] greyArr = new int[k];

        int index = 0;
        greyArr[0] = 0;
        for (int i = 1; i < k; i++) {
            greyArr[i] = getGreyCode(i);
            if (greyArr[i] == start)
                index = i;
        }

        for (int j = index; j < k; j++)
            result.add(greyArr[j]);
        for (int j = 0; j < index; j++)
            result.add(greyArr[j]);


        return result;

    }

    void solve(int n, int start, List<Integer> output, Set<Integer> set) {
        for (int i = 0; i < n; i++) {
            int next = start ^ (1 << i);
            if (!set.contains(next)) {
                output.add(next);
                set.add(next);
                solve(n, next, output, set);
            }
        }
    }

    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int n = prices.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                min = prices[i - 1];
                //res+=prices[i]-prices[i-1];
                int max = prices[i];
                int j = i + 1;
                for (; j < n ; j++) {
                    max = Math.max(max, prices[j]);
                    if (prices[j - 1] > prices[j])
                        break;
                }
                System.out.println(max + " " + min);
                res += (max - min);
                i = j;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        CircularPermutation circularPermutation = new CircularPermutation();
        // circularPermutation.circularPermutation(3, 2);

        List<Integer> output = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        output.add(2);
        set.add(2);
        //circularPermutation.solve(3, 2, output, set);

        int[] prices = {7, 1, 5, 3, 6, 4};
        circularPermutation.maxProfit(prices);
        System.out.println(output);
    }
}
