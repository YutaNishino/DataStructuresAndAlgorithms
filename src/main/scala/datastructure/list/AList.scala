package datastructure.list

import scala.reflect.ClassTag

class AList[E: ClassTag](size: Int = 10) extends ListADT[E] {
  private val maxSize: Int = size
  private var listSize: Int = 0
  private var curr: Int = 0
  private val listArray: Array[E] = new Array[E](maxSize)

  def clear: Unit = {
    listSize = 0
    curr = 0
  }

  def insert(item: E): Unit = {
    for (i <- listSize until curr by -1) listArray(i) = listArray(i - 1)
    listArray(curr) = item
    listSize += 1
  }

  def append(item: E): Unit = {
    listSize += 1
    listArray(listSize) = item
  }

  def remove: Option[E] = {
    curr match {
      case _ if curr < 0 || curr >= listSize => None
      case _ =>
        val item = listArray(curr)
        for (i <- curr until listSize - 1) listArray(i) = listArray(i + 1)
        listSize -= 1
        Some(item)
    }
  }

  def moveToStart: Unit = curr = 0

  def moveToEnd: Unit = curr = listSize

  def prev: Unit = if (curr != 0) curr -= 1

  def next: Unit = if (curr < listSize) curr += 1

  def length: Int = listSize

  def currPos: Int = curr

  def moveToPos(pos: Int): Unit = {
    assert(pos >= 0 && pos <= listSize)
    curr = pos
  }

  def getValue: Option[E] = {
    // use pattern match to return None if curr is out of range
    curr match {
      case _ if curr >= 0 && curr < listSize => Some(listArray(curr))
      case outOfRange => None
    }
  }
}