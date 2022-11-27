package com.hondaparts.webscraping;

import com.hondaparts.persistence.NewPart;
import com.hondaparts.util.ImageDownloader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class OReilly {
    private ImageDownloader downloader = new ImageDownloader();
    private NewPart newPart = new NewPart();
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void runOReillyScrape(String categoryName) {
        String url = "https://www.oreillyauto.com/shop/b/brakes/brake-pads---shoes/a349129f45da/v/a/6008/automotive-car-1996-honda-civic";

        try {
            Document doc = Jsoup.connect(url).cookie("selectedStoreId", "5036").get();
            Elements parts = doc.select("article");
            for (Element part : parts) {

                String partName = part.select("h2.js-product-name").text();
                String partNumber = part.select("dd.js-ga-product-line-number").text();
                String fit = part.select("div.fit-descriptions").text();
                String description = part.select("div.attribute_wrap").text();

                if (!fit.equals("View All Applications")) {
                    description = fit + " " + description;
                }

                Elements img = part.select("img.product__image");
                String imgURL = "https:" + img.attr("data-original");
                imgURL.replace("medium", "extralarge");


                String imgLocation = downloader.downloadImage(imgURL);
                String linkToPart = "https://www.oreillyauto.com/" + part.select("a.js-product-link").attr("href");
                String price = part.select("strong.pricing_price").text();

                newPart.insertNewPart(partName, partNumber, description, imgLocation, linkToPart, price, categoryName, "O'Reilly Auto Parts");
            }
        } catch (IOException io) {
            logger.error("Problem with JSoup", io);
        }
    }
}
