package registration.form;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
//Assertation.assertEquals;
//Assertion.assertFalse;
//Assertion.assertTrue;

/**
 *
 * @author saihilgurupersad
 */
public class LoginForm2Test {
    LoginForm2 login = new LoginForm2();
    public LoginForm2Test() {
    }

    @Test
    public void testCheckUserNameCorrectlyFormatted() {
        boolean actual = login.checkUserName("kyl_1");
        assertTrue(actual);
    }
    
    @Test
    public void testUsernamePoorlyFormatted(){
        boolean actual = login.checkUserName("kyle!!!!!");
        assertFalse(actual);
    }

    @Test
    public void testCheckPasswordComplexitySuccess() {
        boolean actual=login.checkPasswordComplexity("#Saihil7");
        assertTrue(actual);
    }
    
    @Test
    public void testCheckPasswordComplexityFailure() {
        boolean actual=login.checkPasswordComplexity("password");
        assertFalse(actual);
    }

    @Test
    public void testRegisterUser() {
    }

    @Test
    public void testLoginUser() {
    }

    @Test
    public void testReturnLoginStatus() {
        
    }

    @Test
    public void testMain() {
    }
    
}
