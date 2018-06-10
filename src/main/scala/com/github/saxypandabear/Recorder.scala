package com.github.saxypandabear

import akka.actor.{Actor, ActorRef, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._
import com.github.saxypandabear.Checker.{Blacklisted, CheckUser, Whitelisted}
import com.github.saxypandabear.Recorder.NewUser
import com.github.saxypandabear.Storage.AddUser

object Recorder {
  sealed trait RecorderMessage
  case class NewUser(user: User) extends RecorderMessage

  def props(checker: ActorRef, storage: ActorRef): Props = Props(new Recorder(checker, storage))
}

class Recorder(checker: ActorRef, storage: ActorRef) extends Actor {
  import scala.concurrent.ExecutionContext.Implicits.global
  implicit val timeout: Timeout = Timeout(5 seconds)
  override def receive: Receive = {
    case NewUser(user) =>
      checker ? CheckUser(user) map {
        case Whitelisted(user) =>
          storage ! AddUser(user)
        case Blacklisted(user) =>
          println(s"Recorder: $user is in the blacklist")
      }
  }
}
