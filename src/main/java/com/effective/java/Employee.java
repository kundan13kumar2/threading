/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.effective.java;

/**
 * @author Kundan Kumar
 * @version $Id: CloneTest.java, v 0.1 2020-04-16 4:53 PM Kundan Kumar Exp $$
 */
public class Employee implements Cloneable {

    private int empoyeeId;
    private String employeeName;
    private Department department;

    public int getEmpoyeeId() {
        return empoyeeId;
    }

    public void setEmpoyeeId(int empoyeeId) {
        this.empoyeeId = empoyeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(int id, String name, Department dept) {
        this.empoyeeId = id;
        this.employeeName = name;
        this.department = dept;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee employeeCloned = (Employee) super.clone();
        employeeCloned.setDepartment((Department) employeeCloned.getDepartment().clone());
        return employeeCloned;
    }

}