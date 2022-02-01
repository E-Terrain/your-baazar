package com.eterrain.yourbaazar.extractor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Component
public class UrlExtractor {
    public static void fetchUrl(String parentUrl, Set<String> set,int depth) {
       if(!set.contains(parentUrl)) {
           set.add(parentUrl);
           if (parentUrl == null || depth > 2 || set.size() >= 50) {
               System.out.println("url :" + set);
           }else {
               Document doc = null;
               try {
                   doc = Jsoup.connect(parentUrl).get();
               } catch (IOException e) {
                   e.printStackTrace();
               }
               Elements links = doc.select("a[href]");
               for (Element link : links) {
                   String url = link.attr("href");
                   fetchUrl(url, set, depth + 1);
               }
           }
       }
    }
    public static void main(String[] args){
        String seedUrl="https://www.tutorialspoint.com/";
        Set<String> set= new HashSet<>();
        fetchUrl(seedUrl,set,0);
        System.out.println("size :" + set.size());
    }

}
