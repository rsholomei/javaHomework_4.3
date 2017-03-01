package com.geekhub.dao;

import com.geekhub.model.Tyres;

import java.util.List;

public interface TyresDao {
    void saveSummerTyres(Tyres tyres);
    void updateSummerTyres(Tyres tyres);
    void deleteSummerTyres(int tyresId);
    Tyres findSummerTyresById(int tyresId);
    List<Tyres> getAllSummerTyres();
}
