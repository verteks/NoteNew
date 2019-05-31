
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
object textArea extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Field,String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(field: Field, label:String, placeholder:String, help:String, dataBind: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.81*/("""

"""),format.raw/*3.1*/("""<div class="form-group """),_display_(/*3.25*/if(field.hasErrors)/*3.44*/ {_display_(Seq[Any](format.raw/*3.46*/("""error""")))}),format.raw/*3.52*/("""">
    <label class="control-label" for=""""),_display_(/*4.40*/field/*4.45*/.id),format.raw/*4.48*/(""""><h3>"""),_display_(/*4.55*/label),format.raw/*4.60*/("""</h3></label>
    <textarea
    class="form-control"
    type="text"
    id=""""),_display_(/*8.10*/field/*8.15*/.id),format.raw/*8.18*/(""""
    name=""""),_display_(/*9.12*/field/*9.17*/.name),format.raw/*9.22*/(""""
    data-bind=""""),_display_(/*10.17*/dataBind),format.raw/*10.25*/(""""
    value=""""),_display_(/*11.13*/field/*11.18*/.value.getOrElse("")),format.raw/*11.38*/(""""
    placeholder=""""),_display_(/*12.19*/placeholder),format.raw/*12.30*/(""""
    rows = 20
    ></textarea>

    <p class="help-block">"""),_display_(/*16.28*/help),format.raw/*16.32*/("""</p>
    <p class="help-block">"""),_display_(/*17.28*/{field.error.map { error => error.message }}),format.raw/*17.72*/("""</p>
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
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/bootstrap/textArea.scala.html
                  HASH: c41ebd54cb92324d2342e2718cafe68a0f0e24d7
                  MATRIX: 763->1|930->80|960->84|1010->108|1037->127|1076->129|1112->135|1181->178|1194->183|1217->186|1250->193|1275->198|1383->280|1396->285|1419->288|1459->302|1472->307|1497->312|1543->331|1572->339|1614->354|1628->359|1669->379|1717->400|1749->411|1841->476|1866->480|1926->513|1991->557
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|32->4|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|39->11|39->11|39->11|40->12|40->12|44->16|44->16|45->17|45->17
                  -- GENERATED --
              */
          