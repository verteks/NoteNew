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
    static Form<NoteBook> noteBookForm = Form.form(NoteBook.class);


    public static Result index() {
        if(currentUserEmail() != null) {
            return ok(
                    views.html.index.render(noteForm, noteBookForm)
            );
        } else {
            return redirect(controllers.routes.Auth.login());
        }
    }
    

    public static Result error(String path) {
    	return ok(err.render(path));
    }

    private static Result errorJsonResult(String errorMessage) {
        return badRequest(errorJson(errorMessage));
    }

    private static JsonNode errorJson(String errorMessage) {
        return Json.newObject().put("error", errorMessage);
    }

    public static Result notesJson() {
        //List<Note> all = Note.all();
        List<Note> all = Note.find.where().like("authorEMail", session("email")).findList();
        return ok(toJson(all));
    }

    public static Result noteBooksJson() {
        //List<NoteBook> all = NoteBook.all();
        List<NoteBook> all = NoteBook.find.where().like("authorEMail", session("email")).findList();
        return ok(toJson(all));
    }


    @BodyParser.Of(BodyParser.Json.class)
    public static Result deleteNoteJson() {
        play.Logger.info("deleteNoteJson()");

        JsonNode json = request().body().asJson();

        if (json == null) {
            return errorJsonResult("Json expected");
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
            assert(id!=null);

            Note note = Note.findById(id);
            play.Logger.debug(note.toString());
            if (note == null) {
                return notFound(errorJson("note is not found"));
            }

            JsonNode result = Json.toJson(note);
            note.delete();

            return ok(result);
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result deleteNoteBookJson() {
        play.Logger.info("deleteNoteBookJson()");

        JsonNode json = request().body().asJson();

        if (json == null) {
            return errorJsonResult("Json expected");
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
            assert(id!=null);

            NoteBook notebook = NoteBook.findById(id);
            play.Logger.debug(notebook.toString());
            if (notebook == null) {
                return notFound(errorJson("notebook is not found"));
            }

            JsonNode result = Json.toJson(notebook);
            notebook.delete();

            return ok(result);
        }
    }

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
            note.notebookId = json.findPath("notebookId").asLong();

            play.Logger.info("trying to save to DB");
            note.save();

            return ok(Json.toJson(note));
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result saveNoteBookJson() {
        play.Logger.info("saveNoteBookJson()");

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
            NoteBook notebook = null;
            if (id != 0) {
                notebook = NoteBook.findById(id);
            }
            if (notebook == null) {
                notebook = new NoteBook();
            }


            notebook.title = json.findPath("title").asText();
            notebook.authorEMail = session("email");

            play.Logger.info("trying to save to DB");
            notebook.save();

            return ok(Json.toJson(notebook));
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
                        controllers.routes.javascript.Application.deleteNoteJson(),
                        controllers.routes.javascript.Application.noteBooksJson(),
                        controllers.routes.javascript.Application.saveNoteBookJson(),
                        controllers.routes.javascript.Application.deleteNoteBookJson()
                )
        );
    }
}
