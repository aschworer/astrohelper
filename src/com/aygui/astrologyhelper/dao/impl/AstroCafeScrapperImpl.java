package com.aygui.astrologyhelper.dao.impl;

import com.aygui.astrologyhelper.dao.AstroCafeScrapper;
import com.aygui.astrologyhelper.dao.dto.BirthChartRequest;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.List;


/**
 * Created by aschworer on 01-Nov-15.
 */
public class AstroCafeScrapperImpl implements AstroCafeScrapper {

    @Override
    public List<String> getLocation(String city) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");

        engine.eval("import urllib2");

        engine.eval("import re");

        String url = "http://astro.cafeastrology.com/cgi-bin/astro/natal?member=&recalc=&name=asdasd&" +
                "sex=t&d1day=1&d1month=1&d1year=2000&d1hour=12&d1min=0&nohouses=true&city=" + city + "&lang=en";
        engine.put("url", url);

        engine.eval("page = str(urllib2.urlopen(urllib2.Request(url)).read())");
        engine.eval("pageextract = re.findall('citylist(.+?\\<\\/select\\>)', page, re.IGNORECASE)[0]");

        engine.eval("cities = re.findall('value=\\\"(.+?)\\\".*?>(.+?)\\<', pageextract, re.IGNORECASE)");
        engine.eval("result = \";\".join([item[0] for i, item in enumerate(cities)])");

        Object x = engine.get("result");
        return Arrays.asList(((String) x).split(";"));
    }

    @Override
    public String retrieveBirthChartPageExctract(BirthChartRequest data) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");
        engine.eval("import urllib2");
        engine.eval("import re");
        engine.eval("import urllib");
        engine.eval("import zlib");

        String url = "http://astro.cafeastrology.com/cgi-bin/astro/natal";

        engine.eval("params = { " +
                "'member' :'', " +
                "'recalc' :'', " +

                "'name' :'" + data.getName() + "', " +
                ("F".equalsIgnoreCase(data.getSex()) ? "'sex' :'f', " : "'sex' :'t', ") +
                "'d1day' :'" + data.getDay() + "', " +
                "'d1month' :'" + data.getMonth() + "', " +
                "'d1year' :'" + data.getYear() + "', " +
                "'d1hour' :'" + data.getHour() + "', " +
                "'d1min' :'" + data.getMin() + "', " +
                "'citylist' :'" + data.getCity() + "', " +

                (data.getNohouses() ? "'nohouses' :'true', " : "") +


                "'lang' :'en' " +
                "}");

        engine.eval("url_values = urllib.urlencode(params)");

        engine.put("url", url);
        engine.eval("full_url = url+\"?\"+url_values");
        //todo debug info
        System.out.println("Going to AstroCafe for " + data.getName() + "'s chart with URL: " + engine.get("full_url"));

        engine.eval("data = urllib2.urlopen(urllib2.Request(full_url\n" +
                ",headers = { 'Cache-Control': 'max-age=0', 'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0', " +
//                "'Accept-Encoding':'gzip, deflate', " +
                "'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8', 'Connection':'keep-alive', 'Host':'astro.cafeastrology.com', 'Accept-Language': 'en-US,en;q=0.5' }\n" +
                "                                       )).read()\n");
//        engine.eval("decomp = zlib.decompressobj(16 + zlib.MAX_WBITS)\n");

//        engine.eval("data = str(decomp.decompress(data))\n");
        engine.eval("pageextract = re.findall('Zodiac in degrees(.+?\\<\\/table\\>)', data, re.IGNORECASE)[0]\n");
        engine.eval("blah = '<!!>'.join([" +
                "'<!>'.join([i.replace('&nbsp;', '').strip() for i in re.findall('td.*?\\>(.*?)\\<', txt) if i!='']).replace('<!><!>', '<!!>') " +
                "for txt in re.findall('\\<tr\\>(.+?)<\\/tr\\>', pageextract)]).replace('<!!><!!>', '<!!>')");
//        System.out.println(engine.get("blah"));

        Object x = engine.get("blah");
        return (String) x;
    }


}
