package datastructure.stack

import scala.reflect.ClassTag

class AStack[E: ClassTag](size: Int = 10) extends StackADT[E] {
  private val maxSize: Int = size

  private var top: Int = 0

  private val listArray: Array[E] = new Array[E](maxSize)

  def clear: Unit = top = 0

  def push(item: E): Unit = {
    assert (top != maxSize)
    listArray(top) = item
    top += 1
  }

  def pop: E = {
    assert (top != 0)
    top -= 1
    listArray(top)
  }

  def peek: E = {
    assert (top != 0)
    listArray(top - 1)
  }

  def length: Int = top
}