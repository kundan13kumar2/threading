/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.effective.java;

/**
 * @author Kundan Kumar
 * @version $Id: Department.java, v 0.1 2020-04-16 5:35 PM Kundan Kumar Exp $$
 */
public class Department implements Cloneable{

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.id==((Department)obj).id && this.name.equals(((Department)obj).name))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return id+getAscii(name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public int getAscii(String str){
        int sum=0;
        for(int i=0; i<str.length(); i++)
        {
            int asciiValue = str.charAt(i);
            sum = sum+ asciiValue;
        }
        return sum;
    }
}