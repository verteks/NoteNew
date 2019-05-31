
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
object textarea extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Field,String,Array[scala.Tuple2[Symbol, Any]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(field: Field, label: String, args: (Symbol,Any)*):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*2.1*/("""<div class="form-group"""),_display_(/*2.24*/if(field.hasErrors)/*2.43*/{_display_(Seq[Any](format.raw/*2.44*/(""" """),format.raw/*2.45*/("""has-error""")))}),format.raw/*2.55*/("""">
	<label for=""""),_display_(/*3.15*/field/*3.20*/.name),format.raw/*3.25*/("""" class="control-label">"""),_display_(/*3.50*/label),format.raw/*3.55*/("""</label>
	<textarea name=""""),_display_(/*4.19*/field/*4.24*/.name),format.raw/*4.29*/("""" id=""""),_display_(/*4.36*/field/*4.41*/.name),format.raw/*4.46*/("""" class="form-control" """),_display_(/*4.70*/toHtmlArgs(args.toMap)),format.raw/*4.92*/(""">"""),_display_(/*4.94*/field/*4.99*/.value),format.raw/*4.105*/("""</textarea>
	"""),_display_(/*5.3*/if(field.hasErrors)/*5.22*/ {_display_(Seq[Any](format.raw/*5.24*/("""
	"""),format.raw/*6.2*/("""<span class="help-block">Поле должно быть заполнено!</span>
	""")))}),format.raw/*7.3*/("""
"""),format.raw/*8.1*/("""</div>
"""))}
  }

  def render(field:Field,label:String,args:Array[scala.Tuple2[Symbol, Any]]): play.twirl.api.HtmlFormat.Appendable = apply(field,label,args:_*)

  def f:((Field,String,Array[scala.Tuple2[Symbol, Any]]) => play.twirl.api.HtmlFormat.Appendable) = (field,label,args) => apply(field,label,args:_*)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu May 03 07:26:55 IRKT 2018
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/textarea.scala.html
                  HASH: 2fede2e2894f26410a512180204760add1ef07cc
                  MATRIX: 765->1|903->51|931->53|980->76|1007->95|1045->96|1073->97|1113->107|1157->125|1170->130|1195->135|1246->160|1271->165|1325->193|1338->198|1363->203|1396->210|1409->215|1434->220|1484->244|1526->266|1554->268|1567->273|1594->279|1634->294|1661->313|1700->315|1729->318|1821->381|1849->383
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|30->2|31->3|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|34->6|35->7|36->8
                  -- GENERATED --
              */
          