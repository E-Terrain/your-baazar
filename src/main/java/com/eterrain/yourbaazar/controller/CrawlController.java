package com.eterrain.yourbaazar.controller;

import com.eterrain.yourbaazar.downloader.PageDownloader;
import com.eterrain.yourbaazar.extractor.UrlExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class CrawlController {
    @Autowired
    PageDownloader pageDownloader;
    @Autowired
    UrlExtractor urlExtractor;

    @RequestMapping("/crawl")
    public String getDocuments(){String text="https://www.google.com/";
        Set<String> set= new HashSet<>();
      //  urlDownloader.downloadPage();
        return urlExtractor.fetchUrl(text,set).toString();
        //return "spring boot initial commit !!";
    }
}
