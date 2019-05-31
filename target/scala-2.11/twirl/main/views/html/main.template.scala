
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>"""),_display_(/*8.17*/title),format.raw/*8.22*/("""</title>
            <!--[if lt IE 9]>
      	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    	<![endif]-->
        <link rel="stylesheet" media="screen" href=""""),_display_(/*13.54*/routes/*13.60*/.Assets.at("stylesheets/main.css")),format.raw/*13.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/routes/*14.60*/.Assets.at("lib/bootstrap/css/bootstrap.css")),format.raw/*14.105*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/routes/*15.65*/.Assets.at("images/icon_n.png")),format.raw/*15.96*/("""">
        <script src=""""),_display_(/*16.23*/routes/*16.29*/.Assets.at("lib/jquery/jquery.js")),format.raw/*16.63*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*17.23*/routes/*17.29*/.Assets.at("lib/bootstrap/js/bootstrap.js")),format.raw/*17.72*/("""" type="text/javascript"></script>

        <link rel="stylesheet" type="text/css" href=""""),_display_(/*19.55*/routes/*19.61*/.Assets.at("bootstrap/css/bootstrap.css")),format.raw/*19.102*/("""">
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*20.55*/routes/*20.61*/.Assets.at("stylesheets/main.css")),format.raw/*20.95*/("""">
        """),format.raw/*21.76*/("""
        """),format.raw/*22.9*/("""<script src=""""),_display_(/*22.23*/routes/*22.29*/.Assets.at("javascripts/jquery-1.9.0.min.js")),format.raw/*22.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*23.23*/routes/*23.29*/.Assets.at("javascripts/knockout.js")),format.raw/*23.66*/("""" type="text/javascript"></script>

        <script type="text/javascript" src=""""),_display_(/*25.46*/routes/*25.52*/.Application.jsRoutes),format.raw/*25.73*/(""""></script>
    </head>
    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--<a class="navbar-brand" href="/">Notes</a>-->
                    <img src=""""),_display_(/*39.32*/routes/*39.38*/.Assets.at("images/icon_n.png")),format.raw/*39.69*/("""" height="50" width="50" href="/#">
                </div>


                <div id="navbar" class="navbar-collapse collapse">
                """),_display_(/*44.18*/if(Auth.currentUserEmail() != null)/*44.53*/ {_display_(Seq[Any](format.raw/*44.55*/("""
                    """),format.raw/*45.21*/("""<ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">"""),_display_(/*47.146*/Auth/*47.150*/.currentUserEmail()),format.raw/*47.169*/(""" """),format.raw/*47.170*/("""<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href=""""),_display_(/*49.47*/routes/*49.53*/.Admin.changePassword()),format.raw/*49.76*/("""">Change Password</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href=""""),_display_(/*51.47*/routes/*51.53*/.Auth.logout()),format.raw/*51.67*/("""">Log Out</a></li>
                            </ul>
                        </li>
                    </ul>
                """)))}/*55.19*/else/*55.24*/{_display_(Seq[Any](format.raw/*55.25*/("""
                    """),format.raw/*56.21*/("""<form class="navbar-form navbar-right" action=""""),_display_(/*56.69*/routes/*56.75*/.Auth.auth()),format.raw/*56.87*/("""" method="POST">
                        <div class="form-group">
                            <input name="email" type="text" placeholder="E-mail" class="form-control">
                        </div>
                        <div class="form-group">
                            <input name="password" type="password" placeholder="Password" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-success">Log In</button>
                    </form>
                """)))}),format.raw/*65.18*/("""
                """),format.raw/*66.17*/("""</div>

                    <!--/.navbar-collapse -->
            </div>
        </nav>
        <br>
        <br>
        <br>
        <div class="container-fluid">
            """),_display_(/*75.14*/if(flash().get("success") != null)/*75.48*/ {_display_(Seq[Any](format.raw/*75.50*/("""
                """),format.raw/*76.17*/("""<div class="alert alert-success">
                    <a class="close" data-dismiss="alert">x</a>
                    """),_display_(/*78.22*/flash()/*78.29*/.get("success")),format.raw/*78.44*/("""
                """),format.raw/*79.17*/("""</div>
            """)))}),format.raw/*80.14*/("""
            """),_display_(/*81.14*/content),format.raw/*81.21*/("""

            """),format.raw/*83.13*/("""<hr>
            <footer>
            </footer>
        </div> <!-- /container -->

    </body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu May 03 07:26:55 IRKT 2018
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/main.scala.html
                  HASH: 668ea0a0ac9cf960a1dafd81be36145e063bcde1
                  MATRIX: 727->1|845->31|873->33|1125->259|1150->264|1462->549|1477->555|1532->589|1616->646|1631->652|1698->697|1787->759|1802->765|1854->796|1907->822|1922->828|1977->862|2062->920|2077->926|2141->969|2260->1061|2275->1067|2338->1108|2423->1166|2438->1172|2493->1206|2533->1285|2570->1295|2611->1309|2626->1315|2692->1360|2777->1418|2792->1424|2850->1461|2960->1544|2975->1550|3017->1571|3773->2300|3788->2306|3840->2337|4017->2487|4061->2522|4101->2524|4151->2546|4413->2780|4427->2784|4468->2803|4498->2804|4660->2939|4675->2945|4719->2968|4896->3118|4911->3124|4946->3138|5095->3269|5108->3274|5147->3275|5197->3297|5272->3345|5287->3351|5320->3363|5883->3895|5929->3913|6143->4100|6186->4134|6226->4136|6272->4154|6420->4275|6436->4282|6472->4297|6518->4315|6570->4336|6612->4351|6640->4358|6684->4374
                  LINES: 26->1|29->1|30->2|36->8|36->8|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|47->19|47->19|47->19|48->20|48->20|48->20|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|53->25|53->25|53->25|67->39|67->39|67->39|72->44|72->44|72->44|73->45|75->47|75->47|75->47|75->47|77->49|77->49|77->49|79->51|79->51|79->51|83->55|83->55|83->55|84->56|84->56|84->56|84->56|93->65|94->66|103->75|103->75|103->75|104->76|106->78|106->78|106->78|107->79|108->80|109->81|109->81|111->83
                  -- GENERATED --
              */
          