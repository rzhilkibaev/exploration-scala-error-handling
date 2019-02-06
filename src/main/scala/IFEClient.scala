import HttpClient.Response
import IFEClient.User

import scala.concurrent.{ExecutionContext, Future}

object IFEClient {
  case class User()
}

class IFEClient(httpClient: HttpClient)(implicit executionContext: ExecutionContext) {

  def getUser(userId: String): Future[User] = {
    val f = if (userId == "1") {
      httpClient.get()
    }  else {
      httpClient.get(false)
    }
   f.map(r => responseToUser(r))
  }

  private def responseToUser(response: Response): User = {
    User()
  }
}

