package controllers;

import models.*;
import play.data.Form;
import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.mvc.*;
import util.Secured;
import views.html.*;

import javax.persistence.Id;


@Security.Authenticated(Secured.class)
public class Admin extends Controller {


    public static Result changePassword() {

        Form<ChangePassword> cpForm = Form.form(ChangePassword.class);
        return ok(changePassword.render(cpForm));
    }

    public static Result changePasswordConfirm() {


        Form<ChangePassword> cpForm = Form.form(ChangePassword.class).bindFromRequest();
        if (cpForm.hasErrors())
            return badRequest(changePassword.render(cpForm));
        else {
            flash("success","Password Successfully Changed!");
            User user = Auth.currentUser();
            user.setPassword(cpForm.get().newPassword);
            user.save();
            Form<ChangePassword> cpForm1 = Form.form(ChangePassword.class);
            return ok(changePassword.render(cpForm1));
        }

    }
}