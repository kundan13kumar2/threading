package com.micro;

public class GPNth3Dec {
    public static void main(String[] args) {
        int second = 3;
        int third = 8;
        float r = (float) third / second;
        float first = (float) 3 / r;

        float fifthTerm = first*(float) Math.pow(r, 4);

        char[] chars = String.valueOf(fifthTerm).toCharArray();
        char[] res = new char[chars.length];
        int k = 0;
        int i = 0;
        boolean flag = false;
        while (k < 3 && i < chars.length) {
            if (flag) {
                k++;
            }
            if (chars[i] == '.')
                flag = true;

            res[i] = chars[i];
            i++;
        }
        if (chars[i] > '5')
            res[i - 1] += 1;
        System.out.println(String.valueOf(res));

    }
}
