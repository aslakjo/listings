

package bootstrap.liftweb

import _root_.net.liftweb.http.{LiftRules, NotFoundAsTemplate, ParsePath}
import _root_.net.liftweb.sitemap.{SiteMap, Menu, Loc}
import _root_.net.liftweb.util.{ NamedPF }

import net.liftweb.mongodb._

class Boot {
  def boot {
  
  
    // where to search snippet
    LiftRules.addToPackages("no.aslakjo")

    // build sitemap
    val entries = List(
                    Menu("Home") / "index",
                    Menu("List") / "list"
                  )

    LiftRules.uriNotFound.prepend(NamedPF("404handler"){
      case (req,failure) => NotFoundAsTemplate(
        ParsePath(List("exceptions","404"),"html",false,false))
    })
    
    LiftRules.setSiteMap(SiteMap(entries:_*))
    
    // set character encoding
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))


    MongoDB.defineDbAuth(DefaultMongoIdentifier, new MongoAddress(new MongoHost("flame.mongohq.com", 27026), "listings-dev"), "listings", "aslakjo")
  }
}