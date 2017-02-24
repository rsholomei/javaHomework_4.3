package com.geekhub.model;

public class Car {
    private Long id;
    private int wheel_id;
    private int engine_id;

    public Car(int wheel, int engine){
        this.wheel_id = wheel;
        this.engine_id = engine;
    }

    public Car(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWheel() {
        return wheel_id;
    }

    public void setWheel(int wheel) {
        this.wheel_id = wheel;
    }

    public int getEngine() {
        return engine_id;
    }

    public void setEngine(int engine) {
        this.engine_id = engine;
    }
}
