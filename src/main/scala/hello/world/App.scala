package hello.world

import slinky.core._
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.timers.setInterval
import scala.scalajs.js.annotation.{JSImport, ScalaJSDefined}
import scala.util.Random

@JSImport("resources/App.css", JSImport.Default)
@js.native
object AppCSS extends js.Object

@JSImport("resources/logo.svg", JSImport.Default)
@js.native
object ReactLogo extends js.Object

@react class App extends Component {
  type Props = Unit

  val HAWAII = "HAWAII"
  val KAHOOLAWE = "KAHOOLAWE"
  val KAUAI = "KAUAI"
  val LANAI = "LANAI"
  val MAUI = "MAUI"
  val MOLOKAI = "MOLOKAI"
  val NIIHAU = "NIIHAU"
  val OAHU = "OAHU"

  val islandNames: List[String] = List(
    HAWAII,
    KAHOOLAWE,
    KAUAI,
    LANAI,
    MAUI,
    MOLOKAI,
    NIIHAU,
    OAHU,
  )

  def randomIsland(): String = Random.shuffle(islandNames).head

  case class State(correctAnswers: Int,
                   wrongAnswers: Int,
                   selectedIsland: String,
                   seconds: Int)

  override def initialState = State(0, 0, randomIsland(), 0)

  def chooseIsland(name: String): Unit = {
    if (name == state.selectedIsland) {
      setState(_.copy(correctAnswers = state.correctAnswers + 1))
    } else {
      setState(_.copy(wrongAnswers = state.wrongAnswers + 1))
    }

    setState(_.copy(selectedIsland = randomIsland()))
  }

  def startTimer(): Unit = {
    setState(State(0, 0, randomIsland(), 30))

    def tick(): Unit = {
      setInterval(1000) {
        setState(_.copy(state.seconds - 1))
        if (state.seconds < 1) () else tick()
      }
    }

    tick()
  }

  override def componentDidMount() {
    startTimer()
  }

  private val css = AppCSS

  def render() = {
    div(className := "App")(
      "seconds:",
      state.seconds.toString
    )
  }
}
