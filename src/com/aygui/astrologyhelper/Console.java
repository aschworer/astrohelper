package com.aygui.astrologyhelper;

import com.aygui.astrologyhelper.dao.ChartsFacade;
import com.aygui.astrologyhelper.dao.impl.ChartsFacadeImpl;
import com.aygui.astrologyhelper.model.CharacteristicsInSign;
import com.aygui.astrologyhelper.model.NatalChart;
import com.aygui.astrologyhelper.model.Planet;
import com.aygui.astrologyhelper.model.Sign;
import com.aygui.astrologyhelper.service.Horoscopes;
import com.aygui.astrologyhelper.service.PeopleService;
import com.aygui.astrologyhelper.service.impl.HoroscopesServiceImpl;
import com.aygui.astrologyhelper.service.impl.PeopleServiceImpl;

import java.util.List;

/**
 * Created by aschworer on 02-Nov-15.
 */
public class Console {

    private static ChartsFacade facade = new ChartsFacadeImpl();
    private static Horoscopes horoscopes;
    private static List<NatalChart> charts;
    private static PeopleService peopleService = new PeopleServiceImpl();


    //parse chiron
    public static void main(String[] args) throws Exception {
//        System.out.println(new AstroCafeScrapperImpl().getLocation("Bourg-en-bresse"));
        charts = facade.getPeopleCharts();
//        System.out.println(charts);
        //todo when adding new person, changing to sync and then straight away his name - gets null - because file is empty till process is over - WHY????
//        peopleService.add("Mom","08/10/1952","Semiletka","F");
//        peopleService.add("Dad","22/02/1953","Ufa","M");
//        peopleService.add("Ruslan","07/12/1977","Ufa","M");
//        peopleService.add("Polina","01/06/1986","Cherkasy","F");
//        peopleService.add("Dinko","01/03/1985","Sydney","M");
//        peopleService.add("Oleg","05/07/1986","Sochi","M");
//        peopleService.add("Tema","13/09/1985","Saint Petersburg","M");
//        peopleService.add("Olga","12/05/1980","Saint Petersburg","F");
//        peopleService.add("Masha","23/12/1986","Nadym","F");
//        peopleService.add("Sergey","24/03/1984","Ufa","M");
//        peopleService.add("Frank","10/05/1983","Hong Kong","M");
//        peopleService.add("Vitya","13/06/1986","Rostov-na-Donu","M");
//        peopleService.add("Rohit","13/08/1985","Calcutta","M");
//        peopleService.add("Ilya","10/05/1986","Saint Petersburg","M");
//        peopleService.add("Tanya","13/08/1985","Nadym","F");
//        peopleService.add("Yana","28/02/1986","Nadym","F");
//        peopleService.add("Yulia","20/04/1986","Nadym","F");
//        peopleService.add("Nastya","12/08/1986","Nadym","F");
//        peopleService.add("Katya G","21/02/1986","Nadym","F");
//        peopleService.add("Lena","04/04/1986","Nalchik","F");
//        peopleService.add("Guis mom","12/07/1954","Lyon","F");
//        peopleService.add("Guis dad","30/03/1955","Villingen-Schwenningen","M");
//        peopleService.add("Guis bro","13/01/1990 07:00","Bourg-en-bresse","M");
//        peopleService.add("Katya P","04/07/1986 18:50","Donetsk","F");


        facade.syncPeopleWithCharts(); // - when people list updated

//        System.out.println(facade.getByName("Guis bro"));
//        System.out.println(facade.getByName("Katya P"));
//        System.out.println(facade.getByName("Guis dad"));
//        System.out.println(facade.getByName("Guis mom"));
//
//        System.out.println(facade.getByName("Aygul"));
//        System.out.println(facade.getByName("Ruslan"));
//        System.out.println(facade.getByName("Mom"));
//        System.out.println(facade.getByName("Dad"));
//        System.out.println(facade.getByName("Ilya"));

        horoscopes = new HoroscopesServiceImpl(charts);
        System.out.println(horoscopes.getNamesByCharacteristicsInSign(new CharacteristicsInSign(Planet.MOON, Sign.CANCER)));
//        System.out.println(horoscopes.getNamesByCharacteristicsInSign(new CharacteristicsInSign(Planet.VENUS, Sign.ARIES)));
//        System.out.println(horoscopes.getNamesByCharacteristicsInSign(new CharacteristicsInSign(Planet.MOON, Sign.GEMINI)));

//        System.out.println(horoscopes.getNamesByDominantElement(Element.AIR));

//        System.out.println(horoscopes.getNameAndSignByCharacteristics(Planet.MOON));

        //todo characteristics in element!


    }
}
