package datastructure.stack

import datastructure.util.Link

class LStack[E](size: Int = 0) extends StackADT[E] {
  // ignore the input size which is there for the consistency with AStack
  private var top: Option[Link[E]] = None

  private var stackSize: Int = 0

  def clear: Unit = {
    top = None
    stackSize = 0
  }

  def push(item: E): Unit = {
    top = Some(new Link[E](Some(item), top))
    stackSize += 1
  }

  def pop: E = {
    assert (top.isDefined)
    val item: E = top.get.element.get
    top = top.get.next
    stackSize -= 1
    item
  }

  def peek: E = {
    assert (top.isDefined)
    top.get.element.get
  }

  def length: Int = stackSize
}