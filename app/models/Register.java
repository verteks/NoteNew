package models;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;

/**
 * Данный класс необходим для обработки формы регистрации.
 * Используется для валидации двух типов.
 *
 * 1. В качестве валидации отдельных полей используются аннотации
 * @Email - строка соответствует адресу эл. почты
 * @Required - обязательное поле.
 *
 * Для задания осмысленного сообщения при наарушении данного ограничения,
 * используется параметр message.
 * @Email(message = "Некорректный адрес электронной почты")
 *
 *
 * 2. Валидация на уровне формы с помощью метода String validate()
 * Когда нет возможности ограничиться валидацией полей по отдельности,
 * например когда условие валидации зависит от соответствия значений нескольких полей,
 *
 * Валидация форма регистрации проходит тогда, когда пользователь с данным email еще не зарегистрирован
 *
 */

public class Register{

    //todo обязательное поле с подписью, эл. почта
    @Email(message = "Incorrect E-Mail")
    @Required(message = "E-Mail Required")
    public String email;

    //todo обязательное поле с подписью
    @Required(message = "Password Required")
    public String password;

    /**
     * Производит валидацию формы.
     *
     * Подсказка: Воспользоваться методом User.emailAvailable(email)
     *
     * @return null в случае, если валидация успешна. Строку с ошибкой в противном случае.
     */
    public String validate() {
        //todo
        return User.emailAvailable(email) ? null : "Account with this E-Mail already exists";
    }
}
