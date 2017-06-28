package models;

import controllers.Auth;
import play.data.validation.Constraints.*;


public class ChangePassword{
    @Required(message = "Wrong Password")
    public String password;

    @Required(message = "Incorrect Password")
    public String newPassword;


    public String validate() {
        //todo
        String email =  Auth.currentUserEmail();
        //User user = Auth.currentUser();
        return User.authenticate(email, password);
    }
}
