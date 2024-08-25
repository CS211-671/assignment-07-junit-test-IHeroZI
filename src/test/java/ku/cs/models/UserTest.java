package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void init(){
        user = new User("user01", "plain-p@ssw0rd");
    }

    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }

    @Test
    void testIsUsername(){
        assertFalse(user.isUsername("user"));
        assertTrue(user.isUsername("user01"));
    }

    @Test
    void testSetPassword(){
        user.setPassword("Std-60014177");
        assertTrue(user.validatePassword("Std-60014177"));
    }

    @Test
    void testValidatePassword(){
        assertTrue(user.validatePassword("plain-p@ssw0rd"));
    }
}