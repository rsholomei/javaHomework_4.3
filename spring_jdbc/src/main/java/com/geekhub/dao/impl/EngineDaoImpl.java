package com.geekhub.dao.impl;

import com.geekhub.dao.EngineDao;
import com.geekhub.dao.mapper.EngineMapper;
import com.geekhub.model.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Service
public class EngineDaoImpl extends JdbcDaoSupport implements EngineDao{
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    @Transactional
    public void saveEngine(Engine engine) {
        this.getJdbcTemplate().update
                ("INSERT INTO Engine (EngineСapacity) VALUES(?)",
                        new Object[] { engine.getEngineСapacity() });
    }

    @Override
    @Transactional
    public void updateEngineById(int engineId, Engine engine) {
        this.getJdbcTemplate().update("update Engine set EngineСapacity = ? where Engine_ID = ?",
                engine.getEngineСapacity(), engineId);

    }

    @Override
    public void deleteEngine(int engineId) {
        this.getJdbcTemplate().update("delete from Engine where Engine_ID = ?",
                engineId);
    }

    @Override
    public Engine findEngineById(int engineId) {
        return  this.getJdbcTemplate().queryForObject("select * from Engine where Engine_ID = ?",
                new Object[]{engineId}, new EngineMapper());
    }

    @Override
    public List<Engine> getAllEngine() {
        return this.getJdbcTemplate().query("select * from Engine",
                new EngineMapper());
    }
}
