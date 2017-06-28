package util;

import controllers.routes;
import models.Login;
import play.data.Form;
import play.mvc.*;
import play.mvc.Http.Context;
import views.html.login;

public class Secured extends Security.Authenticator {


    @Override
    public String getUsername(Context ctx) {
        Http.Session session = ctx.session();
        return session.get("email");
    }


    @Override
    public Result onUnauthorized(Context ctx) {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        return ok(login.render(loginForm));
    }

}