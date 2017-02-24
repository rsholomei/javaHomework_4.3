package com.geekhub.dao.impl;

import com.geekhub.dao.CarDao;
import com.geekhub.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Service
public class CarDaoImpl extends JdbcDaoSupport implements CarDao{
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void saveCar(Car car) {
        this.getJdbcTemplate().update
                ("INSERT INTO Car (Wheels_ID, Engine_ID) VALUES(?,?)",
                        new Object[] { car.getWheel(), car.getEngine() });
    }

    public void updateCar(Car car) {

    }

    public void deleteCar(int carId) {

    }

    public Car findCarById(int carId) {
        return null;
    }

    public List<Car> getAllCar() {
        return this.getJdbcTemplate().query("select * from Car",
                new CarMapper());
    }
}
