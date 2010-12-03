package test.scala.no.aslakjo.model

import org.scalatest.{FlatSpec,BeforeAndAfterEach}
import org.scalatest.matchers.ShouldMatchers
import net.liftweb.mongodb._
import main.scala.no.aslakjo.model.List
import net.liftweb.json.JsonDSL._

class ListTests extends FlatSpec with ShouldMatchers with BeforeAndAfterEach {

  "A List" should "be created and retrived" in {
    MongoDB.defineDbAuth(DefaultMongoIdentifier, new MongoAddress(new MongoHost("flame.mongohq.com", 27021), "listings"), "listings", "aslakjo")

    List.createRecord.name("test").save should not be (null)
    val list = List.findAll(("name" -> "test"))
    list should not be ('empty)
    list.length should equal (1)
  }

  override def afterEach{
    List.findAll.foreach(_.delete_!)
  }
}