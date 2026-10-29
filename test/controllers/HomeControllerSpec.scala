package controllers

import org.scalatestplus.play.*
import org.scalatestplus.play.guice.*
import play.api.test.*
import play.api.test.Helpers.*

/**
  * Add your spec here.
  * You can mock out a whole application including requests, plugins etc.
  *
  * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
  */
class HomeControllerSpec extends PlaySpec with GuiceOneAppPerSuite with Injecting:

  private val fakeRequest = FakeRequest(GET, "/")

  "HomeController GET" should:

    "render the index page from a new controller instance" in:
      val controller = new HomeController(stubControllerComponents())
      val home       = controller.index(fakeRequest)

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("Welcome to Play")

    "render the index page from the application" in:
      val controller = inject[HomeController]
      val home       = controller.index(fakeRequest)

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("Welcome to Play")

    "render the index page from the router" in:
      val home = route(app, fakeRequest).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("Welcome to Play")
