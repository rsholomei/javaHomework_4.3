package com.geekhub.dao.impl;

import com.geekhub.dao.WinterTyresDao;
import com.geekhub.model.SummerTyres;
import com.geekhub.model.WinterTyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

public class WinterTyresDaoImpl extends JdbcDaoSupport implements WinterTyresDao{
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void saveWinterTyres(WinterTyres winterTyres) {
        this.getJdbcTemplate().update
                ("INSERT INTO WinterTyres (SizeTyres, NameTyres) VALUES(?,?)",
                        new Object[] { winterTyres.getSize(), winterTyres.getName() });
    }

    public void updateWinterTyres(WinterTyres winterTyres) {

    }

    public void deleteWinterTyres(int winterTyresId) {

    }

    public WinterTyres findWinterTyresById(int winterTyresId) {
        return null;
    }

    public List<WinterTyres> getAllWinterTyres() {
        return null;
    }
}
