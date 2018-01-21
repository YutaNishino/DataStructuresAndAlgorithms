package datastructure.binarysearchtree

class BSTNode[Key, E](private var k: Key, private var e: E,
                      private var l: Option[BSTNode[Key, E]] = None,
                      private var r: Option[BSTNode[Key, E]] = None) extends BinNode[E] {

  def key: Key = k

  def setKey(newKey: Key): Unit = k = newKey

  def element: E = e

  def setElement(newElement: E): Unit = e = newElement

  def left: Option[BSTNode[Key, E]] = l

  def setLeft(newLeft: Option[BSTNode[Key, E]]): Unit = l = newLeft

  def right: Option[BSTNode[Key, E]] = r

  def setRight(newRight: Option[BSTNode[Key, E]]): Unit = r = newRight

  def isLeaf: Boolean = left.isEmpty && right.isEmpty
}
