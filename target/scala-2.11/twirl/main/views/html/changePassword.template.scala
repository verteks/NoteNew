
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
object changePassword extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[ChangePassword],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form: Form[ChangePassword]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.30*/("""
    """),_display_(/*2.6*/mainForForms("Change Password")/*2.37*/ {_display_(Seq[Any](format.raw/*2.39*/("""
        """),_display_(/*3.10*/if(form.hasErrors)/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""
            """),format.raw/*4.13*/("""<div class="alert alert-danger">
                <a class="close" data-dismiss="alert">x</a>
                """),_display_(/*6.18*/if(form.errors.size() > 0)/*6.44*/ {_display_(Seq[Any](format.raw/*6.46*/("""
                    """),_display_(/*7.22*/for((key, value) <- form.errors) yield /*7.54*/ {_display_(Seq[Any](format.raw/*7.56*/("""
                        """),_display_(/*8.26*/for(err <- value) yield /*8.43*/ {_display_(Seq[Any](format.raw/*8.45*/("""
                            """),format.raw/*9.29*/("""<p>"""),_display_(/*9.33*/err/*9.36*/.message().toString()),format.raw/*9.57*/("""</p>
                        """)))}),format.raw/*10.26*/("""
                    """)))}),format.raw/*11.22*/("""
                """)))}),format.raw/*12.18*/("""
            """),format.raw/*13.13*/("""</div>
        """)))}),format.raw/*14.10*/("""

        """),format.raw/*16.9*/("""<h3>Изменение пароля</h3>
        """),_display_(/*17.10*/helper/*17.16*/.form(routes.Admin.changePasswordConfirm())/*17.59*/ {_display_(Seq[Any](format.raw/*17.61*/("""
            """),_display_(/*18.14*/input(form("password"), "Current Password", 'type -> "password")),format.raw/*18.78*/("""
            """),_display_(/*19.14*/input(form("newPassword"), "New Password", 'type -> "password")),format.raw/*19.77*/("""
            """),format.raw/*20.13*/("""<div class="form-group">
                <button type="submit" class="btn btn-primary">Изменить</button>
            </div>
        """)))}),format.raw/*23.10*/("""
    """)))}))}
  }

  def render(form:Form[ChangePassword]): play.twirl.api.HtmlFormat.Appendable = apply(form)

  def f:((Form[ChangePassword]) => play.twirl.api.HtmlFormat.Appendable) = (form) => apply(form)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu May 03 07:26:55 IRKT 2018
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/changePassword.scala.html
                  HASH: 47e9030039cd5a6a188a4d1b2f028964f842a9e8
                  MATRIX: 746->1|862->29|894->36|933->67|972->69|1009->80|1035->98|1074->100|1115->114|1253->226|1287->252|1326->254|1375->277|1422->309|1461->311|1514->338|1546->355|1585->357|1642->387|1672->391|1683->394|1724->415|1786->446|1840->469|1890->488|1932->502|1980->519|2019->531|2082->567|2097->573|2149->616|2189->618|2231->633|2316->697|2358->712|2442->775|2484->789|2651->925
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|32->4|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|37->9|38->10|39->11|40->12|41->13|42->14|44->16|45->17|45->17|45->17|45->17|46->18|46->18|47->19|47->19|48->20|51->23
                  -- GENERATED --
              */
          