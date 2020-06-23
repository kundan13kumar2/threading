/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.doctorsAppointment;

import org.springframework.util.Assert;

import java.util.*;

/**
 * @author Kundan Kumar
 * @version $Id: Doctor.java, v 0.1 2020-05-23 6:32 AM Kundan Kumar Exp $$
 */
public class Runner {
    static int currentTime = 0;


    List<Patient> appointment = Collections.synchronizedList(new ArrayList<>());

    PriorityQueue<Patient> walkin = new PriorityQueue<>(new Comparator<Patient>() {
        @Override
        public int compare(Patient o1, Patient o2) {
            return o1.time - o2.time;
        }
    });
    PriorityQueue<Patient> emergency = new PriorityQueue<>(new Comparator<Patient>() {
        @Override
        public int compare(Patient o1, Patient o2) {
            return o1.time - o2.time;
        }
    });

    public int startTime = 1000;
    public int endTime = 1300;
    Set<Integer> intervals = new HashSet<>();

    public int getAddedVal(int time) {

        Assert.isTrue(time >= startTime && endTime > time);
        int addedval = time % 10 < 5 ? 0 : 10;
        time = time / 10 * 10 + addedval;
        return time;
    }

    public void getAppointment(int id, int time) {

        time = getAddedVal(time);

        while (time < endTime) {
            if (intervals.contains(time))
                time += 5;
            else {
                intervals.add(time);
                break;
            }
        }
        appointment.add(new Patient(id, time));
    }

    public void walkInPatient(int id, int time) {

        time = getAddedVal(time);
        walkin.add(new Patient(id, time));

    }

    public void emergencyPatient(int id, int time) {

        time = getAddedVal(time);
        emergency.add(new Patient(id, time));
        for (int i = 0; i < appointment.size(); i++) {
            Patient pt = appointment.get(i);
            pt.time = pt.time + 5;
            appointment.set(i, pt);
        }
        Collections.sort(appointment, new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                return o1.time - o2.time;
            }
        });
    }

    public void updateWalkinPriority() {

        while (!walkin.isEmpty() && (currentTime - walkin.peek().time > 45)) {
            Patient lastEmergencyPatient = new Patient(-1, getAddedVal(currentTime));
            if (emergency.size() > 0)
                lastEmergencyPatient = (Patient) emergency.toArray()[emergency.size() - 1];
            Patient walkPatient = walkin.poll();
            assert walkPatient != null;
            emergency.add(new Patient(walkPatient.id, lastEmergencyPatient.time + 5));
            for (int i = 0; i < appointment.size(); i++) {
                Patient pt = appointment.get(i);
                pt.time = pt.time + 5;
                appointment.set(i, pt);
            }
            Collections.sort(appointment, new Comparator<Patient>() {
                @Override
                public int compare(Patient o1, Patient o2) {
                    return o1.time - o2.time;
                }
            });
        }
    }

    public Patient getNextPatient() {
        if (!emergency.isEmpty())
            return emergency.poll();
        else if (!appointment.isEmpty()) {
            Patient pt=appointment.get(0);
            appointment.remove(0);
            return pt;
        }
        else if (!walkin.isEmpty())
            return walkin.poll();
        else return null;
    }

    public static void main(String[] args) {

        Runner runner = new Runner();
        runner.getAppointment(1, 1012);
        runner.getAppointment(2, 1040);
        runner.getAppointment(3, 1223);
        runner.getAppointment(4, 1112);
        runner.getAppointment(5, 1118);
        runner.getAppointment(6, 1240);

        Patient pt = null;
        runner.updateWalkinPriority();
        pt = runner.getNextPatient();
        System.out.println(pt.id + " : " + pt.time);
        System.out.println("App : " + Arrays.toString(runner.appointment.toArray()));
        System.out.println("walk : " + Arrays.toString(runner.walkin.toArray()));
        System.out.println("emer : " + Arrays.toString(runner.emergency.toArray()));


        currentTime = 1032;
        runner.emergencyPatient(7, currentTime);
        runner.updateWalkinPriority();
        pt = runner.getNextPatient();
        System.out.println(pt.id + " : " + pt.time);
        System.out.println("App : " + Arrays.toString(runner.appointment.toArray()));
        System.out.println("walk : " + Arrays.toString(runner.walkin.toArray()));
        System.out.println("emer : " + Arrays.toString(runner.emergency.toArray()));


        currentTime = 1052;
        runner.walkInPatient(8, currentTime);
        runner.updateWalkinPriority();
        pt = runner.getNextPatient();
        System.out.println(pt.id + " : " + pt.time);
        System.out.println("App : " + Arrays.toString(runner.appointment.toArray()));
        System.out.println("walk : " + Arrays.toString(runner.walkin.toArray()));
        System.out.println("emer : " + Arrays.toString(runner.emergency.toArray()));


        currentTime = 1132;
        runner.walkInPatient(9, currentTime);
        runner.updateWalkinPriority();
        pt = runner.getNextPatient();
        System.out.println(pt.id + " : " + pt.time);
        System.out.println("App : " + Arrays.toString(runner.appointment.toArray()));
        System.out.println("walk : " + Arrays.toString(runner.walkin.toArray()));
        System.out.println("emer : " + Arrays.toString(runner.emergency.toArray()));


        currentTime = 1212;
        runner.walkInPatient(10, currentTime);
        runner.updateWalkinPriority();
        pt = runner.getNextPatient();
        System.out.println(pt.id + " : " + pt.time);
        System.out.println("App : " + Arrays.toString(runner.appointment.toArray()));
        System.out.println("walk : " + Arrays.toString(runner.walkin.toArray()));
        System.out.println("emer : " + Arrays.toString(runner.emergency.toArray()));

        currentTime = 1222;
        runner.walkInPatient(11, currentTime);
        runner.updateWalkinPriority();
        pt = runner.getNextPatient();
        System.out.println(pt.id + " : " + pt.time);
        System.out.println("App : " + Arrays.toString(runner.appointment.toArray()));
        System.out.println("walk : " + Arrays.toString(runner.walkin.toArray()));
        System.out.println("emer : " + Arrays.toString(runner.emergency.toArray()));

        currentTime = 1242;
        runner.emergencyPatient(12, currentTime);
        runner.updateWalkinPriority();
        pt = runner.getNextPatient();
        System.out.println(pt.id + " : " + pt.time);
        System.out.println("App : " + Arrays.toString(runner.appointment.toArray()));
        System.out.println("walk : " + Arrays.toString(runner.walkin.toArray()));
        System.out.println("emer : " + Arrays.toString(runner.emergency.toArray()));

    }

}