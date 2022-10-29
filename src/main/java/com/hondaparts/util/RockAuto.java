package com.hondaparts.util;

import com.hondaparts.entity.Category;
import com.hondaparts.entity.Merchant;
import com.hondaparts.entity.Part;
import com.hondaparts.entity.PartsMerchants;
import com.hondaparts.persistence.GenericDao;
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
    private GenericDao<Part> partDao = new GenericDao<>(Part.class);
    private GenericDao<Category> catDao = new GenericDao<>(Category.class);
    private GenericDao<Merchant> merchantDao = new GenericDao<>(Merchant.class);
    private GenericDao<PartsMerchants> pmDao = new GenericDao<>(PartsMerchants.class);

    public void runRockAutoScrape() {
        String url = "https://www.rockauto.com/en/catalog/honda,1996,civic,1.6l+l4,1168882,brake+&+wheel+hub,brake+pad,1684";
        Merchant merchant = merchantDao.getByPropertyEqual("name", "Rock Auto").get(0);
        Category category = catDao.getById(1);
        try {
            Document doc = Jsoup.connect(url).get();
            Elements parts = doc.select("tbody[id*=listingcontainer]");
            for (Element part : parts) {
                Part newPart = new Part();
                //Price
                String price = part.select("[id~=dprice(\\[\\d+\\]\\[v\\])]").text();
                if (price.charAt(0) != '$') {
                    price = "View all prices to see price";
                }

                //Part name == Manufacture + quality(econ, daily driver, racing) + type of item (Brake pad in this case)
                String qualityOfPart = getQuality(part);
                String partName = part.select("span.listing-final-manufacturer").text() + qualityOfPart + "Brake Pads";

                //Part Number
                String partNumber = part.select("[id~=vew_partnumber(\\[\\d+\\])]").text();

                //Link to part
                String linkToPart = part.select("a.ra-btn-moreinfo").attr("href");
                if (linkToPart.length() < 1) {
                    linkToPart = url + "#" + part.attr("id");
                    linkToPart = linkToPart.replace("[", "%5B");
                    linkToPart = linkToPart.replace("]", "%5D");
                }

                //Description ish
                String description = part.select("span.span-link-underline-remover").text() + ". More info on merchant's website.";


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
                downloadImage(fullStrImgURL.toString());


                PartsMerchants pm = new PartsMerchants();

                //Creating part object and adding to database if its not already there
                if (partDao.getByPropertyEqual("partNumber", partNumber).size() == 0) {
                    newPart.setPartName(partName);
                    newPart.setPartNumber(partNumber);
                    newPart.setPartDescription(description);
                    newPart.setPartImageFileLocation(fullStrImgURL.toString());
                    newPart.setCategory(category);
                    pm.setPart(newPart);
                    newPart.getPartsMerchants().add(pm);
                    partDao.insert(newPart);
                } else {
                    pm.setPart(partDao.getByPropertyEqual("partNumber", partNumber).get(0));
                }
                pm.setMerchant(merchant);
                pm.setPrice(price);
                pm.setLinkToPart(linkToPart);

                pmDao.saveOrUpdate(pm);
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
