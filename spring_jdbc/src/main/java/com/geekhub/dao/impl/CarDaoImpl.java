package com.geekhub.dao.impl;

import com.geekhub.dao.CarDao;
import com.geekhub.dao.mapper.CarMapper;
import com.geekhub.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public void saveCar(Car car) {
        this.getJdbcTemplate().update
                ("INSERT INTO Car (NameCar, Wheels_ID, Engine_ID) VALUES(?,?,?)",
                        new Object[] { car.getNameCar(), car.getWheelId(), car.getEngineId() });
    }

    @Override
    @Transactional
    public void updateCar(int carId, int wheelsId, int engineId) {
        this.getJdbcTemplate().update("update Car set Wheels_ID = ?, Engine_ID = ? where Car_ID = ?",
                wheelsId, engineId, carId);
    }

    @Override
    public void deleteCarById(int carId) {
        this.getJdbcTemplate().update("delete from Car where Car_ID = ?",
                carId);

    }

    @Override
    public Car findCarById(int carId) {
        return this.getJdbcTemplate().queryForObject("select * from Car where Car_ID = ?",
                new Object[]{carId}, new CarMapper());
    }

    @Override
    public List<Car> getAllCar() {
        return this.getJdbcTemplate().query("select * from Car",
                new CarMapper());
    }
}
