package datastructure.deque

import scala.reflect.ClassTag

class ADeque[E: ClassTag](size: Int = 10) extends DequeADT[E] {
  private val maxSize = size
  private var front: Int = 0
  private var rear: Int = 0
  private var listSize: Int = 0
  private val listArray: Array[E] = new Array[E](maxSize)

  def clear: Unit = {
    front = 0
    rear = 0
    listSize = 0
  }

  def addFirst(item: E): Unit = {
    listSize match {
      case _ if listSize == maxSize =>
      case _ =>
        listArray(front) = item
        front = (front + maxSize - 1) % maxSize
        listSize += 1
    }
  }

  def addLast(item: E): Unit = {
    listSize match {
      case _ if listSize == maxSize =>
      case _ =>
        rear = (rear + 1) % maxSize
        listSize += 1
        listArray(rear) = item
    }
  }

  def pollFirst: Option[E] = {
    listSize match {
      case 0 => None
      case _ =>
        front = (front + 1) % maxSize
        listSize -= 1
        Some(listArray(front))
    }
  }

  def pollLast: Option[E] = {
    listSize match {
      case 0 => None
      case _ =>
        val optionItem: Option[E] = Some(listArray(rear))
        rear = (rear + maxSize - 1) % maxSize
        listSize -= 1
        optionItem
    }
  }

  def peekFirst: Option[E] = {
    listSize match {
      case 0 => None
      case _ => Some(listArray((front + 1) % maxSize))
    }
  }

  def peekLast: Option[E] = {
    listSize match {
      case 0 => None
      case _ => Some(listArray(rear))
    }
  }

  def length: Int = listSize
}