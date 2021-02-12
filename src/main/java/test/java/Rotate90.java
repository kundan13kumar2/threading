package test.java;

import java.util.Arrays;
import java.util.List;

public class Rotate90 {
    public static void main(String[] args) {
        Integer arr[] = new Integer[]{-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35};
        List<Integer> list = Arrays.asList(arr);
        int i = 0;
        int j = list.size() - 1;
        int maxSum = 0;
        int B = 48;
        StringBuilder sb=new StringBuilder();
        while (B >= 0 && i <= j) {
            System.out.println(list.get(i) + " " + list.get(j));
            if (list.get(i) >= list.get(j)) {
                sb.append(maxSum+"+");
                maxSum += list.get(i);
                i++;
            } else {
                sb.append(maxSum+"+");
                maxSum += list.get(j);
                j--;
            }
            B--;
        }
        System.out.println(maxSum);
        System.out.println(sb);
    }
}
