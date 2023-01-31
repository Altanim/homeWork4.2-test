import org.example.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static constants.UserTestConstants.*;
import static java.lang.System.out;

public class UserTest {
    @Test
    public void addCorrectUser() {
        User user = new User(CORRECT_LOGIN, CORRECT_MAIL);
        Assertions.assertNotNull(user);
    }
    @Test
    public void addNullUser() {
        User user = new User(CORRECT_LOGIN, CORRECT_MAIL);
        Assertions.assertTrue(Objects.equals(user.getLogin(), CORRECT_LOGIN) &&
                Objects.equals(user.getMail(), CORRECT_MAIL));
        User user1 = new User(EMPTY_LOGIN,CORRECT_MAIL);
        Assertions.assertNotEquals(user,user1);
        User user2 = new User(CORRECT_LOGIN,EMPTY_MAIL);
        Assertions.assertNotEquals(user,user2);
        User user3 = new User(EMPTY_LOGIN,EMPTY_MAIL);
        Assertions.assertNotEquals(user,user3);
    }
    @Test
    public void addOnlySpacesUser() {
        User user = new User(CORRECT_LOGIN, CORRECT_MAIL);
        Assertions.assertTrue(Objects.equals(user.getLogin(), CORRECT_LOGIN) &&
                Objects.equals(user.getMail(), CORRECT_MAIL));
        User user1 = new User(CORRECT_LOGIN,ONLY_SPACES_MAIL);
        Assertions.assertNotEquals(user,user1);
        User user2 = new User(ONLY_SPACES_LOGIN,CORRECT_MAIL);
        Assertions.assertNotEquals(user,user2);
        User user3 = new User(ONLY_SPACES_LOGIN,ONLY_SPACES_MAIL);
        Assertions.assertNotEquals(user,user3);
    }
    @Test
    public void isCorrectMail() {
        User user5 = new User(CORRECT_LOGIN, CORRECT_MAIL);
        Assertions.assertTrue(user5.getMail().contains("@") && user5.getMail().contains("."));
    }
    @Test
    public void loginNotEqualsMail() {
        User user6 = new User(CORRECT_LOGIN, CORRECT_MAIL);
        Assertions.assertNotEquals(user6.getLogin(),user6.getMail());
    }
}
