package com.geekhub.dao;

import com.geekhub.model.WinterTyres;

import java.util.List;

public interface WinterTyresDao {
    void saveWinterTyres(WinterTyres winterTyres);
    void updateWinterTyres(WinterTyres winterTyres);
    void deleteWinterTyres(int winterTyresId);
    WinterTyres findWinterTyresById(int winterTyresId);
    List<WinterTyres> getAllWinterTyres();
}
