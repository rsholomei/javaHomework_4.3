package com.geekhub.dao.impl;

import com.geekhub.dao.WheelsDao;
import com.geekhub.dao.mapper.WheelsMapper;
import com.geekhub.model.Wheels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Service
public class WheelsDaoImpl extends JdbcDaoSupport implements WheelsDao{
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void saveWheels(Wheels wheels) {
        this.getJdbcTemplate().update
                ("INSERT INTO Wheels (Tyres_ID) VALUES(?)",
                        new Object[] { wheels.getTyres() });
    }

    public void updateWheels(Wheels wheel) {

    }

    public void deleteWheels(int wheelsId) {

    }

    public Wheels findWheelsById(int wheelsId) {
        return null;
    }

    public List<Wheels> getAllWheels() {
        return this.getJdbcTemplate().query("select * from Wheels",
                new WheelsMapper());
    }
}
