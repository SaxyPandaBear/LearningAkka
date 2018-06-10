package com.github.saxypandabear

import akka.actor.{ActorSystem, Props}

object MainApp extends App {
  override def main(args: Array[String]): Unit = {
    val system = ActorSystem("Main")

    system.terminate()
  }
}
