package com.aygui.astrologyhelper.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aschworer on 01-Nov-15.
 */

public enum Planet implements Characteristics {
    SUN("Sun"), MOON("Moon"), MERCURY("Mercury"), MARS("Mars"), VENUS("Venus"),
    JUPITER("Jupiter"), SATURN("Saturn"), URANUS("Uranus"), NEPTUNE("Neptune"),
    PLUTO("Pluto"), CHIRON("Chiron"), /*ASCENDANT("Ascendant"), MIDHEAVEN("Midheaven"),*/
    LILITH("Lilith"),
    @SerializedName("Asc node")
    ASC_NODE("Asc node");

    public Integer getWeight() {
        switch (this) {
            case SUN:
                return 10;
            case MOON:
                return 10;
            case MARS:
                return 8;
            case VENUS:
                return 8;
            case MERCURY:
                return 8;
            case JUPITER:
                return 2;
            case SATURN:
                return 1;
            case URANUS:
                return 1;
            case NEPTUNE:
                return 1;
            case PLUTO:
                return 1;
//            case CHIRON:
//                return 1;
            case LILITH:
                return 0;//todo
            case ASC_NODE:
                return 0;//todo
            default:
                throw new IllegalArgumentException();
        }
    }

    private String string;

    Planet(String name) {
        string = name;
    }

    @Override
    public String toString() {
        return string;
    }

    public static Characteristics getByString(String str) {
        for (Planet v : values()) {
            if (v.string.equalsIgnoreCase(str)) {
                return v;
            }
        }
        return null;
    }


    public String getString() {
        return string;
    }

    public Element getElement() {

        switch (this) {
            case SUN:
                return Element.FIRE;
            case MOON:
                return Element.WATER;
            case MERCURY:
                return Element.AIR;//or earth
            case VENUS:
                return Element.EARTH;//or air
            case MARS:
                return Element.FIRE;
            case JUPITER:
                return Element.AIR;//or fire
            case SATURN:
                return Element.EARTH;
            case URANUS:
                return Element.AIR;
            case NEPTUNE:
                return Element.WATER;
            case PLUTO:
                return Element.WATER;
            default:
                throw new IllegalArgumentException();
        }
    }
}
