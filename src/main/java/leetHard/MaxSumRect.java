package leetHard;

public class MaxSumRect {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}};
        int r = 4;
        int c = 5;


        //O(n^6)

        int maxSum = Integer.MIN_VALUE;
        Pair startPoint = new Pair(-1, -1);
        Pair endPoint = new Pair(-1, -1);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = i; k < r; k++) {
                    for (int l = j; l < c; l++) {
                        int currSum = 0;
                        for (int m = i; m <= k; m++) {
                            for (int n = j; n <= l; n++) {
                                currSum += arr[m][n];

                            }
                        }
                        if (currSum > maxSum) {
                            startPoint = new Pair(i, j);
                            endPoint = new Pair(k, l);
                            maxSum = currSum;

                        }
                    }
                }
            }
        }
        System.out.println(maxSum);
        System.out.println("StartPoint: " + startPoint);
        System.out.println("EndPoint :" + endPoint);
    }
}
