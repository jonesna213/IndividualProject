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
        //runRockAuto();
        runOReilly();
    }

    private static void runOReilly() {
        GenericDao<Merchant> merchantDao = new GenericDao<>(Merchant.class);
        Merchant oReillyMerchant = new Merchant();
        oReillyMerchant.setName("O'Reilly Auto Parts");
        oReillyMerchant.setLogoImageFileLocation("merchantsImages/oreillyLogo.jpg");
        oReillyMerchant.setWebsite("https://www.oreillyauto.com");

        if (merchantDao.getByPropertyEqual("name", oReillyMerchant.getName()).size() == 0) {
            merchantDao.insert(oReillyMerchant);
        }

        OReilly oReilly = new OReilly();
        oReilly.runOReillyScrape("Brakes");
    }

    private static void runRockAuto() {
        GenericDao<Merchant> merchantDao = new GenericDao<>(Merchant.class);
        Merchant rockAutoMerchant = new Merchant();
        rockAutoMerchant.setName("Rock Auto");
        rockAutoMerchant.setLogoImageFileLocation("merchantsImages/rockAutoLogo.png");
        rockAutoMerchant.setWebsite("https://www.rockauto.com");

        if (merchantDao.getByPropertyEqual("name", rockAutoMerchant.getName()).size() == 0) {
            merchantDao.insert(rockAutoMerchant);
        }

        RockAuto rockAuto = new RockAuto();
        rockAuto.runRockAutoScrape("Brakes"); //This is temporary, will eventually need params for what parts to scrape
    }
}
