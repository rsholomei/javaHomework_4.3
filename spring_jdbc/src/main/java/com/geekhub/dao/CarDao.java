package com.geekhub.dao;

import com.geekhub.model.Car;

import java.util.List;

public interface CarDao {
    void saveCar(Car car);
    void updateCar(Car car);
    void deleteCar(int carId);
    Car findCarById(int carId);
    List<Car> getAllCar();
}
