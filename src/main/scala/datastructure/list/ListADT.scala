package datastructure.list

trait ListADT[E] {
  def clear: Unit

  def insert(item: E): Unit

  def append(item: E): Unit

  def remove: Option[E]

  def moveToStart: Unit

  def moveToEnd: Unit

  def prev: Unit

  def next: Unit

  def length: Int

  def currPos: Int

  def moveToPos(pos: Int): Unit

  def getValue: Option[E]
}
