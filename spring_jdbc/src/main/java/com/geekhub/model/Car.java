package com.geekhub.model;

public class Car {
    private Long id;
    private int wheels_Id;
    private int engine_Id;

    public Car(int wheels_Id, int engine_Id){
        this.wheels_Id = wheels_Id;
        this.engine_Id = engine_Id;
    }

    public Car(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWheelId() {
        return wheels_Id;
    }

    public void setWheelId(int wheels_Id) {
        this.wheels_Id = wheels_Id;
    }

    public int getEngineId() {
        return engine_Id;
    }

    public void setEngineId(int engine_Id) {
        this.engine_Id = engine_Id;
    }
}
