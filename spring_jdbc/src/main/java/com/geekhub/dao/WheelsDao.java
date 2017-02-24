package com.geekhub.dao;

import com.geekhub.model.Wheels;

import java.util.List;

public interface WheelsDao {
    void saveWheelsWithSummerTyres(Wheels wheel);
    void saveWheelsWithWinterTyres(Wheels wheels);
    void updateWheels(Wheels wheel);
    void deleteWheels(int wheelsId);
    Wheels findWheelsById(int wheelsId);
    List<Wheels> getAllWheels();
}
