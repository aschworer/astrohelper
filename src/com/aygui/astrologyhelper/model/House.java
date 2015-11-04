package com.aygui.astrologyhelper.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aschworer on 01-Nov-15.
 */
public enum House implements Characteristics {
    @SerializedName("Ascendant")
    I("Ascendant"),
    II("II"), III("III"), IV("IV"), V("V"), VI("VI"), VII("VII"), VIII("VIII"), IX("IX"),
    @SerializedName("Midheaven")
    X("Midheaven"),
    XI("XI"), XII("XII");

    private String string;

    House(String name) {
        string = name;
    }

    @Override
    public String toString() {
        return string;
    }

    public String getString() {
        return string;
    }

    public static Characteristics getByString(String str) {
        for (House v : values()) {
            if (v.string.equalsIgnoreCase(str)) {
                return v;
            }
        }
        return null;
    }

    public Integer getWeight() {
        switch (this) {
            case I:
                return 7;
            case X:
                return 5;
            default:
//                throw new IllegalArgumentException();
                return 0;//todo
        }
    }

    public Element getElement() {
        switch (this) {
            case I:
                return Element.FIRE;
            case V:
                return Element.FIRE;
            case IX:
                return Element.FIRE;
            case II:
                return Element.EARTH;
            case VI:
                return Element.EARTH;
            case X:
                return Element.EARTH;
            case III:
                return Element.AIR;
            case VII:
                return Element.AIR;
            case XI:
                return Element.AIR;
            case IV:
                return Element.WATER;
            case VIII:
                return Element.WATER;
            case XII:
                return Element.WATER;
            default:
                throw new IllegalArgumentException();
        }
    }

}
