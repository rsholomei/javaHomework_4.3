package com.geekhub.dao.impl;

import com.geekhub.dao.WheelsDao;
import com.geekhub.model.Wheels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

public class WheelsDaoImpl extends JdbcDaoSupport implements WheelsDao{
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void saveWheelsWithSummerTyres(Wheels wheels) {
        this.getJdbcTemplate().update
                ("INSERT INTO Wheels (SummerTyres_ID) VALUES(?)",
                        new Object[] { wheels.getSummerTyres_id() });
    }

    public void saveWheelsWithWinterTyres(Wheels wheels) {
        this.getJdbcTemplate().update
                ("INSERT INTO Wheels (WinterTyres_ID) VALUES(?)",
                        new Object[] { wheels.getWinterTyres_id() });
    }

    public void updateWheels(Wheels wheel) {

    }

    public void deleteWheels(int wheelsId) {

    }

    public Wheels findWheelsById(int wheelsId) {
        return null;
    }

    public List<Wheels> getAllWheels() {
        return null;
    }
}
