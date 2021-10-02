package com.morgann.html.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

//import static com.sun.activation.registries.LogSupport.log;

/**
 * Created by morga on 08/08/2018.
 */
public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        /*
        Document doc = Jsoup.connect("http://en.wikipedia.org/").timeout(30000).get();
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            System.out.println(String.format("%s\n\t%s",
                    headline.attr("title"), headline.absUrl("href")));
        }
        */
        Document doc = Jsoup.connect("https://www.boursorama.com/bourse/opcvm/cours/MP-829253/").timeout(30000).get();
        //System.out.println(doc.title());
        //System.out.println(doc.text());
        System.out.println(doc.outerHtml());
    }
}
