package com.aygui.astrologyhelper.dao.dto;

import com.aygui.astrologyhelper.model.NatalChart;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Data {

    @SerializedName("charts")
    private List<NatalChart> data = new ArrayList<>();

    public Data() {
    }

    public Data(List<NatalChart> data) {
        this.data = data;
    }

    public List<NatalChart> getData() {
        return data;
    }

    public void setData(List<NatalChart> data) {
        this.data = data;
    }
}
