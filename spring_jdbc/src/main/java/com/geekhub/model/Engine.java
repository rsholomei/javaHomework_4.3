package com.geekhub.model;

public class Engine {
    private Long id;
    private double engineСapacity;

    public Engine(double engineСapacity){
        this.engineСapacity = engineСapacity;
    }

    public Engine(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getEngineСapacity() {
        return engineСapacity;
    }

    public void setEngineСapacity(double engineСapacity) {
        this.engineСapacity = engineСapacity;
    }

    @Override
    public String toString() {
        return "EngineCapacity: " + engineСapacity;
    }
}
