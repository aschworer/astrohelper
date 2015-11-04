package com.aygui.astrologyhelper.dao;

import com.aygui.astrologyhelper.model.NatalChart;

import java.util.List;

/**
 * Created by aschworer on 02-Nov-15.
 */
public interface ChartsFacade {

    List<NatalChart> getPeopleCharts() throws Exception;

    //later on - with android client
//    void addPerson(Person person);

    void syncPeopleWithCharts() throws Exception;

    NatalChart getByName(String name) throws Exception;
}
