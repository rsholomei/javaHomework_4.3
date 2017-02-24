package com.geekhub.model;

public class Tyres {
    private Long id;
    private int size;
    private String name;

    public Tyres(int size, String name){
        this.size = size;
        this.name = name;
    }

    public Tyres(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tyres size = " + size + ", Tyres name = " + name;
    }
}
