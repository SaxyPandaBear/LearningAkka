package com.github.saxypandabear

import akka.actor.{ActorSystem, Props}
import com.github.saxypandabear.MusicPlayer.StartMusic

object MainApp extends App {
  override def main(args: Array[String]): Unit = {
    val system = ActorSystem("Main")

    val musicPlayer = system.actorOf(Props[MusicPlayer], "player")

    musicPlayer ! StartMusic

    system.terminate()
  }
}
