package com.oracle.sample

//#test-top
import akka.actor.ActorRef
import akka.http.scaladsl.marshalling.Marshal
import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{ Matchers, WordSpec }

//#set-up
class StatsRoutesSpec extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest
    with StatsRoutes {
  //#test-top

  // Here we need to implement all the abstract members of UserRoutes.
  // We use the real UserRegistryActor to test it while we hit the Routes, 
  // but we could "mock" it by implementing it in-place or by using a TestProbe() 
  override val statsActor: ActorRef =
    system.actorOf(StatsActor.props, "statRegistry")

  lazy val routes = getRoute()

  //#set-up

  //#actual-test
  "statsRoutes" should {
    "return no users if no present (GET /stats)" in {
      // note that there's no need for the host part in the uri:
      val request = HttpRequest(uri = "/stats")

      request ~> routes ~> check {
        status should ===(StatusCodes.OK)

        // we expect the response to be json:
        contentType should ===(ContentTypes.`application/json`)

        // and no entries should be in the list:
        entityAs[String] should ===("""{"stats":[]}""")
      }
    }
    //#actual-test
  }
  //#actual-test

  //#set-up
}
//#set-up
