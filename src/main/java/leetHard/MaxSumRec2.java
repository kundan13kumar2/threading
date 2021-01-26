package leetHard;

public class MaxSumRec2 {
    static class Pair {
        int first;
        int second;
        int sum;

        Pair(int first, int second, int sum) {
            this.first = first;
            this.second = second;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    static Pair findPair(int[] arr) {

        int i = 0;
        while (arr[i] < 0)
            i++;
        int curr = arr[i];
        int max = curr;
        int start = i;
        int end = i;
        int s = i;
        i++;

        for (; i < arr.length; i++) {
            curr += arr[i];
            if (curr < 0) {
                curr = 0;
                s = i + 1;
            } else if (curr > max) {
                max = curr;
                start = s;
                end = i;
            }
        }
        return new Pair(start, end, max);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}};
        int r = 4;
        int c = 5;


        int maxSum = Integer.MIN_VALUE;
        Pair startPoint = new Pair(-1, -1, 0);
        Pair endPoint = new Pair(-1, -1, 0);


        //O(n^3)
        for (int i = 0; i < c; i++) {

            int[] temp = new int[arr.length];
            for (int k = 0; k < r; k++)
                temp[k] = arr[k][i];
            Pair pair = findPair(temp);
            if (pair.sum > maxSum) {
                maxSum = pair.sum;
                startPoint = new Pair(pair.first, i, maxSum);
                endPoint = new Pair(pair.second, i, maxSum);
            }
            for (int j = i + 1; j < c; j++) {
                for (int t = 0; t < r; t++)
                    temp[t] += arr[t][j];
                Pair currPair = findPair(temp);
                if (currPair.sum > maxSum) {
                    maxSum = currPair.sum;
                    startPoint = new Pair(currPair.first, i, maxSum);
                    endPoint = new Pair(currPair.second, j, maxSum);
                }
            }
        }


        System.out.println(maxSum);
        System.out.println("StartPoint: " + startPoint);
        System.out.println("EndPoint :" + endPoint);
    }
}
