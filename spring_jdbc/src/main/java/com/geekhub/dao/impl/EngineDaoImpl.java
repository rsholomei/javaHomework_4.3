package com.geekhub.dao.impl;

import com.geekhub.dao.EngineDao;
import com.geekhub.dao.mapper.EngineMapper;
import com.geekhub.model.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

public class EngineDaoImpl extends JdbcDaoSupport implements EngineDao{
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void saveEngine(Engine engine) {
        this.getJdbcTemplate().update
                ("INSERT INTO Engine (EngineСapacity) VALUES(?)",
                        new Object[] { engine.getEngineСapacity() });
    }

    public void updateEngine(Engine engine) {

    }

    public void deleteEngine(int engineId) {

    }

    public Engine findEngineById(int engineId) {
        return  this.getJdbcTemplate().queryForObject("select * from Engine where Engine_ID = ?",
                new Object[]{engineId}, new EngineMapper());
    }

    public List<Engine> getAllEngine() {
        return this.getJdbcTemplate().query("select * from Engine",
                new EngineMapper());
    }
}
