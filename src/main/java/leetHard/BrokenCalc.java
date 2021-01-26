package leetHard;

public class BrokenCalc {


    static int count(int x, int y) {
        int res = 0;
        while (y > x) {
            if (y % 2 == 0)
                y /= 2;
            else
                y++;
            res++;
        }
        return res + (x - y);
    }

    public static void main(String[] args) {
        System.out.println(count(1024, 1));
    }
}
