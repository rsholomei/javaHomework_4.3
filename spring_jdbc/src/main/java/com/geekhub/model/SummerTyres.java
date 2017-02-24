package com.geekhub.model;

public class SummerTyres extends Tyres{

    public SummerTyres(int size, String name){
        super(size, name);
    }

    @Override
    public String toString() {
        return String.format("Summer tyres:\n" + "Tyres size = " + getSize() + ", Tyres name = " + getName());
    }
}
