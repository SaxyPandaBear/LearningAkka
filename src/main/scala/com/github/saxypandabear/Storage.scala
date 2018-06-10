package com.github.saxypandabear

import akka.actor.Actor
import com.github.saxypandabear.Storage.AddUser

object Storage {
  sealed trait StorageMessage
  case class AddUser(user: User) extends StorageMessage
}

class Storage extends Actor {
  var users = List.empty[User]

  override def receive: Receive = {
    case AddUser(user) =>
      println(s"Storage: $user added")
      users = user :: users // prepend user
  }
}
