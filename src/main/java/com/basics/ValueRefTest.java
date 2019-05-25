package com.basics;

import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.map.TObjectDoubleMap;
import gnu.trove.map.hash.TCustomHashMap;
import gnu.trove.map.hash.TObjectDoubleHashMap;

import java.util.HashMap;
import java.util.Map;

public class ValueRefTest {

    public static void increment(TestNumber a) {
        a.setAge(30);
    }

    public static void decrement(Integer num) {
        num--;
    }

    public static void main(String[] args) {

        final TDoubleArrayList doubles = new TDoubleArrayList();
        double x=3.6;

        Map<String,String> ff=new TCustomHashMap<String,String>();

        doubles.add(x);

        Map<String,Double> dd4=new HashMap<>();
        dd4.put("df",x);
        TObjectDoubleMap dd=new TObjectDoubleHashMap();
        dd.put("sdf",x);


        TestNumber testNumber = new TestNumber();
        testNumber.setAge(20);
        testNumber.setName("Kundan");

        System.out.println("In Main : \n" + testNumber);

        increment(testNumber);

        System.out.println("After : " + testNumber);

        Integer a = 10;

        System.out.println("Before : " + a);

        decrement(a);

        System.out.println(a);
    }
}
