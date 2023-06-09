package registration.form;
import javax.swing.JOptionPane;
/**
 * 
 * @author saihilgurupersad
 */
public class RegistrationForm2 {

    public static void main(String[] args) {

        String choice = JOptionPane.showInputDialog(null, "Do you want to register or login? 1 for register, 2 for login");

        if (choice.equals("1")) {
            String firstName = JOptionPane.showInputDialog(null, "Enter first name:");
            String lastName = JOptionPane.showInputDialog(null, "Enter last name:");
            String username;
            String password;

            do {
                username = JOptionPane.showInputDialog("Enter username for registration");
                if (username == null) { // user clicked cancel or closed the input dialog
                    JOptionPane.showMessageDialog(null, "No username entered.");
                    return;
                }
                if (username.length() != 5 || !username.contains("_")) {
                    JOptionPane.showMessageDialog(null, "Invalid username. Must be 5 characters long and contain an underscore.");
                } else {
                    JOptionPane.showMessageDialog(null, "Username successfully captured");
                    break;
                }
            } while (true);

            do {
                password = JOptionPane.showInputDialog("Enter a password for registration:\n"
                        + "- Note: password must be 8 characters long\n"
                        + "- Must contain a number\n"
                        + "- Must contain 1 Capital letter\n"
                        + "- Must contain 1 special character");

                if (password == null) { // user clicked cancel or closed the input dialog
                    JOptionPane.showMessageDialog(null, "No password entered.");
                    return;
                }

                if (password.length() < 8) {
                    JOptionPane.showMessageDialog(null, "Password is too short. Must be at least 8 characters long.");
                } else if (!password.matches(".*[A-Z].*")) {
                    JOptionPane.showMessageDialog(null, "Password must contain at least one capital letter.");
                } else if (!password.matches(".*\\d.*")) {
                    JOptionPane.showMessageDialog(null, "Password must contain at least one number.");
                } else if (!password.matches(".*[!@#$%^&()].*")) {
                    JOptionPane.showMessageDialog(null, "Password must contain at least one special character.");
                } else {
                    JOptionPane.showMessageDialog(null, "Password captured successfully.");
                    break;
                }
            } while (true);

            JOptionPane.showMessageDialog(null, "Registration successful!");
        } else if (choice.equals("2")) {
            LoginForm2 login = new LoginForm2();
            JOptionPane.showMessageDialog(null, login.registerUser("myusername", "mypassword"));
            JOptionPane.showMessageDialog(null, login.loginUser("myusername", "mypassword"));
            JOptionPane.showMessageDialog(null, login.returnLoginStatus());

            login.checkUserName(choice);
            login.checkPasswordComplexity(choice);
            login.registerUser(choice, choice);
            login.loginUser(choice, choice);
            login.returnLoginStatus();

            Task work = new Task();
            Task.main(args);
        }
    }
}
