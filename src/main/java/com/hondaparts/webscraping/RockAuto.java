package com.hondaparts.webscraping;

import com.hondaparts.persistence.NewPart;
import com.hondaparts.util.ImageDownloader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

/**
 * This class is for scraping the RockAuto website for parts
 *
 * Going to give credit where credit is due. Got most info from the jsoup website itself but also had help from
 * https://www.javacodeexamples.com/jsoup-download-images-from-webpage-example/815   For the downloading images method
 *
 * @author Navy Jones
 */
public class RockAuto {
    private ImageDownloader downloader = new ImageDownloader();
    private NewPart newPart = new NewPart();
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void runRockAutoScrape(String categoryName) {
        String url = "https://www.rockauto.com/en/catalog/honda,1996,civic,1.6l+l4,1168882,brake+&+wheel+hub,brake+pad,1684";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements parts = doc.select("tbody[id*=listingcontainer]");
            for (Element part : parts) {
                String price = part.select("[id~=dprice(\\[\\d+\\]\\[v\\])]").text();
                //If the price isnt there tell them to go to the part page
                if (price.charAt(0) != '$') {
                    price = "View all prices to see price";
                }

                String qualityOfPart = getQuality(part);
                String partName = part.select("span.listing-final-manufacturer").text() + qualityOfPart + "Brake Pads";
                String partNumber = part.select("[id~=vew_partnumber(\\[\\d+\\])]").text();
                String linkToPart = part.select("a.ra-btn-moreinfo").attr("href");
                //Some parts don't have their own page so, use the url and have the id of the part for a direct link to the part
                if (linkToPart.length() < 1) {
                    linkToPart = url + "#" + part.attr("id");
                    linkToPart = linkToPart.replace("[", "%5B");
                    linkToPart = linkToPart.replace("]", "%5D");
                }

                String description = part.select("span.span-link-underline-remover").text() + ". More info on merchant's website.";
                Elements img = part.select("[id~=inlineimg_thumb\\[\\d+\\]]");
                String strImageURL = img.attr("abs:src");
                /*
                 * This is so it grabs the full img and not the thumbnail as well as make sure the spaces are %20 instead
                 * of a space so that the file still gets downloaded
                 */
                strImageURL = strImageURL.replaceAll(" ", "%20");
                StringBuffer fullStrImgURL = new StringBuffer(strImageURL);
                fullStrImgURL.setCharAt(strImageURL.length()-5, 'p');
                String imageLocation = "partImages/" + downloader.downloadImage(fullStrImgURL.toString());

                newPart.insertNewPart(partName, partNumber, description, imageLocation, linkToPart, price, categoryName, "Rock Auto");
            }
        } catch (IOException io) {
            logger.error("Problem with JSoup", io);
        }
    }

    //Had to do this so that I could describe the quality..... Its ugly, I know. (Might be able to refactor later)
    private String getQuality(Element part) {
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

        return qualityOfPart;
    }
}
