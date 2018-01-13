package datastructure.stack

trait StackADT[E] {
  def clear: Unit

  def push(item: E): Unit

  def pop: E

  def peek: E

  def length: Int
}
