
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
object mainForForms extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.32*/("""
"""),_display_(/*2.2*/main(title)/*2.13*/{_display_(Seq[Any](format.raw/*2.14*/("""
    """),format.raw/*3.5*/("""<div class="container">
        """),_display_(/*4.10*/content),format.raw/*4.17*/("""
    """),format.raw/*5.5*/("""</div>
""")))}))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu May 03 07:26:55 IRKT 2018
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/mainForForms.scala.html
                  HASH: 9051746d20d27ed4ff5a4271966714d3a8c4c8e6
                  MATRIX: 735->1|853->31|881->34|900->45|938->46|970->52|1030->86|1057->93|1089->99
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|32->4|32->4|33->5
                  -- GENERATED --
              */
          