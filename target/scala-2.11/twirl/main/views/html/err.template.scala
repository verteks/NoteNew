
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object err extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(path: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.16*/("""
"""),_display_(/*2.2*/main("Ошибка")/*2.16*/ {_display_(Seq[Any](format.raw/*2.18*/("""
"""),format.raw/*3.1*/("""<h2>404 Not Found</h2>
<h4>Path not found:</h4>
<p>"""),_display_(/*5.5*/path),format.raw/*5.9*/("""</p>
""")))}),format.raw/*6.2*/("""
"""))}
  }

  def render(path:String): play.twirl.api.HtmlFormat.Appendable = apply(path)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (path) => apply(path)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu May 03 07:26:55 IRKT 2018
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/err.scala.html
                  HASH: ab27f291a4d86d547fb9a9a18af14221aa6c3ddc
                  MATRIX: 721->1|823->15|851->18|873->32|912->34|940->36|1019->90|1042->94|1078->101
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|33->5|33->5|34->6
                  -- GENERATED --
              */
          