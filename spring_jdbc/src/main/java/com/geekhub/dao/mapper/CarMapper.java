package com.geekhub.dao.mapper;

import com.geekhub.model.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getLong("Car_ID"));
        car.setWheelId(rs.getInt("Wheels_ID"));
        car.setEngineId(rs.getInt("Engine_ID"));
        return car;
    }
}
