package registration.form;

import javax.swing.JOptionPane;

/**
 *
 * @author saihilgurupersad
 */
class UserForm {
    
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    
   
    
    public UserForm(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    public UserForm(String username, String password){
       this.username= username;
       this.password=password;
    }

    public String getFirstName() {
        
                
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


