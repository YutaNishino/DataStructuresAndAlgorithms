package datastructure.deque

trait DequeADT[E] {
  def clear: Unit

  def addFirst(item: E): Unit

  def addLast(item: E): Unit

  def pollFirst: Option[E]

  def pollLast: Option[E]

  def peekFirst: Option[E]

  def peekLast: Option[E]

  def length: Int
}
