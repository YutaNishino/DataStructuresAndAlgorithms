package datastructure.queue

trait QueueADT[E] {
  def clear: Unit

  def enqueue(item: E): Unit

  def dequeue: Option[E]

  def topValue: Option[E]

  def length: Int
}
