import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

class HttpClient()(implicit ec: ExecutionContext) {
  import HttpClient._

  def get(succeed: Boolean = true): Future[Response] = {
    val result = if (succeed) {
      Future.successful(Response())
    } else {
      Future.failed(new Exception("timeout"))
    }
    result
  }
}

object HttpClient {
  case class Request()
  case class Response()
}
