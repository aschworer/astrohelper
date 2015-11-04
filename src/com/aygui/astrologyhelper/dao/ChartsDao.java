package com.aygui.astrologyhelper.dao;

import com.aygui.astrologyhelper.model.NatalChart;

import java.util.List;

/**
 * Created by aschworer on 02-Nov-15.
 */
public interface ChartsDao {

    List<NatalChart> getPeopleCharts() throws Exception;

    void savePeopleCharts(List<NatalChart> charts) throws Exception;
}
