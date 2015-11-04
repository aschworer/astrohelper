package com.aygui.astrologyhelper.model;

/**
 * Created by aschworer on 01-Nov-15.
 */
public enum Element {
    WATER("Water"),
    EARTH("Earth"),
    FIRE("Fire"),
    AIR("Air");

    private String string;

    Element(String name) {
        string = name;
    }

    @Override
    public String toString() {
        return string;
    }

    public static Element getByString(String str) {
        for (Element v : values()) {
            if (v.toString().equalsIgnoreCase(str)) {
                return v;
            }
        }
        return null;
    }

}
