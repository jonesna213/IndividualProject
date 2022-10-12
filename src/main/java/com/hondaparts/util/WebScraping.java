package com.hondaparts.util;

/**
 * This class is to be used to manually scrape the websites and update the database.
 *
 * @author Navy Jones
 */
public class WebScraping {

    public static void main(String[] args) {
        RockAuto rockAuto = new RockAuto();
        rockAuto.runRockAutoScrape();
    }
}
