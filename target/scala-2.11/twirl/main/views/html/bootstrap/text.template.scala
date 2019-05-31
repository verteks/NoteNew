
package views.html.bootstrap

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
object text extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Field,String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(field: Field, label:String, placeholder:String, help:String, dataBind: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.81*/("""

"""),format.raw/*3.1*/("""<div class="form-group """),_display_(/*3.25*/if(field.hasErrors)/*3.44*/ {_display_(Seq[Any](format.raw/*3.46*/("""error""")))}),format.raw/*3.52*/("""">
  <label class="control-label" for=""""),_display_(/*4.38*/field/*4.43*/.id),format.raw/*4.46*/(""""><h3>"""),_display_(/*4.53*/label),format.raw/*4.58*/("""</h3></label>
    <input
      class="form-control"
      type="text"
      id=""""),_display_(/*8.12*/field/*8.17*/.id),format.raw/*8.20*/(""""
      name=""""),_display_(/*9.14*/field/*9.19*/.name),format.raw/*9.24*/(""""
      data-bind=""""),_display_(/*10.19*/dataBind),format.raw/*10.27*/(""""
      value=""""),_display_(/*11.15*/field/*11.20*/.value.getOrElse("")),format.raw/*11.40*/(""""
      placeholder=""""),_display_(/*12.21*/placeholder),format.raw/*12.32*/("""" />

    <p class="help-block">"""),_display_(/*14.28*/help),format.raw/*14.32*/("""</p>
    <p class="help-block">"""),_display_(/*15.28*/{field.error.map { error => error.message }}),format.raw/*15.72*/("""</p>
</div>
"""))}
  }

  def render(field:Field,label:String,placeholder:String,help:String,dataBind:String): play.twirl.api.HtmlFormat.Appendable = apply(field,label,placeholder,help,dataBind)

  def f:((Field,String,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (field,label,placeholder,help,dataBind) => apply(field,label,placeholder,help,dataBind)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu May 03 07:26:55 IRKT 2018
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/bootstrap/text.scala.html
                  HASH: d0d988b67d36d21f8166d0f0e4d17d7e21114b67
                  MATRIX: 759->1|926->80|956->84|1006->108|1033->127|1072->129|1108->135|1175->176|1188->181|1211->184|1244->191|1269->196|1380->281|1393->286|1416->289|1458->305|1471->310|1496->315|1544->336|1573->344|1617->361|1631->366|1672->386|1722->409|1754->420|1816->455|1841->459|1901->492|1966->536
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|32->4|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|39->11|39->11|39->11|40->12|40->12|42->14|42->14|43->15|43->15
                  -- GENERATED --
              */
          