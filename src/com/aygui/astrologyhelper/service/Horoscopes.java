package com.aygui.astrologyhelper.service;

import com.aygui.astrologyhelper.model.Characteristics;
import com.aygui.astrologyhelper.model.CharacteristicsInSign;
import com.aygui.astrologyhelper.model.Element;
import com.aygui.astrologyhelper.model.Sign;

import java.util.HashMap;
import java.util.List;

/**
 * Created by aschworer on 02-Nov-15.
 */
public interface Horoscopes {

    List<String> getNamesByCharacteristicsInSign(CharacteristicsInSign characteristicsInSign);

    List<String> getNamesByDominantElement(Element element);

    //example - Moon
    //Dinko - Gemini
    //Dad - Gemini
    //Polina - Aries
    // etc...
    HashMap<String, Sign> getNameAndSignByCharacteristics(Characteristics characteristic) throws Exception;
//

}
