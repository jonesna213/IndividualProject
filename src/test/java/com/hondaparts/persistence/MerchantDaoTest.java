package com.hondaparts.persistence;

import com.hondaparts.entity.Category;
import com.hondaparts.entity.Merchant;
import com.hondaparts.entity.Part;
import com.hondaparts.entity.User;
import com.hondaparts.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is for testing the Merchant dao
 *
 * @author Navy Jones
 */
public class MerchantDaoTest {
    GenericDao<Merchant> dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao<>(Merchant.class);
    }

    /**
     * Verify successful retrieval of a merchant
     */
    @Test
    void getByIdSuccess() {
        Merchant retrievedMerchant = dao.getById(1);
        assertEquals("TestMerchant", retrievedMerchant.getName());
    }

    /**
     * Verify successful insert of a merchant
     */
    @Test
    void insertSuccess() {
        Merchant newMerchant = new Merchant("AnotherTestMerchant", "notARealFile", "notAWebsite.com");

        int id = dao.insert(newMerchant);
        assertNotEquals(0,id);
        Merchant insertedMerchant = dao.getById(id);
        assertEquals(newMerchant, insertedMerchant);
    }

    /**
     * Verify successful update of a merchant
     */
    @Test
    void updateSuccess() {
        String name = "new name";
        Merchant merchantToUpdate = dao.getById(1);
        merchantToUpdate.setName(name);
        dao.saveOrUpdate(merchantToUpdate);
        Merchant merchantAfterUpdate = dao.getById(1);
        assertEquals(merchantToUpdate, merchantAfterUpdate);
    }

    /**
     * Verify successful delete of a merchant
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Verify successful retrieval of all merchants
     */
    @Test
    void getAllSuccess() {
        List<Merchant> merchants = dao.getAll();
        assertEquals(3, merchants.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Merchant> merchants = dao.getByPropertyEqual("name", "TestMerchant");
        assertEquals(1, merchants.size());
        assertEquals(1, merchants.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Merchant> merchants = dao.getByPropertyLike("website", "com");
        assertEquals(3, merchants.size());
    }
}
