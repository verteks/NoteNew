
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[Note],Form[NoteBook],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(noteForm: Form[Note], noteBookForm: Form[NoteBook]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import bootstrap._

Seq[Any](format.raw/*1.54*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("Notes")/*5.15*/ {_display_(Seq[Any](format.raw/*5.17*/("""
    """),format.raw/*6.5*/("""<div class="container-fluid">
        <div>
            <div class="row row-offcanvas row-offcanvas-left">
                <div class="col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">
                    <div class="sidebar-nav" data-bind="notebooksViewModel" id="notebooksDiv">
                        <h3>NoteBooks</h3>
                        <table class="table table-striped">
                            <tr>
                                <td colspan="3" data-bind="click: reloadDefault">Default</td>
                            </tr>
                            <tbody data-bind="foreach: notebooks">
                                <tr class='clickable-row'>
                                    <td data-bind="text: title, click: $root.selectNoteBook" width="100%"></td>
                                    <td align="right">
                                        <img src=""""),_display_(/*20.52*/routes/*20.58*/.Assets.at("images/edit.png")),format.raw/*20.87*/("""" height="16" width="16" data-bind="click: $root.editNoteBook" >
                                    </td>
                                    <td align="right">
                                        <img src=""""),_display_(/*23.52*/routes/*23.58*/.Assets.at("images/cross.png")),format.raw/*23.88*/("""" height="16" width="16" data-bind="click: $root.removeNoteBook" >
                                    </td>
                                </tr>

                            </tbody>
                            <tr>
                                <td colspan="3">
                                    <form>
                                        <div class="col-md-10">
                                            """),_display_(/*32.46*/inputField(noteBookForm("title"), "Enter NoteBook Title", "", "value: title")),format.raw/*32.123*/("""
                                        """),format.raw/*33.41*/("""</div>
                                        <div class="col-md-2" align="right">
                                            <!--<button type="submit" value="submit" class = "btn btn-default" data-bind="click: $root.saveNoteBook">Save</button>-->
                                            <input type="image" src=""""),_display_(/*36.71*/routes/*36.77*/.Assets.at("images/plus.png")),format.raw/*36.106*/("""" data-bind="click: $root.saveNoteBook" alt="Submit Form" height="34" width="34"/>
                                        </div>
                                    </form>
                                </td>
                            </tr>

                        </table>


                    </div>
                        <!--/.well -->
                </div>
                <div data-bind="notesViewModel" id="notesDiv">
                    <div class="col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">
                        <div class="sidebar-nav">
                            <h3 id="notesLabel" data-bind="click: reloadDefault">Notes (Default)</h3>
                            <table class="table table-striped">

                                <tbody data-bind="foreach: notes">
                                    <tr class='clickable-row'>
                                        <td data-bind="text: title, click: $root.editNote" ></td>
                                        <td align="right">
                                            <img src=""""),_display_(/*58.56*/routes/*58.62*/.Assets.at("images/cross.png")),format.raw/*58.92*/("""" height="16" width="16" data-bind="click: $root.removeNote" >
                                        </td>
                                    </tr>
                                </tbody>

                            </table>
                        </div>

                    </div>

                    <div class="col-md-8">






                        <form>
                            """),_display_(/*76.30*/text(noteForm("title"),  "Title", "Enter Note Title", "", "value: title")),format.raw/*76.103*/("""
                            """),_display_(/*77.30*/textArea(noteForm("message"), "Text", "Enter The Note Text", "" , "value: message")),format.raw/*77.113*/("""
                            """),format.raw/*78.29*/("""<button type="submit" value="submit" class = "btn btn-default" data-bind="click: $root.saveNote">Save</button>
                        </form>

                        <script language = "javascript" lang="javascript" src ='"""),_display_(/*81.82*/routes/*81.88*/.Assets.at("javascripts/app.js")),format.raw/*81.120*/("""'></script>

                    </div>
                </div>
            </div>
        </div>
    </div>


""")))}))}
  }

  def render(noteForm:Form[Note],noteBookForm:Form[NoteBook]): play.twirl.api.HtmlFormat.Appendable = apply(noteForm,noteBookForm)

  def f:((Form[Note],Form[NoteBook]) => play.twirl.api.HtmlFormat.Appendable) = (noteForm,noteBookForm) => apply(noteForm,noteBookForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu May 03 07:26:55 IRKT 2018
                  SOURCE: C:/Users/vshir/Documents/play-2.2.6/NoteNew/app/views/index.scala.html
                  HASH: ca3f34990defbbd10c7f78ff487324c825d71a4b
                  MATRIX: 742->1|900->53|930->78|958->81|979->94|1018->96|1050->102|1989->1014|2004->1020|2054->1049|2297->1265|2312->1271|2363->1301|2818->1729|2917->1806|2987->1848|3337->2171|3352->2177|3403->2206|4537->3313|4552->3319|4603->3349|5047->3766|5142->3839|5200->3870|5305->3953|5363->3983|5618->4211|5633->4217|5687->4249
                  LINES: 26->1|29->1|31->4|32->5|32->5|32->5|33->6|47->20|47->20|47->20|50->23|50->23|50->23|59->32|59->32|60->33|63->36|63->36|63->36|85->58|85->58|85->58|103->76|103->76|104->77|104->77|105->78|108->81|108->81|108->81
                  -- GENERATED --
              */
          