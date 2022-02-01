package com.eterrain.yourbaazar.downloader;
import org.springframework.stereotype.Component;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
@Component
public class PageDownloader {

    public  void downloadPage(String page_url){
        try {
            URL url = new URL(page_url);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(url.openStream()));

            // Enter filename in which you want to download
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("downloads/Download.html"));
            BufferedWriter urlWriter =
                    new BufferedWriter(new FileWriter("urls/urls.txt"));

           //read lines
            String line;
            while ((line = br.readLine()) != null) {
                writer.write(line);
            }

            br.close();
            writer.close();
            System.out.println("Successfully Downloaded.");
        }
        catch (MalformedURLException ex) {
            System.out.println("Malformed URL Exception raised");
        }
        catch (IOException ex) {
            System.out.println("IOException raised");
        }
    }



}
