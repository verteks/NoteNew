// @SOURCE:C:/Users/vshir/Documents/play-2.2.6/NoteNew/conf/routes
// @HASH:50b31fa57de4bce51358184960bdcd58d9151ae0
// @DATE:Thu May 03 07:26:53 IRKT 2018

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:30
// @LINE:29
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
class ReverseAuth {


// @LINE:10
def auth(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                        

// @LINE:8
def signup(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "register")
}
                        

// @LINE:11
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:12
def register(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "register")
}
                        

// @LINE:7
def login(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                        

}
                          

// @LINE:14
// @LINE:13
class ReverseAdmin {


// @LINE:13
def changePassword(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "changePassword")
}
                        

// @LINE:14
def changePasswordConfirm(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "profile/change")
}
                        

}
                          

// @LINE:29
class ReverseAssets {


// @LINE:29
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:30
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:9
// @LINE:6
class ReverseApplication {


// @LINE:22
def noteBooksJson(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api/notebooks")
}
                        

// @LINE:20
def deleteNoteJson(): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "api/notes")
}
                        

// @LINE:30
def error(path:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("path", path))
}
                        

// @LINE:19
def saveNoteJson(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "api/notes")
}
                        

// @LINE:26
def jsRoutes(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api/jsRoutes")
}
                        

// @LINE:24
def deleteNoteBookJson(): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "api/notebooks")
}
                        

// @LINE:23
def saveNoteBookJson(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "api/notebooks")
}
                        

// @LINE:18
def notesJson(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api/notes")
}
                        

// @LINE:9
// @LINE:6
def index(): Call = {
   () match {
// @LINE:6
case ()  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix)
                                         
   }
}
                                                

}
                          
}
                  


// @LINE:30
// @LINE:29
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
class ReverseAuth {


// @LINE:10
def auth : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.auth",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:8
def signup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.signup",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

// @LINE:11
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:12
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.register",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

// @LINE:7
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

}
              

// @LINE:14
// @LINE:13
class ReverseAdmin {


// @LINE:13
def changePassword : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.changePassword",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "changePassword"})
      }
   """
)
                        

// @LINE:14
def changePasswordConfirm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.changePasswordConfirm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "profile/change"})
      }
   """
)
                        

}
              

// @LINE:29
class ReverseAssets {


// @LINE:29
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:30
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:9
// @LINE:6
class ReverseApplication {


// @LINE:22
def noteBooksJson : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.noteBooksJson",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/notebooks"})
      }
   """
)
                        

// @LINE:20
def deleteNoteJson : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteNoteJson",
   """
      function() {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/notes"})
      }
   """
)
                        

// @LINE:30
def error : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.error",
   """
      function(path) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("path", path)})
      }
   """
)
                        

// @LINE:19
def saveNoteJson : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.saveNoteJson",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/notes"})
      }
   """
)
                        

// @LINE:26
def jsRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.jsRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/jsRoutes"})
      }
   """
)
                        

// @LINE:24
def deleteNoteBookJson : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteNoteBookJson",
   """
      function() {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/notebooks"})
      }
   """
)
                        

// @LINE:23
def saveNoteBookJson : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.saveNoteBookJson",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/notebooks"})
      }
   """
)
                        

// @LINE:18
def notesJson : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.notesJson",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/notes"})
      }
   """
)
                        

// @LINE:9
// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "news"})
      }
      }
   """
)
                        

}
              
}
        


// @LINE:30
// @LINE:29
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
class ReverseAuth {


// @LINE:10
def auth(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.auth(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "auth", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:8
def signup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.signup(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "signup", Seq(), "GET", """""", _prefix + """register""")
)
                      

// @LINE:11
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.logout(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:12
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.register(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "register", Seq(), "POST", """""", _prefix + """register""")
)
                      

// @LINE:7
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      

}
                          

// @LINE:14
// @LINE:13
class ReverseAdmin {


// @LINE:13
def changePassword(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.changePassword(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "changePassword", Seq(), "GET", """""", _prefix + """changePassword""")
)
                      

// @LINE:14
def changePasswordConfirm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.changePasswordConfirm(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "changePasswordConfirm", Seq(), "POST", """""", _prefix + """profile/change""")
)
                      

}
                          

// @LINE:29
class ReverseAssets {


// @LINE:29
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:30
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:9
// @LINE:6
class ReverseApplication {


// @LINE:22
def noteBooksJson(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.noteBooksJson(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "noteBooksJson", Seq(), "GET", """""", _prefix + """api/notebooks""")
)
                      

// @LINE:20
def deleteNoteJson(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteNoteJson(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteNoteJson", Seq(), "DELETE", """""", _prefix + """api/notes""")
)
                      

// @LINE:30
def error(path:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.error(path), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "error", Seq(classOf[String]), "GET", """""", _prefix + """$path<.+>""")
)
                      

// @LINE:19
def saveNoteJson(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.saveNoteJson(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveNoteJson", Seq(), "POST", """""", _prefix + """api/notes""")
)
                      

// @LINE:26
def jsRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.jsRoutes(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "jsRoutes", Seq(), "GET", """""", _prefix + """api/jsRoutes""")
)
                      

// @LINE:24
def deleteNoteBookJson(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteNoteBookJson(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteNoteBookJson", Seq(), "DELETE", """""", _prefix + """api/notebooks""")
)
                      

// @LINE:23
def saveNoteBookJson(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.saveNoteBookJson(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveNoteBookJson", Seq(), "POST", """""", _prefix + """api/notebooks""")
)
                      

// @LINE:18
def notesJson(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.notesJson(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "notesJson", Seq(), "GET", """API""", _prefix + """api/notes""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        
    