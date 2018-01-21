package datastructure.binarysearchtree

trait Dictionary[Key, E] {
  def clear(): Unit

  def insert(k: Key, e: E): Unit

  def remove(k: Key): Option[E]

  def removeAny(): Option[E]

  def find(k: Key): Option[E]

  def size: Int
}