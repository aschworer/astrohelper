package com.aygui.astrologyhelper.utils;

import com.aygui.astrologyhelper.model.CharacteristicsInSign;

import java.util.Comparator;

/**
 * Created by aschworer on 01-Nov-15.
 */
public class CharacteristicWeightComparator implements Comparator<CharacteristicsInSign> {

    @Override
    public int compare(CharacteristicsInSign o1, CharacteristicsInSign o2) {
        if (o1.getCharacteristic().getWeight() > o2.getCharacteristic().getWeight()) {
            return -1;
        } else if (o1.getCharacteristic().getWeight() < o2.getCharacteristic().getWeight()) {
            return 1;
        } else if (o1.getCharacteristic().getWeight().equals(o2.getCharacteristic().getWeight())) {
            return 0;
        }
        return 1;
    }
}
