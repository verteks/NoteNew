//Model паттерна MVVM - класс модели для записи, включая три поля и скрытое поле id - полный аналог из модели DB
function NoteBook(id, title, authorEMail) {
    var self = this;
    self.title = ko.observable(title);
    self.id = id; // не observable поле
    self.authorEMail = ko.observable(authorEMail);
}

//ViewModel паттерна MVVM, бизнес-логика
function NoteBooksViewModel() {
    var self = this;

    // Список записей
    self.notebooks = ko.observableArray([]); //todo сделать observable

    // Поля формы
    //todo сделать поля observable
    self.id = ko.observable(null);
    self.authorEMail = ko.observable("");
    self.title = ko.observable("");

    // Операции

    /*
     Загрузка записей посредством AJAX запроса и получение ответа в формате JSON
     Эта функция реализована за вас в качестве примера
     */
    self.load1 = function () {

        /*
         jsRoutes.controllers.Application.notesJson().ajax({}) - вызывает контроллер Application.notesJson
         посредством асинхронного запроса.
         С другими контроллерами аналогично.

         Параметры:
         dataType : 'json',  // тип данных, которые ожидаем получить от сервера. В данном примере работаем с JSON
         contentType : 'application/json; charset=utf-8', //тип передаваемого на сервер контента, в данном случае JSON в кодировке UTF
         data : jsonData, // данные передаваемые на сервер в качестве тела/параметров запроса. Здесь значение переменной jsonData

         Результатом выполнения может быть либо успех, либо ошибка. для этого
         передаются функции success и error. Они принимают на вход аргумент data - данные, полученные от сервера.

         */
        jsRoutes.controllers.Application.noteBooksJson().ajax({
            dataType: 'json',  // ожидаем JSON
            //поскольку хотим получить все записи, других параметров не передаем
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

    /**
     *     Функция перезагрузки списка записей. Удаляются все записи и затем происходит загрузка
     *     ВНИМАНИЕ!!! Данный прием (reload) нельзя использовать для обработки события добавления/изменения/удаления записи
     */
    self.reload1 = function () {
        self.notebooks.destroyAll(); //при удалении работаем с самим объектом notes вместо notes()
        self.load1();
    };

    /*
     Функция очистки полей формы. Работает локально на клиенте
     */
    self.cleanForm1 = function () {
        self.id(null);
        self.authorEMail("");
        self.title("");
    };

    /*
     Функция обработки события при нажатии на кнопку редактировать. Подгружает соответствующую запись в форму для редактирования
     Работает локально на клиенте.
     */
    self.editNoteBook = function (notebook) {
        console.log(notebook);
        self.id(notebook.id);
        self.authorEMail(notebook.authorEMail());
        self.title(notebook.title());
    };

    /**
     * Функция обработки события удаления записи. Производит AJAX запрос к серверу на удаление.
     * В случае успеха удаляет объект из списка notes
     *
     * @param note - запись, объект модели
     *
     * Подсказка: Обращаю внимание, что при удалении элементов работаем с notes.remove вместо notes().remove
     */
    self.removeNoteBook = function (notebook) {
        var jsonData = ko.toJSON(notebook);
        console.log(jsonData);
        //запрашиваем сервер
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
            //todo обработка ошибок от сервера
        });


    };

    /*
     Функция сохранения формы. Записи, содержащейся в форме. И для редактирования и для добавления новой записи.
     */
    self.saveNoteBook = function () {
        //Получаем объект Note из observable полей формы
        var notebook = new NoteBook; //todo, использовать self.id() и др.
        notebook.id = self.id();
        notebook.authorEMail(self.authorEMail());
        notebook.title(self.title());

        //Преобразовываем в json-строку с помощью функции ko.toJSON
        var jsonData = ko.toJSON(notebook); //todo
        console.log(jsonData);

        //уведомляем сервер  с помощью JavaScript объекта, позволяющего осуществить AJAX к контролеру
        jsRoutes.controllers.Application.saveNoteBookJson().ajax({
            dataType: 'json',   //
            contentType: 'application/json; charset=utf-8',
            data: jsonData,
            success: function (data) {
                console.log("Успешно обработан ajax запрос. Запись добавлена в DB");
                console.log(data);

                //обновляем данные локально
                var isNew = false; //todo флаг, является ли данная запись в форме - новой записью. Если редактируемая - выдает false
                if(notebook.id == null){isNew = true;}
                if (isNew) { /*создание нового */
                    notebook.id=data.id;
                    self.notebooks.push(notebook);
                    //todo добавляем в массив записей. Не забываем передать объекту полученный от сервера id
                } else {
                    //todo редактирование - ищем и обновляем
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
                //обновляем (очищаем) форму
                self.cleanForm1();
            }
            //todo обработка ошибок от сервера
        });
    };


    //вызов первоначальной загрузки данных от сервера.
    self.load1();
}

//создаем экземпляр ViewModel
//создаем экземпляр ViewModel
var notebooksViewModel = new NoteBooksViewModel();
ko.applyBindings(notebooksViewModel);


