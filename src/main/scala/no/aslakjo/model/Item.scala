package main.scala.no.aslakjo.model


import net.liftweb.mongodb.{JsonObject, JsonObjectMeta}

case class Item(value:String) extends JsonObject[Item]  {
  def meta = Item
}

object Item extends JsonObjectMeta[Item]
