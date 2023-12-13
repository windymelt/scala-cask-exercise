//> using scala "3.3.1"
//> using dep "com.lihaoyi::cask:0.9.1"

object MyApp extends cask.MainRoutes:
  @cask.get("/")
  def hello(who: String = "Cask") = s"Hello, $who !"

  @cask.get("/json")
  def helloJson() =
    ujson.Obj(
      "hello" -> "Cask JSON!"
    )

  @cask.post("/do-thing")
  def doThing(request: cask.Request) =
    request.text().reverse

  @cask.postJson("/do-thing-json")
  def doThingJson(key1: String, key2: Option[Int]) =
    ujson.Obj(
      "length_of_key1" -> key1.length,
      "double_of_key2" -> 2 * key2.getOrElse(42)
    )

  initialize()
end MyApp
