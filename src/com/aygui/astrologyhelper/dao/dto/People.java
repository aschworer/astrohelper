package com.aygui.astrologyhelper.dao.dto;

import com.aygui.astrologyhelper.model.Person;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aschworer on 01-Nov-15.
 */
public class People {

    @SerializedName("people")
    List<Person> people = new ArrayList<>();

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
