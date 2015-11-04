package com.aygui.astrologyhelper.dao.impl;

import com.aygui.astrologyhelper.dao.PeopleDao;
import com.aygui.astrologyhelper.dao.dto.People;
import com.aygui.astrologyhelper.model.Person;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aschworer on 02-Nov-15.
 */
public class PeopleDaoImpl implements PeopleDao {

    public List<Person> getPeople() throws Exception {
        InputStream in = getClass().getClassLoader().getResourceAsStream("people.json");
        final InputStreamReader reader = new InputStreamReader(in);
        final Gson gson = new Gson();
        final People clothes = gson.fromJson(reader, People.class);
        return (clothes.getPeople() == null) ? new ArrayList() : clothes.getPeople();
    }

    @Override
    public void add(Person person) throws Exception {
        List<Person> fulllist = getPeople();
        String filename = "src/people.json";
        Gson gson = new Gson();
        if (fulllist == null) fulllist = new ArrayList<>();
        fulllist.add(person);
        People people = new People();
        people.setPeople(fulllist);
        String myJsonString = gson.toJson(people);
        File myFile = new File(filename);
        myFile.createNewFile();
        FileOutputStream fOut = new FileOutputStream(myFile);
        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
        myOutWriter.append(myJsonString);
        myOutWriter.close();
        fOut.close();
    }
}
