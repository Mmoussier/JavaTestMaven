package com.morgann.html.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by morga on 08/08/2018.
 */
public class JsoupNhlDemo {
    public static void main(String[] args) throws IOException {
        //SportsDatabase();
        HockeydbPlayers();
    }

    private static void HockeydbPlayers() throws IOException {
        Document doc = Jsoup.connect("http://www.hockeydb.com/ihdb/players/player_ind_b.html").timeout(60000).get();
        Element tablebgl = doc.getElementsByClass("tablebgl").first();
        if (tablebgl != null) {
            Element table = tablebgl.getElementsByTag("table").first();
            if (table != null) {
                Element tbody = table.getElementsByTag("tbody").first();
                if (tbody != null) {
                    Elements trs = tbody.getElementsByTag("tr");
                    for (Element tr : trs) {
                        Element td = tr.getElementsByTag("td").first();
                        System.out.println(td.text());
                    }
                }
            }
        }
    }

    private static void SportsDatabase() throws IOException {
        Document doc = Jsoup.connect("http://sportsdatabase.com/nhl/query?output=default&sdql=team%2Cconference%2Cdivision+%40+season%3D2017+and+game+number%3D1&submit=++S+D+Q+L+%21++").timeout(30000).get();
        System.out.println(doc.title());
        Element masthead = doc.select("div.dataTables_wrapper no-footer").first();
        // div with class=masthead

        Elements html = doc.select("html");  // Ok
        Element head = doc.select("head").first(); // OK
        Elements tables = doc.select("table"); // OK : toutes les tables du document
        Element table = doc.getElementsByAttributeValue("id","DT_Table").first();
        Element tbody = table.getElementsByTag("tbody").first();
        Elements trs = tbody.getElementsByTag("tr");
        /*
        for (Element table : tables) {
            if (table.id() == "DT_Table") {
                Element tbody = table.getElementsByTag("tbody").first();
                if (tbody != null) {
                    Elements trs = tbody.getElementsByTag("tr");
                }
            }
        }
        */

    }
}
