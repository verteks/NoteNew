import models.Note;
import models.User;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;


/**
 *
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 *
 */
public class TestUnit {

    @Test
    public void registration() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                String email = "example@mail.ru";
               assertThat(User.find.all().size()).isEqualTo(0);
                User us = new User(email, "12345");
                us.save();
                User usFing = User.find.byId(email);
                assertThat(usFing).isNotNull();
            }
        });
    }
    @Test
    public void emailAvailable() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                String email = "example@mail.ru";
                assertThat(User.emailAvailable(email)).isTrue();
                User us = new User(email, "12345");
                us.save();
                User usFing = User.find.byId(email);
                assertThat(User.emailAvailable(email)).isFalse();
            }
        });
    }
    @Test
    public void noteCheck() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                assertThat(Note.find.all().size()).isEqualTo(0);
                Note note = null;
                note.title = "title";
                note.message = "message";
                note.authorEMail ="email";
                note.notebookId =(long) 5;
                note.save();
                assertThat(Note.find.all().size()).isEqualTo(0);
                assertThat(Note.find.byId((long)5)).isNotNull();
                note.delete();
                assertThat(Note.find.all().size()).isEqualTo(0);
            }
        });
    }




}



