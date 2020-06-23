/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.doctorsAppointment;

/**
 * @author Kundan Kumar
 * @version $Id: Patient.java, v 0.1 2020-05-23 6:32 AM Kundan Kumar Exp $$
 */
public class Patient {
    public int id;
    public int time;

    public Patient(int id, int time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }
}