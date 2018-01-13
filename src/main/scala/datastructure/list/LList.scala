package datastructure.list

import datastructure.util.Link

class LList[E](size: Int = 0) extends ListADT[E] {
  // ignore the input size which is there for the consistency with AList
  private var head: Link[E] = new Link[E](None, None)

  private var tail: Link[E] = head

  private var curr: Link[E] = head

  private var listSize: Int = 0

  def clear: Unit = {
    head.setNext(None)
    head = new Link[E](None, None)
    curr = head
    tail = head
    listSize = 0
  }

  def insert(item: E): Unit = {
    curr.setNext(Some(new Link[E](Some(item), curr.next)))
    if (tail == curr) tail = curr.next.get
    listSize += 1
  }

  def append(item: E): Unit = {
    tail.setNext(Some(new Link[E](Some(item), None)))
    tail = tail.next.get
    listSize += 1
  }

  def remove: Option[E] = {
    curr.next match {
      case None => None
      case Some(link) =>
        val optionItem = link.element
        if (tail == link) tail = curr
        curr.setNext(link.next)
        listSize -= 1
        optionItem
    }
  }

  def moveToStart: Unit = curr = head

  def moveToEnd: Unit = curr = tail

  def prev: Unit = {
    if (curr == head) return
    var temp: Link[E] = head
    // Since temp is between head and curr, temp.next is not None
    while (temp.next.get != curr) temp = temp.next.get
    curr = temp
  }

  def next: Unit = if (curr != tail) curr = curr.next.get

  def length: Int = listSize

  def currPos: Int = {
    var temp: Link[E] = head
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

  def getValue: Option[E] = {
    curr.next match {
      case Some(link) => link.element
      case None => None
    }
  }
}