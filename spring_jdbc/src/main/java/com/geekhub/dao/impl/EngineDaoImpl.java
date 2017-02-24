package com.geekhub.dao.impl;

import com.geekhub.dao.EngineDao;
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
        return null;
    }

    public List<Engine> getAllEngine() {
        return null;
    }
}
