
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
object inputField extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Field,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(field: Field, placeholder:String, help:String, dataBind: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.67*/("""

"""),format.raw/*3.1*/("""<div class="form-group """),_display_(/*3.25*/if(field.hasErrors)/*3.44*/ {_display_(Seq[Any](format.raw/*3.46*/("""error""")))}),format.raw/*3.52*/("""">
    <input
    class="form-control"
    type="text"
    id=""""),_display_(/*7.10*/field/*7.15*/.id),format.raw/*7.18*/(""""
    name=""""),_display_(/*8.12*/field/*8.17*/.name),format.raw/*8.22*/(""""
    data-bind=""""),_display_(/*9.17*/dataBind),format.raw/*9.25*/(""""
    value=""""),_display_(/*10.13*/field/*10.18*/.value.getOrElse("")),format.raw/*10.38*/(""""
    placeholder=""""),_display_(/*11.19*/placeholder),format.raw/*11.30*/("""" />

    <p class="help-block">"""),_display_(/*13.28*/help),format.raw/*13.32*/("""</p>
    <p class="help-block">"""),_display_(/*14.28*/{field.error.map { error => error.message }}),format.raw/*14.72*/("""</p>
</div>
"""))}
  }

  def render(field:Field,placeholder:String,help:String,dataBind:String): play.twirl.api.HtmlFormat.Appendable = apply(field,placeholder,help,dataBind)

  def f:((Field,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (field,placeholder,help,dataBind) => apply(field,placeholder,help,dataBind)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu May 03 07:26:55 IRKT 2018
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/bootstrap/inputField.scala.html
                  HASH: 3c621b157be8ca51c12045e1beb1c54d37df57bf
                  MATRIX: 758->1|911->66|941->70|991->94|1018->113|1057->115|1093->121|1187->189|1200->194|1223->197|1263->211|1276->216|1301->221|1346->240|1374->248|1416->263|1430->268|1471->288|1519->309|1551->320|1613->355|1638->359|1698->392|1763->436
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|38->10|38->10|38->10|39->11|39->11|41->13|41->13|42->14|42->14
                  -- GENERATED --
              */
          