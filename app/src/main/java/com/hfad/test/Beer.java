package com.hfad.test;

import java.util.ArrayList;

public class Beer {
    private String name, cvet, strana, krepost;

    private Beer(String cvet, String strana, String krepost, String name) {
        this.cvet = cvet;
        this.strana = strana;
        this.name = name;
        this.krepost = krepost;
    }

    @Override
    public String toString() {
        return cvet + strana + krepost + name;
    }

    public static final Beer [] beers = {
        new Beer("Светлое", "Россия", "Среднее", "Жигулёвское"),
        new Beer("Светлое", "Россия", "Среднее", "Донская пена"),
        new Beer("Светлое", "Россия", "Крепкое", "Балтика 9"),
        new Beer("Тёмное", "Швеция", "Среднее", "Sveden Beer"),
        new Beer("Светлое", "Германия", "Лёгкое", "German beer"),
        new Beer("Янтарное", "Россия", "Среднее", "Ярпиво"),
        new Beer("Светлое", "Россия", "Безалкогольное", "Балтика 0"),
        new Beer("Светлое", "Россия", "Лёгкое", "Русское лёгкое пиво"),
        new Beer("Светлое", "Россия", "Лёгкое", "Классное лёгкое пиво"),
        new Beer("Тёмное", "Россия", "Лёгкое", "Тёмное лёгкое пиво"),
    };

    /*public static ArrayList<Beer> getAllBeers () {
        ArrayList <Beer> beers1 = new ArrayList<>();
        beers1.add(new Beer("Светлое", "Россия", "Среднее", "Жигулёвское"));
        beers1.add(new Beer("Светлое", "Россия", "Среднее", "Донская пена"));
        beers1.add(new Beer("Светлое", "Россия", "Крепкое", "Балтика 9"));
        beers1.add(new Beer("Тёмное", "Швеция", "Среднее", "Sveden Beer"));
        beers1.add(new Beer("Светлое", "Германия", "Лёгкое", "German beer"));
        beers1.add(new Beer("Янтарное", "Россия", "Среднее", "Ярпиво"));
        beers1.add(new Beer("Светлое", "Россия", "Безалкогольное", "Балтика 0"));
        beers1.add(new Beer("Светлое", "Россия", "Лёгкое", "Русское лёгкое пиво"));
        beers1.add(new Beer("Светлое", "Россия", "Лёгкое", "Классное лёгкое пиво"));
        beers1.add(new Beer("Тёмное", "Россия", "Лёгкое", "Тёмное лёгкое пиво"));

        return beers1;
    }*/




    public String getName () {
        return name;
    }
    public String getCvet () {
        return cvet;
    }
    public String getStrana () {
        return strana;
    }
    public String getKrepost () {
        return krepost;
    }



}






