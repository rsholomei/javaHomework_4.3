package com.geekhub.dao.impl;

import com.geekhub.dao.TyresDao;
import com.geekhub.model.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

public class TyresDaoImpl extends JdbcDaoSupport implements TyresDao {
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void saveSummerTyres( Tyres tyres) {
        this.getJdbcTemplate().update
                ("INSERT INTO Tyres (SizeTyres, NameTyres) VALUES(?,?)",
                        new Object[] { tyres.getSize(), tyres.getName() });
    }

    public void updateSummerTyres(Tyres tyres) {

    }

    public void deleteSummerTyres(int summerTyresId) {

    }

    public Tyres findSummerTyresById(int tyresId) {
        return null;
    }

    public List<Tyres> getAllSummerTyres() {
        return null;
    }
}
