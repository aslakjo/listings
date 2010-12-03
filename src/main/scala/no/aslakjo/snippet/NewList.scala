


package no.aslakjo.snippet

import xml.{Text, NodeSeq}
import net.liftweb.util.Helpers._
import net.liftweb.http.S._
import net.liftweb.http.SHtml._
import net.liftweb.common._
import main.scala.no.aslakjo.model.{AList, SessionList}

class NewList {

	def add(xhtml: NodeSeq): NodeSeq = {
		bind("button", xhtml, "add" -> submit("+", createList _))
	}

  private def createList = {
    val list = AList.createRecord
    list.name.set("test")
    list.save

    SessionList(Full(list))
    redirectTo("/list")
  }

}