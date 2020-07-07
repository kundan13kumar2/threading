/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.observer;

/**
 * @author Kundan Kumar
 * @version $Id: Transport.java, v 0.1 2020-07-01 4:00 PM Kundan Kumar Exp $$
 */
class TypeException extends RuntimeException {
    @Override
    public String toString() {
        return "Vehicle Type Not Set";
    }
}

class Vehicles {
    String type, model_no, model_name, owner_name, owner_details;

    public Vehicles() {
    }

    public Vehicles( String model_no, String model_name, String owner_name, String owner_details) {
        this.model_no = model_no;
        this.model_name = model_name;
        this.owner_name = owner_name;
        this.owner_details = owner_details;
    }

    public String get_type() {
        return type;
    }

    public String retrieve() {
        return null;
    }
}

class Car extends Vehicles {

    public Car() {
    }

    public Car( String model_no, String model_name, String owner_name, String owner_details) {
        super( model_no, model_name, owner_name, owner_details);
    }

    public String get_type() {
        return type;
    }

    public void set_type(String type) {
        super.type = type;
    }

    @Override
    public String retrieve() {
        if (get_type() == null)
            throw new TypeException();
        else return model_no + model_name + owner_details + owner_name;
    }
}