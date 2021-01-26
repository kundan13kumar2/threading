package leetHard;

import java.util.Arrays;

public class ReducingDishes {

    static int getFirstNonNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] >= 0)
                return i;
        return -1;
    }

    static int getCSFromFirstNonNegativeInteger(int[] arr, int index) {
        int sum = 0;
        for (int i = index; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }

    static int getLTC(int[] arr, int index) {
        int sum = 0;
        int k = 1;
        for (int i = index; i < arr.length; i++, k++)
            sum += arr[i] * k;
        return sum;
    }


    public static void main(String[] args) {

        int[] arr = {-2, 5, -1, 0, 3, -3};
        Arrays.sort(arr);
        int firstNonNegative = getFirstNonNegative(arr);


        if (firstNonNegative < 0) System.out.println(0);
        int cs = getCSFromFirstNonNegativeInteger(arr, firstNonNegative);
        int val = getLTC(arr, firstNonNegative);

        firstNonNegative -= 1;
        while (firstNonNegative >= 0) {
            cs = cs + arr[firstNonNegative];
            int currVal = val + cs;
            if (currVal > val)
                val = currVal;
            firstNonNegative--;

        }
        System.out.println(val);

    }
}
