package com.aygui.astrologyhelper.dao.impl;

import com.aygui.astrologyhelper.dao.AstroCafeScrapper;
import com.aygui.astrologyhelper.dao.ChartsDao;
import com.aygui.astrologyhelper.dao.ChartsFacade;
import com.aygui.astrologyhelper.dao.PeopleDao;
import com.aygui.astrologyhelper.dao.dto.BirthChartRequest;
import com.aygui.astrologyhelper.model.CharacteristicsInSign;
import com.aygui.astrologyhelper.model.NatalChart;
import com.aygui.astrologyhelper.model.Person;
import com.aygui.astrologyhelper.model.Sign;
import com.aygui.astrologyhelper.utils.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aschworer on 02-Nov-15.
 */
public class ChartsFacadeImpl implements ChartsFacade {

    private ChartsDao chartsDao = new ChartsDaoImpl();
    private PeopleDao peopleDao = new PeopleDaoImpl();
    private AstroCafeScrapper astroCafefacade = new AstroCafeScrapperImpl();

    @Override
    public List<NatalChart> getPeopleCharts() throws Exception {
        return chartsDao.getPeopleCharts();
    }

    @Override
    public void syncPeopleWithCharts() throws Exception {
        List<Person> people = peopleDao.getPeople();
        List<NatalChart> charts = chartsDao.getPeopleCharts();

        for (Person person : people) {
            boolean found = false;
            if (charts != null)
                for (NatalChart chart : charts) {
                    if (Utils.samePerson(person, chart.getPerson())) {
                        found = true;
                        break;
                    }
                }
            if (!found) {
                //add personal chart into db
                String location = astroCafefacade.getLocation(person.getLocation()).get(0);//todo
                person.setLocation(location);
                BirthChartRequest request = convertToPersonalData(person);
                NatalChart natalChart = getNatalChart(astroCafefacade.retrieveBirthChartPageExctract(request));
                natalChart.setPerson(request);
                Utils.sortByWeight(natalChart.getCharacteristicsInSigns());
                charts.add(natalChart);
            }
        }
        chartsDao.savePeopleCharts(charts);
    }

    @Override
    public NatalChart getByName(String name) throws Exception {
        List<NatalChart> charts = chartsDao.getPeopleCharts();

        for (NatalChart chart : charts) {
            if (Utils.samePerson(new Person(name), chart.getPerson())) {
                return chart;
            }
        }
        return null;

    }


    private BirthChartRequest convertToPersonalData(Person person) {
        LocalDateTime dateTime;
        boolean timeUnknown = false;
        try {
            dateTime = LocalDateTime.parse(person.getDob(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        } catch (DateTimeParseException exception) {
            dateTime = LocalDateTime.parse(person.getDob() + " 12:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            timeUnknown = true;//todo
        }

        BirthChartRequest pd = new BirthChartRequest(person.getLocation(), person.getName(), person.getSex(),
                String.valueOf(dateTime.getDayOfMonth()),
                String.valueOf(dateTime.getMonthValue()),
                String.valueOf(dateTime.getYear()),
                String.valueOf(dateTime.getHour()),
                String.valueOf(dateTime.getMinute()),
                timeUnknown
        );
        return pd;
    }

    private NatalChart getNatalChart(String pageExctract) {
        List<CharacteristicsInSign> characteristicsInSigns = new ArrayList<>();

        CharacteristicsInSign characteristicsInSign = null;
        for (String s : pageExctract.split("<!!>")) {
//            System.out.println(s);
            int i = 1;

            for (String word : s.split("<!>")) {

                if (i == 1 || i == 4) {
                    if (characteristicsInSign != null) {
                        characteristicsInSigns.add(characteristicsInSign);
                    }
                    characteristicsInSign = new CharacteristicsInSign();
                }
                if (!"&nbsp;".equals(word)) {
                    if (i == 1 || i == 5) {
                        characteristicsInSign.setCharacteristic(Utils.getByString(word));
                    } else if (i == 2 || i == 6) {
                        characteristicsInSign.setSign(Sign.getByString(word));
                    } else {
                        characteristicsInSign.setAngleStr(word);
                    }
//                System.out.println(word);
                }
                i++;
            }
        }
//        sortByWeight(characteristicsInSigns);
        NatalChart natalChart = new NatalChart(characteristicsInSigns);
        return natalChart;
    }
}
