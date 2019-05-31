
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
object input extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Field,String,Array[scala.Tuple2[Symbol, Any]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(field: Field, label: String, args: (Symbol,Any)*):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*2.1*/("""<div class="form-group"""),_display_(/*2.24*/if(field.hasErrors )/*2.44*/ {_display_(Seq[Any](format.raw/*2.46*/(""" """),format.raw/*2.47*/("""has-error""")))}),format.raw/*2.57*/("""">
	<label for=""""),_display_(/*3.15*/field/*3.20*/.name),format.raw/*3.25*/("""" class="control-label">"""),_display_(/*3.50*/label),format.raw/*3.55*/("""</label>
	<input name=""""),_display_(/*4.16*/field/*4.21*/.name),format.raw/*4.26*/("""" id=""""),_display_(/*4.33*/field/*4.38*/.name),format.raw/*4.43*/("""" class="form-control" value=""""),_display_(/*4.74*/field/*4.79*/.value),format.raw/*4.85*/("""" """),_display_(/*4.88*/toHtmlArgs(args.toMap)),format.raw/*4.110*/(""" """),format.raw/*4.111*/("""/>
	"""),_display_(/*5.3*/if(field.hasErrors )/*5.23*/ {_display_(Seq[Any](format.raw/*5.25*/("""
	"""),format.raw/*6.2*/("""<span class="help-block">
		"""),_display_(/*7.4*/field/*7.9*/.errors.head.message),format.raw/*7.29*/("""
	"""),format.raw/*8.2*/("""</span>
	""")))}),format.raw/*9.3*/("""
"""),format.raw/*10.1*/("""</div>
"""))}
  }

  def render(field:Field,label:String,args:Array[scala.Tuple2[Symbol, Any]]): play.twirl.api.HtmlFormat.Appendable = apply(field,label,args:_*)

  def f:((Field,String,Array[scala.Tuple2[Symbol, Any]]) => play.twirl.api.HtmlFormat.Appendable) = (field,label,args) => apply(field,label,args:_*)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu May 03 07:26:55 IRKT 2018
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/input.scala.html
                  HASH: d58997eea2da46a984d6df4aeea8acba6783cceb
                  MATRIX: 762->1|900->51|928->53|977->76|1005->96|1044->98|1072->99|1112->109|1156->127|1169->132|1194->137|1245->162|1270->167|1321->192|1334->197|1359->202|1392->209|1405->214|1430->219|1487->250|1500->255|1526->261|1555->264|1598->286|1627->287|1658->293|1686->313|1725->315|1754->318|1809->348|1821->353|1861->373|1890->376|1930->387|1959->389
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|30->2|31->3|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|34->6|35->7|35->7|35->7|36->8|37->9|38->10
                  -- GENERATED --
              */
          