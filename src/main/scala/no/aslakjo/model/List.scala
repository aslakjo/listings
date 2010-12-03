package main.scala.no.aslakjo.model

import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field._

class AList extends MongoRecord[AList] with MongoId[AList] {
  def meta = AList

  object name extends StringField(this, 100)
  object items extends MongoJsonObjectListField[AList,Item](this, Item)
}

object AList extends AList with MongoMetaRecord[AList] {
  override def collectionName = "Lists"
}
