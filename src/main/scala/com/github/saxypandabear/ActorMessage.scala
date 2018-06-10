package com.github.saxypandabear

object ActorMessage {
  sealed case class WhoToGreet(who: String)
}
