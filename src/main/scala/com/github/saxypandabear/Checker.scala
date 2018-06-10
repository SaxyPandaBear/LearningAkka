package com.github.saxypandabear

import akka.actor.Actor
import com.github.saxypandabear.Checker.{Blacklisted, CheckUser, Whitelisted}

object Checker {
  sealed trait CheckerMessage
  sealed trait CheckerResponse

  case class CheckUser(user: User) extends CheckerMessage

  case class Blacklisted(user: User) extends CheckerMessage
  case class Whitelisted(user: User) extends CheckerMessage
}

class Checker extends Actor {
  val blacklist = List(User("Foo", "foo@bar.com"))
  override def receive: Receive = {
    // can add conditional logic to pattern matching cases
    case CheckUser(user) if blacklist.contains(user) =>
      println(s"Checker: $user is blacklisted")
      // sender() returns a message to the actor that sent the CheckUser message to this actor
      sender() ! Blacklisted(user)
    // pattern matches the case that user is not in blacklist
    // could have done a single pattern matcher with an if-else branch inside
    case CheckUser(user) =>
      println(s"Checker: $user is not blacklisted")
      sender() ! Whitelisted(user)
//    case CheckUser(user) =>
//      if (blacklist.contains(user)) {
//        println(s"Checker: $user is blacklisted")
//        // sender() returns a message to the actor that sent the CheckUser message to this actor
//        sender() ! Blacklisted(user)
//      }
//      else {
//        println(s"Checker: $user is not blacklisted")
//        sender() ! Whitelisted(user)
//      }
  }
}
