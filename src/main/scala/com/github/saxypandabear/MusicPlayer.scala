package com.github.saxypandabear

import akka.actor.{Actor, Props}
import com.github.saxypandabear.MusicController._
import com.github.saxypandabear.MusicPlayer.{StartMusic, StopMusic}

object MusicPlayer {
  sealed trait PlayerMessage
  case object StopMusic extends PlayerMessage
  case object StartMusic extends PlayerMessage
}

class MusicPlayer extends Actor {
  override def receive: Receive = {
    case StopMusic =>
      println("Stopping music...") // TODO: how does this send a message to the controller to stop the music?
    case StartMusic =>
      // Start the music controller
      val controller = context.actorOf(MusicController.props, "controller")
      controller ! Play

      controller ! Stop
  }
}
