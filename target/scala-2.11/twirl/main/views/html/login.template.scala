
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
object login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Login],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginForm: Form[Login]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.26*/("""
    """),_display_(/*2.6*/mainForForms("Sigh In")/*2.29*/ {_display_(Seq[Any](format.raw/*2.31*/("""
        """),_display_(/*3.10*/if(loginForm.hasErrors)/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""
            """),format.raw/*4.13*/("""<div class="alert alert-danger">
                <a class="close" data-dismiss="alert">x</a>
                """),_display_(/*6.18*/if(loginForm.errors.size() > 0)/*6.49*/ {_display_(Seq[Any](format.raw/*6.51*/("""
                    """),_display_(/*7.22*/for((key, value) <- loginForm.errors) yield /*7.59*/ {_display_(Seq[Any](format.raw/*7.61*/("""
                        """),_display_(/*8.26*/for(err <- value) yield /*8.43*/ {_display_(Seq[Any](format.raw/*8.45*/("""
                            """),format.raw/*9.29*/("""<p>"""),_display_(/*9.33*/err/*9.36*/.message().toString()),format.raw/*9.57*/("""</p>
                        """)))}),format.raw/*10.26*/("""
                    """)))}),format.raw/*11.22*/("""
                """)))}),format.raw/*12.18*/("""
            """),format.raw/*13.13*/("""</div>
        """)))}),format.raw/*14.10*/("""
        """),_display_(/*15.10*/helper/*15.16*/.form(routes.Auth.auth())/*15.41*/ {_display_(Seq[Any](format.raw/*15.43*/("""
            """),format.raw/*16.13*/("""<h2 class="form-signin-heading">Log In</h2>
            """),format.raw/*17.96*/("""
            """),_display_(/*18.14*/input(loginForm("email"), "Email", 'type -> "text")),format.raw/*18.65*/("""
            """),_display_(/*19.14*/input(loginForm("password"), "Password", 'type -> "password")),format.raw/*19.75*/("""

            """),format.raw/*21.13*/("""<div class="form-group">
                <button type="submit" class="btn btn-primary">Log In</button> или
                <a href=""""),_display_(/*23.27*/routes/*23.33*/.Auth.signup()),format.raw/*23.47*/("""" class="btn btn-default">Sign Up</a>

            </div>
        """)))}),format.raw/*26.10*/("""
    """)))}),format.raw/*27.6*/("""
"""))}
  }

  def render(loginForm:Form[Login]): play.twirl.api.HtmlFormat.Appendable = apply(loginForm)

  def f:((Form[Login]) => play.twirl.api.HtmlFormat.Appendable) = (loginForm) => apply(loginForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu May 03 07:26:55 IRKT 2018
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/login.scala.html
                  HASH: 23cfe81b0d04573467038ae0c8d3885ed8e3a91a
                  MATRIX: 728->1|840->25|872->32|903->55|942->57|979->68|1010->91|1049->93|1090->107|1228->219|1267->250|1306->252|1355->275|1407->312|1446->314|1499->341|1531->358|1570->360|1627->390|1657->394|1668->397|1709->418|1771->449|1825->472|1875->491|1917->505|1965->522|2003->533|2018->539|2052->564|2092->566|2134->580|2219->720|2261->735|2333->786|2375->801|2457->862|2501->878|2663->1013|2678->1019|2713->1033|2814->1103|2851->1110
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|32->4|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|37->9|38->10|39->11|40->12|41->13|42->14|43->15|43->15|43->15|43->15|44->16|45->17|46->18|46->18|47->19|47->19|49->21|51->23|51->23|51->23|54->26|55->27
                  -- GENERATED --
              */
          