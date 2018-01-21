package datastructure.binarysearchtree

trait BinNode[E] {
  def element: E

  def setElement(newElement: E): Unit

  def left: Option[BinNode[E]]

  def right: Option[BinNode[E]]

  def isLeaf: Boolean
}
