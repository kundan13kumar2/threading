package leetHard;

public class SumSQNum {

    public boolean judgeSquareSum(int c) {
        int p = (int) Math.sqrt(c);
        for (int i = p; i >= 0; i--) {
            int rem = c - (i * i);
            int t = (int) Math.sqrt(rem);
            if (rem == t * t)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
