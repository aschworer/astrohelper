package com.aygui.astrologyhelper.utils;

import com.aygui.astrologyhelper.dao.dto.BirthChartRequest;
import com.aygui.astrologyhelper.model.*;

import java.util.Collections;
import java.util.List;

/**
 * Created by aschworer on 01-Nov-15.
 */
public class Utils {


    public static Characteristics getByString(String str) {
        Characteristics characteristic = Planet.getByString(str);
        if (characteristic != null) return characteristic;
        characteristic = House.getByString(str);
        if (characteristic != null) return characteristic;
        //todo
        return null;
    }


    public static Boolean samePerson(Person person, BirthChartRequest birthChartRequest) {
        if (
                person.getName().equalsIgnoreCase(birthChartRequest.getName())
//                && //todo
                ) {
            return true;
        }
        return false;
    }

    public static List<CharacteristicsInSign> sortByWeight(List<CharacteristicsInSign> characteristicsInSigns) {
        Collections.sort(characteristicsInSigns, new CharacteristicWeightComparator());
        return characteristicsInSigns;
    }
}
