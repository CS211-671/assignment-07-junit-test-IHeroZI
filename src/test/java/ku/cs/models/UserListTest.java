package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    UserList users;

    @BeforeEach
    void init(){
        users = new UserList();
        users.addUser("user01", "password01");
        users.addUser("user02", "password02");
        users.addUser("user03", "password03");
    }

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        User find = users.findUserByUsername("user01");
        assertNotNull(find);

        find = users.findUserByUsername("user02");
        assertNotNull(find);

        find = users.findUserByUsername("user03");
        assertNotNull(find);

        find = users.findUserByUsername("user04");
        assertNull(find);
        // TODO: add 3 users to UserList

        // TODO: find one of them

        // TODO: assert that UserList found User
        // String expected = "<one of username>";
        // String actual = user.getUsername();
        // assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        User find = users.findUserByUsername("user02");
        assertTrue(find.validatePassword("password02"));
        users.changePassword("user02", "password02", "user022");
        assertTrue(find.validatePassword("user022"));
        // TODO: add 3 users to UserList

        // TODO: change password of one user

        // TODO: assert that user can change password
        // assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        User test = users.login("user01", "password01");
        assertNotNull(test);
        // TODO: add 3 users to UserList

        // TODO: call login() with correct username and password

        // TODO: assert that User object is found
        // assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        User test = users.login("user01", "password04");
        assertNull(test);
        // TODO: add 3 users to UserList

        // TODO: call login() with incorrect username or incorrect password

        // TODO: assert that the method return null
        // assertNull(actual);
    }

}