package com.github.saxypandabear

import akka.actor.{Actor, Props}
import com.github.saxypandabear.MusicController.{Play, Stop}

object MusicController {
  sealed trait MusicControl
  case object Play extends MusicControl
  case object Stop extends MusicControl

  def props: Props = Props[MusicController]
}

class MusicController extends Actor {
  override def receive: Receive = {
    case Play =>
      println("Music started...")
    case Stop =>
      println("Music stopped...")
    case _ =>
      println("Unknown message")
  }
}
