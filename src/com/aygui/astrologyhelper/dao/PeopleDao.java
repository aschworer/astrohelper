package com.aygui.astrologyhelper.dao;

import com.aygui.astrologyhelper.model.Person;

import java.util.List;

/**
 * Created by aschworer on 02-Nov-15.
 */
public interface PeopleDao {

    public List<Person> getPeople() throws Exception;

    void add(Person person) throws Exception;

}
