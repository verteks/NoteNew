// @SOURCE:C:/Users/vshir/Documents/play-2.2.6/NoteNew/conf/routes
// @HASH:50b31fa57de4bce51358184960bdcd58d9151ae0
// @DATE:Thu May 03 07:26:53 IRKT 2018


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Auth_login1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Auth_login1_invoker = createInvoker(
controllers.Auth.login(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "login", Nil,"GET", """""", Routes.prefix + """login"""))
        

// @LINE:8
private[this] lazy val controllers_Auth_signup2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
private[this] lazy val controllers_Auth_signup2_invoker = createInvoker(
controllers.Auth.signup(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "signup", Nil,"GET", """""", Routes.prefix + """register"""))
        

// @LINE:9
private[this] lazy val controllers_Application_index3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("news"))))
private[this] lazy val controllers_Application_index3_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """""", Routes.prefix + """news"""))
        

// @LINE:10
private[this] lazy val controllers_Auth_auth4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Auth_auth4_invoker = createInvoker(
controllers.Auth.auth(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "auth", Nil,"POST", """""", Routes.prefix + """login"""))
        

// @LINE:11
private[this] lazy val controllers_Auth_logout5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_Auth_logout5_invoker = createInvoker(
controllers.Auth.logout(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:12
private[this] lazy val controllers_Auth_register6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
private[this] lazy val controllers_Auth_register6_invoker = createInvoker(
controllers.Auth.register(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "register", Nil,"POST", """""", Routes.prefix + """register"""))
        

// @LINE:13
private[this] lazy val controllers_Admin_changePassword7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("changePassword"))))
private[this] lazy val controllers_Admin_changePassword7_invoker = createInvoker(
controllers.Admin.changePassword(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "changePassword", Nil,"GET", """""", Routes.prefix + """changePassword"""))
        

// @LINE:14
private[this] lazy val controllers_Admin_changePasswordConfirm8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profile/change"))))
private[this] lazy val controllers_Admin_changePasswordConfirm8_invoker = createInvoker(
controllers.Admin.changePasswordConfirm(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "changePasswordConfirm", Nil,"POST", """""", Routes.prefix + """profile/change"""))
        

// @LINE:18
private[this] lazy val controllers_Application_notesJson9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/notes"))))
private[this] lazy val controllers_Application_notesJson9_invoker = createInvoker(
controllers.Application.notesJson(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "notesJson", Nil,"GET", """API""", Routes.prefix + """api/notes"""))
        

// @LINE:19
private[this] lazy val controllers_Application_saveNoteJson10_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/notes"))))
private[this] lazy val controllers_Application_saveNoteJson10_invoker = createInvoker(
controllers.Application.saveNoteJson(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveNoteJson", Nil,"POST", """""", Routes.prefix + """api/notes"""))
        

// @LINE:20
private[this] lazy val controllers_Application_deleteNoteJson11_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/notes"))))
private[this] lazy val controllers_Application_deleteNoteJson11_invoker = createInvoker(
controllers.Application.deleteNoteJson(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteNoteJson", Nil,"DELETE", """""", Routes.prefix + """api/notes"""))
        

// @LINE:22
private[this] lazy val controllers_Application_noteBooksJson12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/notebooks"))))
private[this] lazy val controllers_Application_noteBooksJson12_invoker = createInvoker(
controllers.Application.noteBooksJson(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "noteBooksJson", Nil,"GET", """""", Routes.prefix + """api/notebooks"""))
        

// @LINE:23
private[this] lazy val controllers_Application_saveNoteBookJson13_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/notebooks"))))
private[this] lazy val controllers_Application_saveNoteBookJson13_invoker = createInvoker(
controllers.Application.saveNoteBookJson(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveNoteBookJson", Nil,"POST", """""", Routes.prefix + """api/notebooks"""))
        

// @LINE:24
private[this] lazy val controllers_Application_deleteNoteBookJson14_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/notebooks"))))
private[this] lazy val controllers_Application_deleteNoteBookJson14_invoker = createInvoker(
controllers.Application.deleteNoteBookJson(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteNoteBookJson", Nil,"DELETE", """""", Routes.prefix + """api/notebooks"""))
        

// @LINE:26
private[this] lazy val controllers_Application_jsRoutes15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/jsRoutes"))))
private[this] lazy val controllers_Application_jsRoutes15_invoker = createInvoker(
controllers.Application.jsRoutes,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "jsRoutes", Nil,"GET", """""", Routes.prefix + """api/jsRoutes"""))
        

// @LINE:29
private[this] lazy val controllers_Assets_at16_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at16_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:30
private[this] lazy val controllers_Application_error17_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("path", """.+""",false))))
private[this] lazy val controllers_Application_error17_invoker = createInvoker(
controllers.Application.error(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "error", Seq(classOf[String]),"GET", """""", Routes.prefix + """$path<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Auth.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Auth.signup()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """news""","""controllers.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Auth.auth()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Auth.logout()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Auth.register()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """changePassword""","""controllers.Admin.changePassword()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profile/change""","""controllers.Admin.changePasswordConfirm()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/notes""","""controllers.Application.notesJson()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/notes""","""controllers.Application.saveNoteJson()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/notes""","""controllers.Application.deleteNoteJson()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/notebooks""","""controllers.Application.noteBooksJson()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/notebooks""","""controllers.Application.saveNoteBookJson()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/notebooks""","""controllers.Application.deleteNoteBookJson()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/jsRoutes""","""controllers.Application.jsRoutes"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$path<.+>""","""controllers.Application.error(path:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:7
case controllers_Auth_login1_route(params) => {
   call { 
        controllers_Auth_login1_invoker.call(controllers.Auth.login())
   }
}
        

// @LINE:8
case controllers_Auth_signup2_route(params) => {
   call { 
        controllers_Auth_signup2_invoker.call(controllers.Auth.signup())
   }
}
        

// @LINE:9
case controllers_Application_index3_route(params) => {
   call { 
        controllers_Application_index3_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:10
case controllers_Auth_auth4_route(params) => {
   call { 
        controllers_Auth_auth4_invoker.call(controllers.Auth.auth())
   }
}
        

// @LINE:11
case controllers_Auth_logout5_route(params) => {
   call { 
        controllers_Auth_logout5_invoker.call(controllers.Auth.logout())
   }
}
        

// @LINE:12
case controllers_Auth_register6_route(params) => {
   call { 
        controllers_Auth_register6_invoker.call(controllers.Auth.register())
   }
}
        

// @LINE:13
case controllers_Admin_changePassword7_route(params) => {
   call { 
        controllers_Admin_changePassword7_invoker.call(controllers.Admin.changePassword())
   }
}
        

// @LINE:14
case controllers_Admin_changePasswordConfirm8_route(params) => {
   call { 
        controllers_Admin_changePasswordConfirm8_invoker.call(controllers.Admin.changePasswordConfirm())
   }
}
        

// @LINE:18
case controllers_Application_notesJson9_route(params) => {
   call { 
        controllers_Application_notesJson9_invoker.call(controllers.Application.notesJson())
   }
}
        

// @LINE:19
case controllers_Application_saveNoteJson10_route(params) => {
   call { 
        controllers_Application_saveNoteJson10_invoker.call(controllers.Application.saveNoteJson())
   }
}
        

// @LINE:20
case controllers_Application_deleteNoteJson11_route(params) => {
   call { 
        controllers_Application_deleteNoteJson11_invoker.call(controllers.Application.deleteNoteJson())
   }
}
        

// @LINE:22
case controllers_Application_noteBooksJson12_route(params) => {
   call { 
        controllers_Application_noteBooksJson12_invoker.call(controllers.Application.noteBooksJson())
   }
}
        

// @LINE:23
case controllers_Application_saveNoteBookJson13_route(params) => {
   call { 
        controllers_Application_saveNoteBookJson13_invoker.call(controllers.Application.saveNoteBookJson())
   }
}
        

// @LINE:24
case controllers_Application_deleteNoteBookJson14_route(params) => {
   call { 
        controllers_Application_deleteNoteBookJson14_invoker.call(controllers.Application.deleteNoteBookJson())
   }
}
        

// @LINE:26
case controllers_Application_jsRoutes15_route(params) => {
   call { 
        controllers_Application_jsRoutes15_invoker.call(controllers.Application.jsRoutes)
   }
}
        

// @LINE:29
case controllers_Assets_at16_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at16_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:30
case controllers_Application_error17_route(params) => {
   call(params.fromPath[String]("path", None)) { (path) =>
        controllers_Application_error17_invoker.call(controllers.Application.error(path))
   }
}
        
}

}
     