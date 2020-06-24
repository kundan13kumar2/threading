/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kundan Kumar
 * @version $Id: NestedArrayWeight.java, v 0.1 2020-06-24 8:52 AM Kundan Kumar Exp $$
 */
public class NestedArrayWeight {

    public static void main(String[] args) {
        List<Object> parent1 = new ArrayList<>();

        List<Object> child1 = new ArrayList<>();
        child1.add(1);
        child1.add(1);

        parent1.add(child1);
        parent1.add(2);

        List<Object> child3 = new ArrayList<>();
        child3.add(1);
        child3.add(1);

        parent1.add(child3);
        System.out.println(recur(parent1, 1));

    }

    public static int recur(Object list, int depth) {
        if (list == null)
            return 0;

        int sum = 0;
        if (list.getClass() == ArrayList.class) {
            for (Object obj : (ArrayList<Object>) list) {
                if (obj.getClass() == ArrayList.class)
                    sum += recur(obj, depth + 1);
                else
                    sum += recur(obj, depth);
            }
        } else {
            sum += (Integer) list * depth;
        }
      //  System.out.println(sum);
        return sum;
    }

}