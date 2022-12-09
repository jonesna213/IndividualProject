package com.hondaparts.persistence;

import com.hondaparts.entity.Category;
import com.hondaparts.entity.Merchant;
import com.hondaparts.entity.Part;
import com.hondaparts.entity.PartsMerchants;
import com.hondaparts.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test class is for testing the NewPart class that is used with the web scraping classes.
 *
 * @author Navy Jones
 */
public class NewPartDaoTest {
    NewParts newParts;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        newParts = new NewParts();
    }

    /**
     * Verify successful insert of a new part
     */
    @Test
    void insertNewPartSuccess() {
        GenericDao<Merchant> merchantDao = new GenericDao<>(Merchant.class);
        GenericDao<Category> catDao = new GenericDao<>(Category.class);
        GenericDao<Part> partDao = new GenericDao<>(Part.class);
        Merchant merchant = merchantDao.getByPropertyEqual("name", "TestMerchant").get(0);
        Category category = catDao.getByPropertyEqual("category", "Exhaust").get(0);

        Part newPart = new Part("newPart", "newPartNumber", "newPartDescription", "newPartImage");
        PartsMerchants pm = new PartsMerchants();

        newPart.setCategory(category);
        pm.setPart(newPart);
        newPart.getPartsMerchants().add(pm);
        pm.setMerchant(merchant);
        pm.setPrice("price");
        pm.setLinkToPart("testLink");

        newParts.insertNewPart(newPart.getPartName(), newPart.getPartNumber(), newPart.getPartDescription(), newPart.getPartImageFileLocation(),
                pm.getLinkToPart(), pm.getPrice(), category.getCategory(), merchant.getName());

        Part insertedPart = partDao.getByPropertyEqual("partName", newPart.getPartName()).get(0);

        assertEquals(newPart.getPartName(), insertedPart.getPartName());
        assertEquals(newPart.getPartNumber(), insertedPart.getPartNumber());
        assertEquals(newPart.getPartDescription(), insertedPart.getPartDescription());
        assertEquals(newPart.getPartImageFileLocation(), insertedPart.getPartImageFileLocation());
        assertEquals(newPart.getCategory(), insertedPart.getCategory());
    }

    /**
     * Verify successful insert of an existing part
     */
    @Test
    void insertExistingPartSuccess() {
        GenericDao<Merchant> merchantDao = new GenericDao<>(Merchant.class);
        GenericDao<Category> catDao = new GenericDao<>(Category.class);
        GenericDao<Part> partDao = new GenericDao<>(Part.class);
        Merchant merchant = merchantDao.getByPropertyEqual("name", "TestMerchant").get(0);
        Category category = catDao.getByPropertyEqual("category", "Exhaust").get(0);

        Part newPart = new Part("newPart", "12345", "newPartDescription", "newPartImage");
        PartsMerchants pm = new PartsMerchants();

        newPart.setCategory(category);
        pm.setPart(newPart);
        newPart.getPartsMerchants().add(pm);
        pm.setMerchant(merchant);
        pm.setPrice("price");
        pm.setLinkToPart("testLink");

        newParts.insertNewPart(newPart.getPartName(), newPart.getPartNumber(), newPart.getPartDescription(), newPart.getPartImageFileLocation(),
                pm.getLinkToPart(), pm.getPrice(), category.getCategory(), merchant.getName());

        assertEquals(0, partDao.getByPropertyEqual("partName", newPart.getPartName()).size());
    }
}
