package com.eterrain.yourbaazar.extractor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class UrlExtractor {
    public static void fetchUrl(String pattern, String parentUrl, Set<String> set,int depth) {
       if(!set.contains(parentUrl) && parentUrl.contains("http")) {
           if (parentUrl == null || depth > 2 || set.size() >= 50) {
              return;
           }else {
               Document doc = null;
               try {
                   doc = Jsoup.connect(parentUrl).get();
                   if(doc.toString().contains(pattern)){
                       set.add(parentUrl);
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }

               Elements links = doc.select("a[href]");
               for (Element link : links) {
                   String url = link.attr("href");
                   fetchUrl(pattern,url, set, depth + 1);
               }
           }
       }
    }
    public static void main(String[] args){
        String seedUrl="https://www.tutorialspoint.com/";
        Set<String> set= new HashSet<>();
        fetchUrl("add",seedUrl,set,0);
        System.out.println("set :" + set);
        System.out.println("size :" + set.size());
    }

}
