package com.github.saxypandabear

import akka.actor.Actor
import com.github.saxypandabear.MusicController.{Play, Stop}

object MusicController {
  sealed trait MusicControl
  case object Play extends MusicControl
  case object Stop extends MusicControl
}

class MusicController extends Actor {
  override def receive: Receive = {
    case Play =>
      println("Music started...")
    case Stop =>
      println("Music stopped...")
  }
}
