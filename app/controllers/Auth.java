package controllers;

import models.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Auth extends Controller {


    public static Result login() {
        if(session(currentUserEmail())==null) {
            Form<Login> loginForm = Form.form(Login.class);
            return ok(login.render(loginForm));
        }

        return redirect(routes.Application.index());
    }


    public static Result auth() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        if (loginForm.hasErrors())
            return badRequest(login.render(loginForm));
        else {
            session("email", loginForm.get().email);
            return redirect(routes.Application.index());
        }
    }


    public static Result logout() {
        session().clear();
        return redirect(routes.Application.index());
    }


    public static Result signup() {
        if(session(currentUserEmail())!=null){
            return redirect(routes.Application.index());
        }
        Form<Register> registerForm = Form.form(Register.class);
        return ok(register.render(registerForm));
    }



    public static Result register() {
        Form<Register> rForm = Form.form(Register.class).bindFromRequest();
        if (rForm.hasErrors())
            return badRequest(register.render(rForm));
        else {
            User user = new User(rForm.get().email,rForm.get().password);
            user.save();
            session("email", rForm.get().email);
            return redirect(routes.Application.index());
        }
    }

    public static String currentUserEmail() {
        return session("email");
    }

    public static User currentUser(){
        return User.find.byId(currentUserEmail());
    }
}
