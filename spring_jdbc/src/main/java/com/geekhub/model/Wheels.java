package com.geekhub.model;

public class Wheels {
    private Long id;
    private Long summerTyres_id;
    private Long winterTyres_id;

    public Wheels(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSummerTyres_id() {
        return summerTyres_id;
    }

    public void setSummerTyres_id(Long summerTyres_id) {
        this.summerTyres_id = summerTyres_id;
    }

    public Long getWinterTyres_id() {
        return winterTyres_id;
    }

    public void setWinterTyres_id(Long winterTyres_id) {
        this.winterTyres_id = winterTyres_id;
    }
}
