package com.github.saxypandabear

import akka.actor.{ActorSystem, Props}
import com.github.saxypandabear.ActorMessage.WhoToGreet

object HelloApp extends App {
  val system = ActorSystem("Hello-App")
  val greeter = system.actorOf(Props[Greeter], "greeter")

  // send message to greeter
  greeter ! WhoToGreet("me")
}
