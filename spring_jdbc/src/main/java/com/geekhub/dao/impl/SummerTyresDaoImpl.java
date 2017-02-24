package com.geekhub.dao.impl;

import com.geekhub.dao.SummerTyresDao;
import com.geekhub.model.Car;
import com.geekhub.model.SummerTyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

public class SummerTyresDaoImpl extends JdbcDaoSupport implements SummerTyresDao{
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void saveSummerTyres(SummerTyres summerTyres) {
        this.getJdbcTemplate().update
                ("INSERT INTO SummerTyres (SizeTyres, NameTyres) VALUES(?,?)",
                        new Object[] { summerTyres.getSize(), summerTyres.getName() });
    }

    public void updateSummerTyres(SummerTyres summerTyres) {

    }

    public void deleteSummerTyres(int summerTyresId) {

    }

    public SummerTyres findSummerTyresById(int summerTyresId) {
        return null;
    }

    public List<SummerTyres> getAllSummerTyres() {
        return null;
    }
}
