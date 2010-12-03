package test.scala.no.aslakjo.model

import org.scalatest.{FlatSpec,BeforeAndAfterEach}
import org.scalatest.matchers.ShouldMatchers
import net.liftweb.mongodb._
import net.liftweb.json.JsonDSL._
import main.scala.no.aslakjo.model.{Item, AList}

class ListTests extends FlatSpec with ShouldMatchers with BeforeAndAfterEach {

  "A AList" should "be created and retrived by name" in {
    AList.createRecord.name("test").save should not be (null)
    val list = AList.findAll(("name" -> "test"))
    list should not be ('empty)
    list.length should equal (1)
  }

  it should "have sub items" in {
    val list = AList.createRecord
    list.name("list")

    val item = new Item("value")
    list.items(List(item,item))

    list.save

    val fetchedList = AList.find("name" -> "list")
    val items = fetchedList.get.items.value
    items.size should equal (2)
    items(0).value should equal ("value")
    items(1).value should equal ("value")
        
  }



  override def afterEach{
    AList.findAll.foreach(_.delete_!)
  }

  override def beforeEach{
    MongoDB.defineDbAuth(DefaultMongoIdentifier, new MongoAddress(new MongoHost("flame.mongohq.com", 27021), "listings"), "listings", "aslakjo")
  }
}