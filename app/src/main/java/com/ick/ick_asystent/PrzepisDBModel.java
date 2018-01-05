package com.ick.ick_asystent;

/**
 * Created by Roderick on 05.01.2018.
 */

public class PrzepisDBModel {
    int id;
    String nazwa;
    String trudnosc;
    String czas;
    String składniki;
    String przepis;
    int obraz;

    public PrzepisDBModel(){

    }

    public PrzepisDBModel(int id, String nazwa, String trudnosc, String czas, String skladniki, String przepis, int obraz){
        this.id = id;
        this.nazwa= nazwa;
        this.trudnosc = trudnosc;
        this.czas = czas;
        this.składniki = skladniki;
        this.przepis = przepis;
        this.obraz = obraz;
    }
}
