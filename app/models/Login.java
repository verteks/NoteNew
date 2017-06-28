package models;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;


public class Login {
    @Email(message = "Incorrect E-Mail")
    @Required(message = "E-Mail required")
    public String email;

    @Required(message = "Password required")
    public String password;


    public String validate() {
        //todo
        return   User.authenticate(email, password);
    }
}
