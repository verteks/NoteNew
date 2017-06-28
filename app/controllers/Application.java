package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.Routes;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

import java.util.List;

import static controllers.Auth.currentUserEmail;
import static play.libs.Json.toJson;

public class Application extends Controller {

    static Form<Note> noteForm = Form.form(Note.class);

	// Главная страница
    public static Result index() {
        if(currentUserEmail() != null) {
            return ok(
                    views.html.index.render(noteForm)
            );
        } else {
            return redirect(controllers.routes.Auth.login());
        }
    }
    
    // Несуществующий путь
    public static Result error(String path) {
    	return ok(err.render(path));
    }



    /**
     * Отдаем базовый шаблон одностраничного приложения
     */
    /*public static Result notes() {
        return ok(
                views.html.index.render(noteForm)
        );
    }*/


    /**
     * Возвращает результат в виде Json с ошибкой, упакованный с соответствующими заголовками.
     *
     * @param errorMessage текст ошибки, передаваемый на клиент
     * @return
     */
    private static Result errorJsonResult(String errorMessage) {
        return badRequest(errorJson(errorMessage));
    }

    /**
     * Возвращает Json с сообщение об ошибке.
     */
    private static JsonNode errorJson(String errorMessage) {
        return Json.newObject().put("error", errorMessage);
    }

    //API для взаимодействия клиентов с сервером посредством JSON

    /**
     * Контроллер возвращает список записей в формате Json
     *
     * @return список записей в формате Json
     */
    public static Result notesJson() {
        //List<Note> all = Note.all();
        List<Note> all = Note.find.where().like("authorEMail", session("email")).findList();
        return ok(toJson(all));  //toJson преобразует объект или список объектов в соответствующий JSON
    }


    //Часть2. Методы, которые нужно реализовать.

    /**
     * Удаляет запись с сервера. Запрос приходит в формате  Json.
     * <p/>
     * Необходимо его распарсить и проверить на корректность, а также обработать ошибки в случае отсутствия в базе данных
     *
     * @return Возвращает удаленную запись в случае, если все ок; возвращает badRequest с ошибкой в случае
     * некорректных параметров; возвращает notFound с ошибкой, если параметры корректны, но в базе данных такой записи нет.
     */
    @BodyParser.Of(BodyParser.Json.class)
    public static Result deleteNoteJson() {
        //журнализация. С помощью метода info можем в журнал внести любую запись.
        play.Logger.info("deleteNoteJson()");
        //парсим запрос в Json
        JsonNode json = request().body().asJson();

        if (json == null) {
            //некорректный запрос, возвращаем ответ с ошибкой. В качестве параметра передаем текст ошибки.
            return errorJsonResult("Json expected");
        } else {
            Long id = null;
            try {
                //получение значение атрибута с именем id и преобразование в Long. Может отсуствовать или быть в другом формате!!!
                id = json.findPath("id").longValue();
            } catch (NumberFormatException nfe) {
                //Не находится в формате числа
                return errorJsonResult("id must be an integer");
            } finally {
                if (id == null) {
                    return errorJsonResult("id must be specified");
                }
            }
            assert(id!=null);

            Note note = Note.findById(id);
            play.Logger.debug(note.toString());
            if (note == null) {
                //Ответ с кодом 404 и телом в виде Json
                return notFound(errorJson("note is not found"));
            }
            //Сохраняем запись note в json для ответа на клиент.
            JsonNode result = Json.toJson(note);
            // удаляем запись
            note.delete();

            //возвращаем в формате JSON результат (используем переменную result)
            return ok(result);
        }
    }

    /**
     * Метод прозводит создание записей в базу данных либо обновление существующей записи.
     *
     * На вход принимается JSON. Если JSON содержит id не нулевой и в нужном формате, то ищем в базе и редактируем.
     * Если же id отсутствует (равно null) или равен 0, то создаем новую запись.
     * Если id число - ищем в базе данных.
     * В случае, если не нашли, выдаем ошибку.
     * В случае если все ок - производим операцию редактирования
     *
     * @return Возвращает созданную или отредактированную запись. В случае некорректных данных возвращает ошибку.
     */
    @BodyParser.Of(BodyParser.Json.class)
    public static Result saveNoteJson() {
        play.Logger.info("saveNoteJson()");

        JsonNode json = request().body().asJson();

        if (json == null) {
            return errorJsonResult("JSON expected");
        } else {

            Long id = null;
            try {
                id = json.findPath("id").longValue();
            } catch (NumberFormatException nfe) {
                return errorJsonResult("id must be an integer");
            } finally {
                if (id == null) {
                    return errorJsonResult("id must be specified");
                }
            }
            Note note = null;
            if (id != 0) {
                note = Note.findById(id);
            }
            if (note == null) {
                note = new Note();
            }


            note.title = json.findPath("title").asText();
            note.message = json.findPath("message").asText();
            note.authorEMail = session("email");

            //сохраняем новый объект или редактируем старый
            play.Logger.info("trying to save to DB");
            note.save();

            return ok(Json.toJson(note));
        }
    }


    /**
     * Контроллер выдает JavaScript файл для поддержки реверсной маршрутизации на клиенте.
     * @return JS скрипт, генерирующий создание объекта jsRoutes для переданного списка контроллеров.
     */
    public static Result jsRoutes() {
        response().setContentType("text/javascript");
        return ok(
                Routes.javascriptRouter("jsRoutes",
                        controllers.routes.javascript.Application.index(),
                        controllers.routes.javascript.Application.notesJson(),
                        controllers.routes.javascript.Application.saveNoteJson(),
                        controllers.routes.javascript.Application.deleteNoteJson()
                )
        );
    }
}
