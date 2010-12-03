package main.scala.no.aslakjo.model

import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field._

class List extends MongoRecord[List] with MongoId[List] {
  def meta = List

  object name extends StringField(this, 100)
}

object List extends List with MongoMetaRecord[List] {
  override def collectionName = "Lists"
}
