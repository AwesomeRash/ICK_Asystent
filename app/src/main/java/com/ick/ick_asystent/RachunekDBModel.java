package com.ick.ick_asystent;

/**
 * Created by Roderick on 05.01.2018.
 */

public class RachunekDBModel {
    Integer id;
    String nazwa;
    String ostatnioOplacony;
    Integer jakCzesto;
    Integer rachunek1;
    Integer rachunek2;
    Integer rachunek3;

    public RachunekDBModel(){

    }

    public RachunekDBModel(Integer id, String nazwa,String ostatnioOplacony, Integer jakCzesto, Integer rachunek1, Integer rachunek2, Integer rachunek3){
        this.id = id;
        this.nazwa = nazwa;
        this.ostatnioOplacony = ostatnioOplacony;
        this.jakCzesto = jakCzesto;
        this.rachunek1 = rachunek1;
        this.rachunek2 = rachunek2;
        this.rachunek3 = rachunek3;
    }
}
