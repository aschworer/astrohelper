package com.aygui.astrologyhelper.dao;


import com.aygui.astrologyhelper.dao.dto.BirthChartRequest;

import javax.script.ScriptException;
import java.util.List;

/**
 * Created by aschworer on 01-Nov-15.
 */
public interface AstroCafeScrapper {

    List<String> getLocation(String city) throws ScriptException;//todo;

    String retrieveBirthChartPageExctract(BirthChartRequest request) throws Exception;

}
