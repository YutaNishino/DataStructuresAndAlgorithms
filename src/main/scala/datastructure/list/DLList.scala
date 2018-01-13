package datastructure.list

import datastructure.util.DLink

class LList[E](size: Int = 0) extends ListADT[E] {
  // ignore the input size which is there for the consistency with AList
  private var head: DLink[E] = new DLink[E](None, None, None)

  private var tail: DLink[E] = head

  private var curr: DLink[E] = head

  private var listSize: Int = 0

  def clear: Unit = {
    head.setNext(None)
    head = new DLink[E](None, None, None)
    curr = head
    tail = new DLink[E](None, None, Some(head))
    listSize = 0
  }

  def insert(item: E): Unit = {
    curr.setNext(Some(new DLink[E](Some(item), curr.next, Some(curr))))
    curr.next.get.next.get.setPrev(curr.next)
    listSize += 1
  }

  def append(item: E): Unit = {
    tail.setPrev(Some(new DLink[E](Some(item), Some(tail), tail.prev)))
    tail.prev.get.prev.get.setNext(tail.prev)
    listSize += 1
  }

  def remove: Option[E] = {
    curr.next match {
      // if list is empty
      case None => None
      case Some(link) =>
        val optionItem: Option[E] = link.element
        curr.next.get.next.get.setPrev(Some(curr))
        curr.setNext(curr.next.get.next)
        listSize -= 1
        optionItem
    }
  }

  def moveToStart: Unit = curr = head

  def moveToEnd: Unit = curr = tail.prev.get

  def prev: Unit = {
    if (curr == head) return
    curr = curr.prev.get
  }

  def next: Unit = if (curr != tail) curr = curr.next.get

  def length: Int = listSize

  def currPos: Int = {
    var temp: DLink[E] = head
    var i = 0
    while (i < listSize) {
      if (curr == temp) return i
      temp = temp.next.get
      i += 1
    }
    i
  }

  def moveToPos(pos: Int): Unit = {
    assert (pos >= 0 && pos <= listSize)
    curr = head
    for (i <- 0 until pos) curr = curr.next.get
  }

  def getValue: Option[E] = curr.next.get.element
}