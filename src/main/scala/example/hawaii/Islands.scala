package example.hawaii

import scala.util.Random

object Islands {
  def randomIsland(): String = Random.shuffle(islandNames).head

  val HAWAII = "HAWAII"
  val KAHOOLAWE = "KAHOOLAWE"
  val KAUAI = "KAUAI"
  val LANAI = "LANAI"
  val MAUI = "MAUI"
  val MOLOKAI = "MOLOKAI"
  val NIIHAU = "NIIHAU"
  val OAHU = "OAHU"

  val islandNames = Seq(
    HAWAII,
    KAHOOLAWE,
    KAUAI,
    LANAI,
    MAUI,
    MOLOKAI,
    NIIHAU,
    OAHU
  )
}
