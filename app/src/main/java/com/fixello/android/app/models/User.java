package com.fixello.android.app.models;

/**
 * Created by knachiappan on 8/3/15.
 */
public class User {
    private String name;
    private Integer age;
    private String[] favourites;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getFavourites() {
        return favourites;
    }

    public void setFavourites(String[] favourites) {
        this.favourites = favourites;
    }

}
