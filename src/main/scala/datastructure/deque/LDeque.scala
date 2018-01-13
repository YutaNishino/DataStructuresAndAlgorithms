package datastructure.deque

import datastructure.util.DLink

class LDeque[E](size: Int = 10) extends DequeADT[E] {
  private var front: DLink[E] = new DLink[E](None, None, None)

  private var rear: DLink[E] = front

  // ignore size
  private var dequeSize: Int = 0

  def clear: Unit = {
    front = new DLink[E](None, None, None)
    rear = front
    dequeSize = 0
  }

  def addFirst(item: E): Unit = {
    val element = new DLink[E](Some(item), front.next, Some(front))
    // when deque is empty
    front.next match {
      case None => rear = element
      case Some(_) =>
    }
    front.setNext(Some(element))
    dequeSize += 1
  }

  def addLast(item: E): Unit = {
    rear.setNext(Some(new DLink[E](Some(item), None, Some(rear))))
    rear = rear.next.get
    dequeSize += 1
  }

  def pollFirst: Option[E] = {
    front.next match {
      case None => None
      case Some(link) =>
        front.setNext(front.next.get.next)
        if (front.next.isEmpty) rear = front
        dequeSize -= 1
        link.element
    }
  }

  def pollLast: Option[E] = {
    rear.element match {
      case None => None
      case Some(e) =>
        rear = rear.prev.get
        dequeSize -= 1
        rear.element
    }
  }

  def peekFirst: Option[E] = {
    front.next match {
      case None => None
      case Some(link) => link.element
    }
  }

  def peekLast: Option[E] = rear.element

  def length: Int = dequeSize
}