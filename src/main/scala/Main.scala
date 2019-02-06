import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object Main extends App {
  val duration = Duration("5 seconds")

  val httpClient = new HttpClient()
  val ifeClient = new IFEClient(httpClient)

  val resultSuccessful = ifeClient.getUser("1")
  val resultFailure = ifeClient.getUser("2")

  println(Await.ready(resultSuccessful, duration))
  println(Await.ready(resultFailure, duration))
}