package com.geekhub.dao.impl;

import com.geekhub.dao.CarDao;
import com.geekhub.dao.mapper.CarMapper;
import com.geekhub.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Service
public class CarDaoImpl implements CarDao{

    private JdbcTemplate jdbcTemplate;

    private TransactionTemplate transactionTemplate;

    @Autowired
    public void setTransactionTemplate(PlatformTransactionManager transactionManager){
        Assert.notNull(transactionManager, "The 'transactionManager' argument must not be null.");
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveCar(Car car) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    jdbcTemplate.update
                            ("INSERT INTO Car (NameCar, Wheels_ID, Engine_ID) VALUES(?,?,?)",
                                    new Object[] { car.getNameCar(), car.getWheelId(), car.getEngineId() });
                }catch (Exception e){
                    e.printStackTrace();
                    status.setRollbackOnly();
                }
            }
        });
    }

    @Override
    public void updateCar(int carId, int wheelsId, int engineId) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    jdbcTemplate.update("update Car set Wheels_ID = ?, Engine_ID = ? where Car_ID = ?",
                            wheelsId, engineId, carId);
                }catch (Exception e){
                    e.printStackTrace();
                    status.setRollbackOnly();
                }
            }
        });
    }

    @Override
    public void deleteCarById(int carId) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    jdbcTemplate.update("delete from Car where Car_ID = ?",
                            carId);
                }catch (Exception e){
                    e.printStackTrace();
                    status.setRollbackOnly();
                }
            }
        });
    }

    @Override
    public Car findCarById(int carId) {
        return jdbcTemplate.queryForObject("select * from Car where Car_ID = ?",
                new Object[]{carId}, new CarMapper());
    }

    @Override
    public List<Car> getAllCar() {
        return jdbcTemplate.query("select * from Car",
                new CarMapper());
    }
}
