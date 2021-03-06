package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Note extends Model {

    @Id
    public Long id;
    public Long notebookId;
    @Required
    public String title;
    public String authorEMail;
    public String message;

    public static Finder<Long, Note> find = new Finder<Long, Note>(
            Long.class, Note.class
    );

    public static Note findById(long id){
        return find.ref(id);
    }


    public static List<Note> all() {
        return find.all();
    }

    @Deprecated
    public static void edit(Note note, Long id) {
        note.update(id);
    }

}