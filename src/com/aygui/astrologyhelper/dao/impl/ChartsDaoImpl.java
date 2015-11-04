package com.aygui.astrologyhelper.dao.impl;

import com.aygui.astrologyhelper.dao.ChartsDao;
import com.aygui.astrologyhelper.dao.dto.Data;
import com.aygui.astrologyhelper.model.Characteristics;
import com.aygui.astrologyhelper.model.NatalChart;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aschworer on 01-Nov-15.
 */
public class ChartsDaoImpl implements ChartsDao {

    public List<NatalChart> getPeopleCharts() throws Exception {
        InputStream in = getClass().getClassLoader().getResourceAsStream("charts.json");
        final InputStreamReader reader = new InputStreamReader(in);
        Gson gson = new GsonBuilder().registerTypeAdapter(Characteristics.class, new InterfaceAdapter<Characteristics>())
                .create();
        Data data = gson.fromJson(reader, Data.class);
        return (data == null) ? new ArrayList<>() : data.getData();
    }

    @Override
    public void savePeopleCharts(List<NatalChart> natalCharts) throws Exception {
        String filename = "src/charts.json";
        Gson gson = new Gson();
        if (natalCharts == null) natalCharts = new ArrayList<>();
        String myJsonString = gson.toJson(new Data(natalCharts));
        File myFile = new File(filename);
        myFile.createNewFile();
        FileOutputStream fOut = new FileOutputStream(myFile);
        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
        myOutWriter.append(myJsonString);
        myOutWriter.close();
        fOut.close();
    }

    public void saveNatalChartToEndOfFile(NatalChart natalChart) throws Exception {
        List<NatalChart> fulllist = getPeopleCharts();
        String filename = "src/charts.json";
        Gson gson = new Gson();
        if (fulllist == null) fulllist = new ArrayList<>();
        fulllist.add(natalChart);
        String myJsonString = gson.toJson(fulllist);
        File myFile = new File(filename);
        myFile.createNewFile();
        FileOutputStream fOut = new FileOutputStream(myFile);
        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
        myOutWriter.append(myJsonString);
        myOutWriter.close();
        fOut.close();
    }
}
