package com.aygui.astrologyhelper.service.impl;

import com.aygui.astrologyhelper.dao.PeopleDao;
import com.aygui.astrologyhelper.dao.impl.PeopleDaoImpl;
import com.aygui.astrologyhelper.model.Person;
import com.aygui.astrologyhelper.service.PeopleService;

/**
 * Created by aschworer on 02-Nov-15.
 */
public class PeopleServiceImpl implements PeopleService {

    private PeopleDao peopleDao = new PeopleDaoImpl();

    @Override
    public void add(String name, String dob, String city, String sex) throws Exception {
        Person person = new Person();
        person.setName(name);
        person.setSex(sex);
        person.setDob(dob);
        person.setLocation(city);
        peopleDao.add(person);
    }
}
