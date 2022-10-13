package com.hondaparts.persistence;

import com.hondaparts.entity.Category;
import com.hondaparts.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is for testing the Category dao
 *
 * @author Navy Jones
 */
public class CategoryDaoTest {
    GenericDao<Category> dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao<>(Category.class);
    }

    /**
     * Verify successful retrieval of a category
     */
    @Test
    void getByIdSuccess() {
        Category retrievedCategory = dao.getById(1);
        assertEquals("Exhaust", retrievedCategory.getCategory());
    }

    /**
     * Verify successful insert of a category
     */
    @Test
    void insertSuccess() {
        Category newCategory = new Category("Suspension");

        int id = dao.insert(newCategory);
        assertNotEquals(0,id);
        Category insertedCategory = dao.getById(id);
        assertEquals(newCategory, insertedCategory);
    }

    /**
     * Verify successful update of a category
     */
    @Test
    void updateSuccess() {
        String category = "new category name";
        Category categoryToUpdate = dao.getById(1);
        categoryToUpdate.setCategory(category);
        dao.saveOrUpdate(categoryToUpdate);
        Category categoryAfterUpdate = dao.getById(1);
        assertEquals(categoryToUpdate, categoryAfterUpdate);
    }

    /**
     * Verify successful delete of a category
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Verify successful retrieval of all categories
     */
    @Test
    void getAllSuccess() {
        List<Category> categories = dao.getAll();
        assertEquals(3, categories.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Category> categories = dao.getByPropertyEqual("category", "Exhaust");
        assertEquals(1, categories.size());
        assertEquals(1, categories.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Category> categories = dao.getByPropertyLike("category", "i");
        assertEquals(2, categories.size());
    }
}
