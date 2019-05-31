
function Note(id, title, message, authorEMail, notebookId) {
    var self = this;
    self.title = ko.observable(title);
    self.message = ko.observable(message);
    self.id = id; // не observable поле
    self.authorEMail = ko.observable(authorEMail);
    self.notebookId = ko.observable(notebookId);
}


function NotesViewModel() {
    var self = this;

    self.currentNotebook = 0;
    self.notes = ko.observableArray([]);


    self.id = ko.observable(null);
    self.authorEMail = ko.observable("");
    self.title = ko.observable("");
    self.message = ko.observable("");
    self.notebookId = ko.observable(0);

    self.load = function (nbId) {
        self.currentNotebook = nbId;
        jsRoutes.controllers.Application.notesJson().ajax({
            dataType: 'json',
            success: function (data) {
                console.log("Успешно обработан json запрос. Записи загружены");
                for (i = 0; i < data.length; i++) {
                    if (data[i].notebookId == nbId)
                        self.notes.push(new Note(data[i].id, data[i].title, data[i].message, data[i].authorEMail, data[i].notebookId));
                }
            },
            error: function (data) {
                alert("error! 111" + data.error);
                console.log('error! Не могу отправить json запрос');
                console.log(data);
            }
        });
    };

    self.reload = function (nbId) {
        self.notes.removeAll();
        self.load(nbId);
    };

    self.reloadDefault = function () {
        document.getElementById("notesLabel").textContent = "Notes (Default)";
        self.reload(0);
    }


    self.cleanForm = function () {
        self.id(null);
        self.authorEMail("");
        self.title("");
        self.message("");
    };

    self.editNote = function (note) {
        console.log(note);
        self.id(note.id);
        self.authorEMail(note.authorEMail());
        self.title(note.title());
        self.message(note.message());
        self.notebookId(note.notebookId());
    };

    self.removeNote = function (note) {
        var jsonData = ko.toJSON(note);
        console.log(jsonData);
        jsRoutes.controllers.Application.deleteNoteJson().ajax({
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function () {
                console.log("Успешно обработан ajax запрос. Запись удалена");
                self.notes.remove(note);
            },
            error: function (data) {
                alert("error! " + data.error);
                console.log('error! Не могу отправить json запрос');
                console.log(data);
            }
        });


    };

    self.saveNote = function () {
        var note = new Note;
        note.id = self.id();
        note.authorEMail(self.authorEMail());
        note.title(self.title());
        note.message(self.message());
        note.notebookId(self.currentNotebook);

        var jsonData = ko.toJSON(note); //todo
        console.log(jsonData);

        jsRoutes.controllers.Application.saveNoteJson().ajax({
            dataType: 'json',   //
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function (data) {
                console.log("Успешно обработан ajax запрос. Запись добавлена в DB");
                console.log(data);

                var isNew = true;
                console.log(self.notes());
                for (i = 0; i < self.notes().length; i++) {
                    if(self.notes()[i].id == note.id){
                        console.log(data.id);
                        self.notes()[i].title(data.title);
                        self.notes()[i].message(data.message);
                        self.notes()[i].notebookId(data.notebookId);
                        console.log(self.notes()[i]);
                        isNew = false;
                        break;
                    }
                }
                if(isNew) {
                    if (note.id == null) {note.id=data.id;}
                    self.notes.push(note);
                }
                self.cleanForm();
            },
            error: function (data) {
                alert("error! " + data.error);
                console.log('error! Не могу отправить json запрос');
                console.log(data);
            }
        });
    };

    self.load(0);
}

function NoteBook(id, title, authorEMail) {
    var self = this;
    self.title = ko.observable(title);
    self.id = id;
    self.authorEMail = ko.observable(authorEMail);
}


function NoteBooksViewModel() {
    var self = this;


    self.notebooks = ko.observableArray([]);

    self.id = ko.observable(null);
    self.authorEMail = ko.observable("");
    self.title = ko.observable("");

    self.load1 = function () {
        jsRoutes.controllers.Application.noteBooksJson().ajax({
            dataType: 'json',
            success: function (data) {
                console.log("Успешно обработан json запрос. Записи загружены");
                for (i = 0; i < data.length; i++) {
                    self.notebooks.push(new NoteBook(data[i].id, data[i].title, data[i].authorEMail));
                }
            },
            error: function (data) {
                alert("error! " + data.error);
                console.log('error! Не могу отправить json запрос');
                console.log(data);
            }
        });
    };

    self.reload1 = function () {
        self.notebooks.destroyAll();
        self.load1();
    };

    self.reloadDefault = function() {
        notesViewModel.reloadDefault();
    }

    self.cleanForm1 = function () {
        self.id(null);
        self.authorEMail("");
        self.title("");
    };

    self.editNoteBook = function (notebook) {
        console.log(notebook);
        self.id(notebook.id);
        self.authorEMail(notebook.authorEMail());
        self.title(notebook.title());
    };

    self.removeNoteBook = function (notebook) {
        var jsonData = ko.toJSON(notebook);
        console.log(jsonData);
        jsRoutes.controllers.Application.deleteNoteBookJson().ajax({
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function () {
                console.log("Успешно обработан ajax запрос. Запись удалена");
                self.notebooks.remove(notebook);
            },
            error: function (data) {
                alert("error! " + data.error);
                console.log('error! Не могу отправить json запрос');
                console.log(data);
            }
        });

        if (notesViewModel.currentNotebook == notebook.id) {
            notesViewModel.reloadDefault();
        }

    };

    self.saveNoteBook = function () {
        var notebook = new NoteBook;
        notebook.id = self.id();
        notebook.authorEMail(self.authorEMail());
        notebook.title(self.title());

        var jsonData = ko.toJSON(notebook);
        console.log(jsonData);

        jsRoutes.controllers.Application.saveNoteBookJson().ajax({
            dataType: 'json',   //
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function (data) {
                console.log("Успешно обработан ajax запрос. Запись добавлена в DB");
                console.log(data);

                var isNew = false;
                if(notebook.id == null){isNew = true;}
                if (isNew) { /*создание нового */
                    notebook.id=data.id;
                    self.notebooks.push(notebook);
                } else {
                    console.log(self.notebooks());
                    for (i = 0; i < self.notebooks().length; i++) {
                        if(self.notebooks()[i].id == notebook.id){
                            console.log(data.id);
                            self.notebooks()[i].title(data.title);
                            console.log(self.notebooks()[i]);
                            break;
                        }
                    }
                }
                self.cleanForm1();
            }
        });
    };

    self.selectNoteBook = function (notebook) {
        var title = notebook.title();
        console.log(title);
        document.getElementById("notesLabel").textContent = "Notes (" + title + ")";
        notesViewModel.reload(notebook.id);
    };

    self.load1();
}

var notebooksViewModel = new NoteBooksViewModel();
ko.applyBindings(notebooksViewModel, document.getElementById('notebooksDiv'));

var notesViewModel = new NotesViewModel();
ko.applyBindings(notesViewModel, document.getElementById('notesDiv'));

