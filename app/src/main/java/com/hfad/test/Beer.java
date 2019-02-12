package com.hfad.test;

import java.util.ArrayList;
import java.util.List;

public class Beer {
    public String name, cvet, strana, krepost;

    public Beer(String cvet, String strana, String krepost, String name) {
        this.cvet = cvet;
        this.strana = strana;
        this.name = name;
        this.krepost = krepost;
    }

    @Override
    public String toString() {
        return cvet + strana + krepost + name;
    }


}






