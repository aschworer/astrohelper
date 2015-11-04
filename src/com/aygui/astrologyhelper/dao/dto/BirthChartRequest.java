package com.aygui.astrologyhelper.dao.dto;

/**
 * Created by aschworer on 01-Nov-15.
 */
public class BirthChartRequest {
    private String city;
    private String name;
    private String sex;
    private String day;
    private String month;
    private String year;
    private String hour;
    private String min;
    private Boolean nohouses;
    private String coordinates;//todo

    public BirthChartRequest(String city, String name, String sex, String day, String month, String year, String hour, String min, Boolean nohouses) {
        this.city = city;
        this.name = name;
        this.sex = sex;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
        this.nohouses = nohouses;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getHour() {
        return hour;
    }

    public String getMin() {
        return min;
    }

    public Boolean getNohouses() {
        return nohouses;
    }

    @Override
    public String toString() {
        return "name=" + name;
    }
}
