package com.hondaparts.persistence;

import com.hondaparts.entity.Category;
import com.hondaparts.entity.Part;
import com.hondaparts.entity.User;
import com.hondaparts.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is for testing the User dao
 *
 * @author Navy Jones
 */
public class UserDaoTest {
    GenericDao<User> dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao<>(User.class);
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(1);
        assertEquals("Bobby", retrievedUser.getFirstName());
        assertEquals("Joe", retrievedUser.getLastName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {
        User newUser = new User("testFirstName", "testLastName", "testUsername", "testEmail@email.com", false);

        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful insert of a saved part
     */
    @Test
    void insertSavedPartSuccess() {
        GenericDao<Part> partDao = new GenericDao<>(Part.class);
        GenericDao<Category> catDao = new GenericDao<>(Category.class);
        Category category = new Category("Brakes");
        User newUser = new User("testFirstName", "testLastName", "testUsername", "testEmail@email.com", false);
        Part part = new Part("testBreakPad", "1234", "best break pad", "images/breakpad.jpg");
        part.setCategory(category);

        int catId = catDao.insert(category);
        int partId = partDao.insert(part);
        int userId = dao.insert(newUser);

        newUser.addPart(part);

        dao.saveOrUpdate(newUser);

        assertNotEquals(0,userId);
        assertNotEquals(0,catId);
        assertNotEquals(0,partId);

        User insertedUser = dao.getById(userId);
        Part insertedPart = partDao.getById(partId);
        Category insertedCat = catDao.getById(catId);

        assertEquals(newUser, insertedUser);
        assertEquals(category, insertedCat);
        assertEquals(part, insertedPart);

        assertEquals(newUser.getParts().size(), insertedUser.getParts().size());
    }

    /**
     * Verify successful update of a user
     */
    @Test
    void updateSuccess() {
        String firstName = "new first name";
        User userToUpdate = dao.getById(1);
        userToUpdate.setFirstName(firstName);
        dao.saveOrUpdate(userToUpdate);
        User userAfterUpdate = dao.getById(1);
        assertEquals(userToUpdate, userAfterUpdate);
    }

    /**
     * Verify successful delete of a user and make sure saved parts are deleted but parts stay in database
     */
    @Test
    void deleteSuccess() {
        GenericDao<Part> partDao = new GenericDao<>(Part.class);
        User user = dao.getById(1);

        dao.delete(user);
        Part part = partDao.getById(1);

        assertNull(dao.getById(1));
        assertNotNull(part);
        assertFalse(part.getUsers().contains(user));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("firstName", "Bobby");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("username", "-");
        assertEquals(3, users.size());
    }
}
