package com.geekhub.dao.impl;

import com.geekhub.model.Car;
import com.geekhub.model.Engine;
import com.geekhub.model.Wheels;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Map<Long, Map<List<Wheels>, List<Engine>>> map = new HashMap<>();

        Car car = new Car();
        car.setId(rs.getLong("Car_ID"));
        car.setWheel(rs.getInt("Wheels_ID"));
        car.setEngine(rs.getInt("Engine_ID"));
        return car;
    }
}
