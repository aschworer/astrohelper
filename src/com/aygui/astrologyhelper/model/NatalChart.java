package com.aygui.astrologyhelper.model;

import com.aygui.astrologyhelper.dao.dto.BirthChartRequest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by aschworer on 01-Nov-15.
 */
public class NatalChart {

    private BirthChartRequest person;
    private List<CharacteristicsInSign> characteristicsInSigns;


    public NatalChart(List<CharacteristicsInSign> characteristicsInSigns) {
        this.characteristicsInSigns = characteristicsInSigns;
        makeElementBreakdown();
    }

    public List<CharacteristicsInSign> getCharacteristicsInSigns() {
        return characteristicsInSigns;
    }

    private TreeMap<Integer, Set<Element>> elementBreakdown;

    public BirthChartRequest getPerson() {
        return person;
    }

    public void setPerson(BirthChartRequest person) {
        this.person = person;
    }

    public void makeElementBreakdown() {
        elementBreakdown = new TreeMap<>();
        for (Element element : Element.values()) {
            Integer elementWeight = 0;
            for (CharacteristicsInSign c : characteristicsInSigns) {
                if (c.getSign().getElement() == element) {
                    elementWeight += c.getCharacteristic().getWeight();
                }
            }
            if (elementBreakdown.get(elementWeight) == null) {
                elementBreakdown.put(elementWeight, new HashSet<>());
            }
            elementBreakdown.get(elementWeight).add(element);
        }
    }

    public Boolean isDominant(Element element) {
        if (elementBreakdown == null) makeElementBreakdown();
        return elementBreakdown.get(elementBreakdown.lastKey()).contains(element);
    }

    @Override
    public String toString() {
        String listString = "";
        listString += person.toString() + "\n";
        for (CharacteristicsInSign s : characteristicsInSigns) {
            listString += s + "\n";
        }

        listString += "\n" + elementBreakdown;
        return listString;
    }
}
