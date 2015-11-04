package com.aygui.astrologyhelper.service.impl;

import com.aygui.astrologyhelper.model.*;
import com.aygui.astrologyhelper.service.Horoscopes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by aschworer on 02-Nov-15.
 */
public class HoroscopesServiceImpl implements Horoscopes {

    private List<NatalChart> charts;

    public HoroscopesServiceImpl(List<NatalChart> charts) {
        this.charts = charts;
    }

    @Override
    public List<String> getNamesByCharacteristicsInSign(CharacteristicsInSign characteristicsInSign) {
        List<String> names = new ArrayList<>();
        for (NatalChart chart : charts) {
            for (CharacteristicsInSign c : chart.getCharacteristicsInSigns()) {
                if (c.getCharacteristic().equals(characteristicsInSign.getCharacteristic())
                        &&
                        c.getSign().equals(characteristicsInSign.getSign())) {
                    names.add(chart.getPerson().getName());
                }
            }
        }
        return names;
    }

    @Override
    public List<String> getNamesByDominantElement(Element element) {
        List<String> names = new ArrayList<>();
        for (NatalChart chart : charts) {
//            for (ElementBreakdown elementBreakdown: chart.getElementBreakdown().ge){
            if (chart.isDominant(element)) {
                names.add(chart.getPerson().getName());
            }
//            }
        }
        return names;
    }

    @Override
    public HashMap<String, Sign> getNameAndSignByCharacteristics(Characteristics characteristic) throws Exception {
        HashMap<String, Sign> result = new HashMap<>();
        for (NatalChart chart : charts) {
            for (CharacteristicsInSign characteristicsInSign : chart.getCharacteristicsInSigns()) {
                if (characteristicsInSign.getCharacteristic().equals(characteristic)) {
                    result.put(chart.getPerson().getName(), characteristicsInSign.getSign());
                }
            }
        }
        return result;
    }
}
