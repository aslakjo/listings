


package no.aslakjo.snippet

import xml.{Text, NodeSeq}
import net.liftweb.util.Helpers._
import net.liftweb.http.S._
import net.liftweb.http.SHtml._
import net.liftweb.common._
import main.scala.no.aslakjo.model.List

class NewList {

	def add(xhtml: NodeSeq): NodeSeq = {
		bind("button", xhtml, "add" -> submit("+", createList _))
	}

  private def createList = {
    List.createRecord.name.set("test")
    
  }

}