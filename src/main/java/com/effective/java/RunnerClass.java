/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.effective.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kundan Kumar
 * @version $Id: RunnerClass.java, v 0.1 2020-04-16 4:55 PM Kundan Kumar Exp $$
 */
public class RunnerClass {

    public static void main(String[] args) throws CloneNotSupportedException {
        /*Department dept = new Department(1, "Human Resource");
        Employee original = new Employee(1, "Admin", dept);

        
        //Lets create a clone of original object
        Employee cloned = (Employee) original.clone();
        //Let verify using employee id, if cloning actually workded
        System.out.println(cloned.getEmpoyeeId());

        System.out.println(original != cloned);

        System.out.println(original.getClass() == cloned.getClass());

        System.out.println(original.equals(cloned));

        cloned.getDepartment().setName("Finance");

        System.out.println(original.getDepartment().getName());
        System.out.println(cloned.getDepartment().getName());
        */
        
        
        Map<Department,String> deptMap=new HashMap<>();
        Department dept1=new Department(1,"K");
        Department dept2=new Department(2,"L");
        Department dept3=new Department(1,"K");
        
        deptMap.put(dept1,"1");
        deptMap.put(dept2,"2");
        deptMap.put(dept3,"1");

        System.out.println(deptMap.size());

    }
}