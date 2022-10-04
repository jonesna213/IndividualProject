package com.hondaparts.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

/**
 * This class is for scraping the RockAuto website for parts
 *
 * Going to give credit where credit is due. Got most info from the jsoup website itself but also had help from
 * https://www.javacodeexamples.com/jsoup-download-images-from-webpage-example/815
 */
public class RockAuto {
    private static String IMAGE_DESTINATION_FOLDER = "C:/Users/Navy Jones/IdeaProjects/IndividualProject/src/main/resources/partImages";


    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.rockauto.com/en/catalog/honda,1996,civic,1.6l+l4,1168882,brake+&+wheel+hub,brake+pad,1684").get();

        Elements parts = doc.select("tbody[id*=listingcontainer]");
        for (Element part : parts) {
            String price = part.select("[id~=dprice(\\[\\d+\\]\\[v\\])]").text();

            System.out.println(price);

            Elements img = part.select("[id~=inlineimg_thumb\\[\\d+\\]]");
            String strImageURL = img.attr("abs:src");

            //This is so it grabs the full img and not the thumbnail
            StringBuffer fullStrImgURL = new StringBuffer(strImageURL);
            fullStrImgURL.setCharAt(strImageURL.length()-5, 'p');
            downloadImage(strImageURL);
        }
    }

    private static void downloadImage(String strImageURL) {

        //get file name from image path
        String strImageName =
                strImageURL.substring( strImageURL.lastIndexOf("/") + 1 );

        System.out.println("Saving: " + strImageName + ", from: " + strImageURL);

        try {

            //open the stream from URL
            URL urlImage = new URL(strImageURL);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            OutputStream os =
                    new FileOutputStream( IMAGE_DESTINATION_FOLDER + "/" + strImageName );

            //write bytes to the output stream
            while ( (n = in.read(buffer)) != -1 ){
                os.write(buffer, 0, n);
            }

            //close the stream
            os.close();

            System.out.println("Image saved");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
