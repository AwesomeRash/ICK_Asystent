package com.ick.ick_asystent;

/**
 * Created by Roderick on 06.01.2018.
 */

public class PosilekDBModel {
    Integer id;
    String nazwa;
    String godzina;
    Integer typ;


    public PosilekDBModel(Integer id, String name, Integer type, String time){
        this.id = id;
        nazwa = name;
        typ=type;
        godzina = time;
    }
}
