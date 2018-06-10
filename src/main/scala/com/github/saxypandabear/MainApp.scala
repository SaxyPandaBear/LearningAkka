package com.github.saxypandabear

import akka.actor.{ActorSystem, Props}
import com.github.saxypandabear.ActorMessage.WhoToGreet

class MainApp extends App {
  override def main(args: Array[String]): Unit = {
    val system = ActorSystem("Hello-App")
    val greeter = system.actorOf(Props[Greeter], "greeter")

    // send message to greeter
    greeter ! WhoToGreet("me")
  }
}
