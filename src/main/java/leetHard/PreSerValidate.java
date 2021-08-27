package leetHard;

import java.util.Stack;

public class PreSerValidate {
    public static boolean check(String preorder) {
        if (preorder.equalsIgnoreCase("#"))
            return true;

        Stack<String> st = new Stack<>();
        String[] arr = preorder.split(",");
        st.push(arr[0]);
        int i = 1;
        int counter = 0;
        while (!st.isEmpty() && i < arr.length) {
            String str = arr[i++];
            boolean flag = false;
            if (!str.equalsIgnoreCase("#")) {
                while (!st.isEmpty() && st.peek().equalsIgnoreCase("#")) {
                    st.pop();
                    flag = true;
                }
                if (!st.isEmpty() && flag) {
                    st.pop();
                    counter++;
                    if (counter == 2 && !st.isEmpty()) {
                        st.pop();
                        counter = 0;
                    }
                }
            }
            st.push(str);
        }
        int p = 0;
        while (!st.isEmpty() && st.peek().equalsIgnoreCase("#")) {
            st.pop();
            p++;
        }
        if (p == 2 && st.size() == 1)
            return true;
        if (st.size() == 0) return false;
        st.pop();
        counter++;
        return st.size() == 1 && counter == 2;
    }


    public static boolean isValidSerialization(String preorder) {
        int count = 1;
        String[] str = preorder.split(",");
        for (String st : str) {
            if (st.equalsIgnoreCase("#"))
                count--;
            else {
                count = count - 1;
                if (count < 0)
                    return false;
                count += 2;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        //String str = "4,3,#,1,#,6,#,#,2,#,6,#,#,9,#,8,#,8,#,#";
        //String str = "#";
        System.out.println(isValidSerialization(str));
    }
}
