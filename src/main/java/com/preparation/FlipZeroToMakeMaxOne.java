package com.preparation;

public class FlipZeroToMakeMaxOne {

    public static int maxContinuousOneLength(int[] binaryArray, int k) {

        int l = 0, r = 0;

        int countZero = 0;
        int maxLength = Integer.MIN_VALUE;

        while (r < binaryArray.length) {

            if (countZero <= k) {
                if (binaryArray[r] == 0)
                    countZero++;
                r++;
            }

            if (countZero > k) {
                if (binaryArray[l] == 0)
                    countZero--;
                l++;
            }

            if (countZero <= k && (r - l) > maxLength) {
                maxLength = r - l;
            }

        }

        return maxLength;

    }


    public static void main(String[] args) {

        int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        System.out.println(maxContinuousOneLength(arr, 2));

    }


}
