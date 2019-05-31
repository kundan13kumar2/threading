package com.basics;

public class ExceptionTest {

    public static int test(){

        int a=0;

        try{

            a=5;
            return a;
        }
        catch (Exception e)
        {

        }
        finally {
            a=10;
           // return 10;
        }
        return a;
    }

    public static void main(String[] args) {

        System.out.println(test());

    }
}
