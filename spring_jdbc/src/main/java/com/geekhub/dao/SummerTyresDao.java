package com.geekhub.dao;

import com.geekhub.model.SummerTyres;

import java.util.List;

public interface SummerTyresDao {
    void saveSummerTyres(SummerTyres summerTyres);
    void updateSummerTyres(SummerTyres summerTyres);
    void deleteSummerTyres(int summerTyresId);
    SummerTyres findSummerTyresById(int summerTyresId);
    List<SummerTyres> getAllSummerTyres();
}
