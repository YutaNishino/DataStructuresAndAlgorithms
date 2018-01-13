package datastructure.queue

import scala.reflect.ClassTag

class AQueue[E: ClassTag](size: Int = 10) extends QueueADT[E] {
  private val maxSize = size + 1
  private var front: Int = 0
  private var rear: Int = 1
  private val listArray: Array[E] = new Array[E](maxSize)

  def clear:Unit = {
    front = 0
    rear = 1
  }

  def enqueue(item: E): Unit = {
    length match {
      case _ if length == `maxSize` - 1 =>
      case _ =>
        listArray(rear) = item
        rear = (rear + 1) % maxSize
    }
  }

  def dequeue: Option[E] = {
    length match {
      case 0 => None
      case _ =>
        front = (front + 1) % maxSize
        Some(listArray(front))
    }
  }

  def topValue: Option[E] = {
    length match {
      case 0 => None
      case _ => Some(listArray((front + 1) % maxSize))
    }
  }

  def length: Int = (rear + maxSize - 1 - front) % maxSize
}
