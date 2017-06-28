package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class NoteBook extends Model {
    @Id
    public Long id;
    @Required
    public String title;
    public String authorEMail;

    public static Model.Finder<Long, NoteBook> find = new Model.Finder<Long, NoteBook>(
            Long.class, NoteBook.class
    );

    public static NoteBook findById(long id){
        return find.ref(id);
    }


    public static List<NoteBook> all() {
        return find.all();
    }

    @Deprecated
    public static void edit(NoteBook notebook, Long id) {
        notebook.update(id);
    }
}
