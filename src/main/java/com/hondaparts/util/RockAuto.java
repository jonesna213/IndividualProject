package com.hondaparts.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
 * https://www.javacodeexamples.com/jsoup-download-images-from-webpage-example/815   For the downloading images method
 *
 * @author Navy Jones
 */
public class RockAuto {
    private static String IMAGE_DESTINATION_FOLDER = "C:/Users/Navy Jones/IdeaProjects/IndividualProject/src/main/resources/partImages";
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void runRockAutoScrape() {
        try {
            Document doc = Jsoup.connect("https://www.rockauto.com/en/catalog/honda,1996,civic,1.6l+l4,1168882,brake+&+wheel+hub,brake+pad,1684").get();
            Elements parts = doc.select("tbody[id*=listingcontainer]");
            for (Element part : parts) {
                //Price
                String price = part.select("[id~=dprice(\\[\\d+\\]\\[v\\])]").text();
                if (price.charAt(0) != '$') {
                    price = "View all prices to see price";
                }
                //Do something with price

                //Had to do this so that I could describe the quality..... Its ugly, I know
                String qualityOfPart = "";
                if (part.is("[style=background: #fff3de;]") || part.is("[style=background: #ffe8be;]")) {
                    qualityOfPart = " Economy ";
                } else if (part.is("[style=background: #bebeff;]") || part.is("[style=background: #dedeff;]")) {
                    qualityOfPart = " Daily Driver ";
                } else if (part.is("[style=background: #cbbecb;]") || part.is("[style=background: #e5dee5;]")) {
                    qualityOfPart = " Premium ";
                } else if (part.is("[style=background: #ebe5de;]") || part.is("[style=background: #d8cbbe;]")) {
                    qualityOfPart = " Heavy Duty ";
                } else if (part.is("[style=background: #fcdede;]") || part.is("[style=background: #f9bebe;]")) {
                    qualityOfPart = " Performance ";
                } else if (part.is("[style=background: #bebebe;]") || part.is("[style=background: #f9bebe;]")) {
                    qualityOfPart = " Track Use ";
                }

                //Part name == Manufacture + type of item (Break pad in this case)
                String partName = part.select("span.listing-final-manufacturer").text() + qualityOfPart + "Break Pads";

                //System.out.println(partName);

                //Images
                Elements img = part.select("[id~=inlineimg_thumb\\[\\d+\\]]");
                String strImageURL = img.attr("abs:src");
                /*
                 * This is so it grabs the full img and not the thumbnail as well as make sure the spaces are %20 instead
                 * of a space so that the file still gets downloaded
                 */
                strImageURL = strImageURL.replaceAll(" ", "%20");
                StringBuffer fullStrImgURL = new StringBuffer(strImageURL);
                fullStrImgURL.setCharAt(strImageURL.length()-5, 'p');
                //downloadImage(fullStrImgURL.toString());
            }
        } catch (IOException io) {
            logger.error("Problem with JSoup", io);
        }
    }

    private void downloadImage(String strImageURL) {

        //get file name from image path
        String strImageName =
                strImageURL.substring( strImageURL.lastIndexOf("/") + 1 );

        logger.info("Saving: " + strImageName + ", from: " + strImageURL);

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

            logger.info("Image saved");

        } catch (IOException e) {
            logger.error("Error with downloading image", e);
        }
    }
}
