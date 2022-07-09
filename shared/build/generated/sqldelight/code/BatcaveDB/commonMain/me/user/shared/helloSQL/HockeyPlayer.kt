package me.user.shared.helloSQL

import kotlin.Long
import kotlin.String

public data class HockeyPlayer(
  public val player_number: Long,
  public val full_name: String
) {
  public override fun toString(): String = """
  |HockeyPlayer [
  |  player_number: $player_number
  |  full_name: $full_name
  |]
  """.trimMargin()
}