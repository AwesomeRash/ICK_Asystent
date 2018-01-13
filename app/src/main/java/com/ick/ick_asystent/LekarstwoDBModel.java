package com.ick.ick_asystent;

/**
 * Created by Roderick on 13.01.2018.
 */

public class LekarstwoDBModel {
    Integer id;
    String nazwa;
    String skl_aktywny;
    String opakowanie;
    double cena;

    public LekarstwoDBModel(Integer id, String nazwa, String skl_aktywny, String opakowanie, double cena){
        this.id = id;
        this.nazwa = nazwa;
        this.skl_aktywny = skl_aktywny;
        this.opakowanie = opakowanie;
        this.cena = cena;
    }
}
