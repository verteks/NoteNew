package models;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;



public class Register{

    @Email(message = "Incorrect E-Mail")
    @Required(message = "E-Mail Required")
    public String email;

    @Required(message = "Password Required")
    public String password;


    public String validate() {
        return User.emailAvailable(email) ? null : "Account with this E-Mail already exists";
    }
}
