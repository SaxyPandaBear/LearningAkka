package com.github.saxypandabear

import akka.actor.{ActorSystem, Props}

case class User(username: String, email: String)

object MainApp extends App {
  override def main(args: Array[String]): Unit = {
    val system = ActorSystem("Main")

    val checker = system.actorOf(Props[Checker])
    val storage = system.actorOf(Props[Storage])
    val recorder = system.actorOf(Recorder.props(checker, storage))

    recorder ! Recorder.NewUser(User("Andrew", "ahuynh11@gmu.edu"))
    Thread.sleep(100)

    recorder ! Recorder.NewUser(User("Foo", "foo@bar.com"))
    Thread.sleep(100)

    system.terminate()
  }
}
