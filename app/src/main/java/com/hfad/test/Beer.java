package com.hfad.test;
import java.util.ArrayList;
import java.util.List;


public class Beer {




    public String name;
    public String cvet;
    public int num;
    public Beer (String name, String cvet, int num) {
        this.cvet = cvet;
        this.name = name;
        this.num = num;
    }

    public Beer (String cvet) {
        this.cvet = cvet;
    }

    @Override
    public String toString () {
        return name +" "+cvet;
    }



    }






