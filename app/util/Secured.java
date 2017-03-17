package util;

import controllers.routes;
import models.Login;
import play.data.Form;
import play.mvc.*;
import play.mvc.Http.Context;
import views.html.login;

public class Secured extends Security.Authenticator {

    /**
     * Механизм аутентификации
     *
     * @param ctx контекст запроса.
     * @return строку-email для текущего пользователя, хранящуюся в сессии при аутентификации. В случае ее отсутствия возвращает null
     */
    @Override
    public String getUsername(Context ctx) {
        Http.Session session = ctx.session();
        //todo вернуть ключ "email" из сессии
        return session.get("email");
    }

    /**
     * Перенаправление в случае неуспеха аутентификации. Как правило перенаправляет на форму логина
     *
     * @param ctx контекст
     * @return перенаправление на страницу логина
     */
    @Override
    public Result onUnauthorized(Context ctx) {
        //todo
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        return ok(login.render(loginForm));
    }

}