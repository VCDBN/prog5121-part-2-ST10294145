package registration.form;
import javax.swing.JOptionPane;
/**
 *
 * @author saihilgurupersad
 */
public class LoginForm2 {
    
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private boolean isLoggedIn;
    UserForm u = new UserForm(firstname,lastname,username, password);
    

    public LoginForm2() {
        isLoggedIn = false;
    }

    public boolean checkUserName(String username) {
        String showInputDialog = JOptionPane.showInputDialog("Enter username: ");
        // Check if the username meets certain criteria (e.g. length, special characters, etc.)
        // Return true if the username is valid, false otherwise
        
        return username.length()<5&&username.contains("_"); // Placeholder value
    }

    public boolean checkPasswordComplexity(String password) {
        String showInputDialog = JOptionPane.showInputDialog("Enter password: ");
        // Check if the password meets certain criteria (e.g. length, complexity, etc.)
        // Return true if the password is complex enough, false otherwise
        this.password=password;
         return password.length()<8&&password.matches(".*[A-Z].*")&&password.matches(".*\\d.*")&&password.matches(".*[!@#$%^&()].*"); // Placeholder value
    }

    public String registerUser(String username, String password) {
        if (!checkUserName(username) && !checkPasswordComplexity(password)) {
            this.username = username;
            this.password = password;
            return "The two above conditions have been met and the user has been registered successfully.";
        } else {
            return "Invalid username or password. Please try again.";
        }
    }

    public boolean loginUser(String username, String password) {
        if (username.equals(this.username) && password.equals(this.password)) {
            isLoggedIn = true;
            return true;
        } else {
            isLoggedIn = false;
            return false;
        }
    }

    public String returnLoginStatus() {
        if (isLoggedIn) {
            return "Login successful.";
        } else {
            return "Login unsuccessful.";
        }
    }

    public static void main(String[] args) {
        LoginForm2 login = new LoginForm2();
        JOptionPane.showMessageDialog(null,login.registerUser("myusername", "mypassword"));
        JOptionPane.showMessageDialog(null,login.loginUser("myusername", "mypassword"));
        JOptionPane.showMessageDialog(null,login.returnLoginStatus());
        
     
        
    }
}

    

