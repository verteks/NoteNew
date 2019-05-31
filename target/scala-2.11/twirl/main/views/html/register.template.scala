
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
object register extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Register],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(regForm: Form[Register]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.27*/("""
    """),_display_(/*2.6*/mainForForms("Sign up")/*2.29*/ {_display_(Seq[Any](format.raw/*2.31*/("""
        """),_display_(/*3.10*/if(regForm.hasErrors)/*3.31*/ {_display_(Seq[Any](format.raw/*3.33*/("""
            """),format.raw/*4.13*/("""<div class="alert alert-danger">
                <a class="close" data-dismiss="alert">x</a>
                """),_display_(/*6.18*/if(regForm.errors.size() > 0)/*6.47*/ {_display_(Seq[Any](format.raw/*6.49*/("""
                    """),_display_(/*7.22*/for((key, value) <- regForm.errors) yield /*7.57*/ {_display_(Seq[Any](format.raw/*7.59*/("""
                        """),_display_(/*8.26*/for(err <- value) yield /*8.43*/ {_display_(Seq[Any](format.raw/*8.45*/("""
                            """),format.raw/*9.29*/("""<p>"""),_display_(/*9.33*/err/*9.36*/.message().toString()),format.raw/*9.57*/("""</p>
                        """)))}),format.raw/*10.26*/("""
                    """)))}),format.raw/*11.22*/("""
                """)))}),format.raw/*12.18*/("""
            """),format.raw/*13.13*/("""</div>
        """)))}),format.raw/*14.10*/("""

        """),_display_(/*16.10*/helper/*16.16*/.form(routes.Auth.register())/*16.45*/ {_display_(Seq[Any](format.raw/*16.47*/("""
            """),format.raw/*17.13*/("""<h2 class="form-signin-heading">Sign Up</h2>
            """),_display_(/*18.14*/input(regForm("email"), "Email", 'type -> "email")),format.raw/*18.64*/("""
            """),_display_(/*19.14*/input(regForm("password"), "Password", 'type -> "password")),format.raw/*19.73*/("""
            """),format.raw/*20.13*/("""<div class="form-group">
                <button type="submit" class="btn btn-primary">Sigh Up</button>
            </div>
        """)))}),format.raw/*23.10*/("""
    """)))}))}
  }

  def render(regForm:Form[Register]): play.twirl.api.HtmlFormat.Appendable = apply(regForm)

  def f:((Form[Register]) => play.twirl.api.HtmlFormat.Appendable) = (regForm) => apply(regForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu May 03 07:26:55 IRKT 2018
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/register.scala.html
                  HASH: 4c4d95e2c015815dcea935e6cfba40054a414e77
                  MATRIX: 734->1|847->26|879->33|910->56|949->58|986->69|1015->90|1054->92|1095->106|1233->218|1270->247|1309->249|1358->272|1408->307|1447->309|1500->336|1532->353|1571->355|1628->385|1658->389|1669->392|1710->413|1772->444|1826->467|1876->486|1918->500|1966->517|2006->530|2021->536|2059->565|2099->567|2141->581|2227->640|2298->690|2340->705|2420->764|2462->778|2628->913
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|32->4|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|37->9|38->10|39->11|40->12|41->13|42->14|44->16|44->16|44->16|44->16|45->17|46->18|46->18|47->19|47->19|48->20|51->23
                  -- GENERATED --
              */
          