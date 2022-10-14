package com.hondaparts.persistence;

import com.hondaparts.entity.*;
import com.hondaparts.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is for testing the part dao
 *
 * @author Navy Jones
 */
public class PartDaoTest {
    GenericDao<Part> dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao<>(Part.class);
    }

    /**
     * Verify successful retrieval of a part
     */
    @Test
    void getByIdSuccess() {
        Part retrievedPart = dao.getById(1);
        assertEquals("greatExhaust", retrievedPart.getPartName());
        assertEquals("12345", retrievedPart.getPartNumber());
    }

    /**
     * Verify successful insert of a part
     */
    @Test
    void insertSuccess() {
        GenericDao<Category> catDao = new GenericDao<>(Category.class);
        Part newPart = new Part("newPart", "newPartNumber", "newPartDescription", "newPartImage");
        newPart.setCategory(catDao.getById(1));

        int id = dao.insert(newPart);
        assertNotEquals(0,id);
        Part insertedPart = dao.getById(id);
        assertEquals(newPart.getId(), insertedPart.getId());
        assertEquals(newPart.getPartName(), insertedPart.getPartName());
        assertEquals(newPart.getPartNumber(), insertedPart.getPartNumber());
        assertEquals(newPart.getPartDescription(), insertedPart.getPartDescription());
        assertEquals(newPart.getPartImageFileLocation(), insertedPart.getPartImageFileLocation());
        assertEquals(newPart.getCategory(), insertedPart.getCategory());
    }

    /**
     * Verify successful insert of the parts merchants table
     */
    @Test
    void insertPartsMerchantsSuccess() {
        GenericDao<Category> catDao = new GenericDao<>(Category.class);
        GenericDao<PartsMerchants> pmDao = new GenericDao<>(PartsMerchants.class);
        GenericDao<Merchant> merchantDao = new GenericDao<>(Merchant.class);


        Merchant merchant = merchantDao.getById(1);

        Part newPart = new Part("newPart", "newPartNumber", "newPartDescription", "newPartImage");
        newPart.setCategory(catDao.getById(1));

        PartsMerchants pm = new PartsMerchants();
        pm.setMerchant(merchant);
        pm.setPart(newPart);
        pm.setLinkToPart("website.com/newPart");
        pm.setPrice("$100");

        newPart.getPartsMerchants().add(pm);

        int partId = dao.insert(newPart);

        assertNotEquals(0,partId);

        Part insertedPart = dao.getById(partId);
        assertEquals(newPart.getId(), insertedPart.getId());
        assertEquals(newPart.getPartName(), insertedPart.getPartName());
        assertEquals(newPart.getPartNumber(), insertedPart.getPartNumber());
        assertEquals(newPart.getPartDescription(), insertedPart.getPartDescription());
        assertEquals(newPart.getPartImageFileLocation(), insertedPart.getPartImageFileLocation());
        assertEquals(newPart.getCategory(), insertedPart.getCategory());
    }

    /**
     * Verify successful update of a part
     */
    @Test
    void updateSuccess() {
        String partName = "new part name";
        Part partToUpdate = dao.getById(1);
        partToUpdate.setPartName(partName);
        dao.saveOrUpdate(partToUpdate);
        Part partAfterUpdate = dao.getById(1);
        assertEquals(partToUpdate.getId(), partAfterUpdate.getId());
        assertEquals(partToUpdate.getPartName(), partAfterUpdate.getPartName());
        assertEquals(partToUpdate.getPartNumber(), partAfterUpdate.getPartNumber());
        assertEquals(partToUpdate.getPartDescription(), partAfterUpdate.getPartDescription());
        assertEquals(partToUpdate.getPartImageFileLocation(), partAfterUpdate.getPartImageFileLocation());
        assertEquals(partToUpdate.getCategory(), partAfterUpdate.getCategory());
    }

    /**
     * Verify successful delete of a part
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Verify successful retrieval of all parts
     */
    @Test
    void getAllSuccess() {
        List<Part> parts = dao.getAll();
        assertEquals(3, parts.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Part> parts = dao.getByPropertyEqual("partName", "greatEngine");
        assertEquals(1, parts.size());
        assertEquals(2, parts.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Part> parts = dao.getByPropertyLike("partNumber", "1");
        assertEquals(3, parts.size());
    }
}
