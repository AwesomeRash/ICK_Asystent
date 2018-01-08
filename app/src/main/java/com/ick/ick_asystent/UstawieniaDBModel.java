package com.ick.ick_asystent;

/**
 * Created by kamil on 08.01.2018.
 */

public class UstawieniaDBModel {
    Integer id;
    String nazwa;
    String wartosc;

    public UstawieniaDBModel(Integer id, String name, String value){
        this.id = id;
        nazwa = name;
        wartosc = value;
    }
}
