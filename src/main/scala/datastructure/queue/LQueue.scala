package datastructure.queue

import datastructure.util.Link

class LQueue[E](size: Int = 10) extends QueueADT[E] {
  private var front: Link[E] = new Link[E](None, None)

  private var rear: Link[E] = front

  // ignore size
  private var queueSize: Int = 0

  def clear: Unit = {
    front = new Link[E](None, None)
    rear = front
    queueSize = 0
  }

  def enqueue(item: E): Unit = {
    rear.setNext(Some(new Link[E](Some(item), None)))
    rear = rear.next.get
    queueSize += 1
  }

  def dequeue: Option[E] = {
    front.next match {
      case None => None
      case Some(link) =>
        front.setNext(front.next.get.next)
        if (front.next.isEmpty) rear = front
        queueSize -= 1
        link.element
    }
  }

  def topValue: Option[E] = {
    front.next match {
      case None => None
      case Some(link) =>
        link.element
    }
  }

  def length: Int = queueSize
}
