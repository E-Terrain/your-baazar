package com.eterrain.yourbaazar.extractor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

@Component
public class UrlExtractor {
    public  Set<String> fetchUrl(String parentUrl, Set<String> set) {
        Document doc = null;
        BufferedWriter urlWriter =
                null;
        try {
            urlWriter = new BufferedWriter(new FileWriter("urls/urls.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            doc = Jsoup.connect(parentUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            String url=link.attr("href");
            set.add(url);
            System.out.println("\nlink : " + url);
            System.out.println("text : " + link.text());

        }
        try {
            urlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }
}
