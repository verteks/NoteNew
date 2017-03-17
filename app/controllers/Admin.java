package controllers;

import models.*;
import play.data.Form;
import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.mvc.*;
import util.Secured;
import views.html.*;

import javax.persistence.Id;

/**
 * Закрытая часть сайта
 */
@Security.Authenticated(Secured.class)
public class Admin extends Controller {

    /**
     * Возвращает страницу профиля с формой смены пароля.
     *
     * Используются стандартные средства Form[ChangePassword.class] и шаблон profile.scala.html
     *
     * @return страницу профиля с формой смены пароля
     */
    public static Result profile() {
        //todo
        Form<ChangePassword> cpForm = Form.form(ChangePassword.class);
        return ok(profile.render(cpForm));
    }

    /**
     * Обработка формы смены пароля.
     *
     * Валидация проводится стандартными средствами
     * @see ChangePassword#validate()
     * Валидация проверяет соответствие текущего пароля с залогиненным текущим пользователем.
     * Обращаем ваше внимание, что email в форме отсутствует для безопасности и должен браться из сессии.
     *
     * В случае успеха валидации производится изменение пароля пользователя с помощью метода
     * @see User#setPassword(String)
     *
     * @return Страницу профиля. В случае успешной смены пароля выводится success-сообщение. В случае ошибки валидации формы, сообщение об ошибке.
     *
     * Подсказка: Задать success-сообщение можно с помощью
     * flash("success", "Пароль успешно изменен");
     */
    public static Result changePassword() {
        //todo

        Form<ChangePassword> cpForm = Form.form(ChangePassword.class).bindFromRequest();
        if (cpForm.hasErrors())
            return badRequest(profile.render(cpForm));
        else {
            flash("success","Пароль успешно изменен");
            User user = Auth.currentUser();
            user.setPassword(cpForm.get().newPassword);
            user.save();
            Form<ChangePassword> cpForm1 = Form.form(ChangePassword.class);
            return ok(profile.render(cpForm1));
        }

    }
}