package com.github.saxypandabear

import akka.actor.Actor
import com.github.saxypandabear.ActorMessage.WhoToGreet

class Greeter extends Actor {
  override def receive: Receive = {
    case WhoToGreet(who) => println(s"Hello $who")
  }
}
