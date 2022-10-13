package com.hondaparts.util;

import com.hondaparts.entity.Merchant;
import com.hondaparts.persistence.GenericDao;

/**
 * This class is to be used to manually scrape the websites and update the database.
 *
 * @author Navy Jones
 */
public class WebScraping {

    public static void main(String[] args) {
        GenericDao<Merchant> merchantDao = new GenericDao<>(Merchant.class);
        Merchant rockAutoMerchant = new Merchant();
//        rockAutoMerchant.setName("Rock Auto");
//        rockAutoMerchant.setLogoImageFileLocation("src/main/resources/merchantsImages/rockAutoLogo.png");
//        rockAutoMerchant.setWebsite("https://www.rockauto.com");

//        if (merchantDao.getByPropertyEqual("name", rockAutoMerchant.getName()).size() == 0) {
//            merchantDao.insert(rockAutoMerchant);
//        }

        RockAuto rockAuto = new RockAuto();
        rockAuto.runRockAutoScrape(); //This is temporary, will eventually need params for what parts to scrape
    }
}
