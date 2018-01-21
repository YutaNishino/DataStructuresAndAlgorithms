package datastructure.binarysearchtree

class BST[Key, E](implicit val ordering: Ordering[Key])
  extends Dictionary[Key, E] {
  var root: Option[BSTNode[Key, E]] = None
  var nodeCount = 0

  def clear(): Unit = {
    root = None
    nodeCount = 0
  }

  def insert(key: Key, element: E): Unit = {
    root = insertRec(root, key, element)
    nodeCount += 1
  }

  def remove(key: Key): Option[E] = {
    val temp = findRec(root, key)
    temp match {
      case Some(_) =>
        root = removeRec(root, key)
        nodeCount -= 1
      case None =>
    }
    temp
  }

  def removeAny(): Option[E] = {
    if (root.isEmpty) return None
    val temp = root.get.element
    root = removeRec(root, root.get.key)
    nodeCount -= 1
    Some(temp)
  }

  def find(key: Key): Option[E] = findRec(root, key)

  def size: Int = nodeCount

  def findRec(root: Option[BSTNode[Key, E]],
              key: Key): Option[E] = {
    if (root.isEmpty) return None
    root.get.key match {
      case rootKey if ordering.compare(
        rootKey, key) == 0 => Some(root.get.element)
      case rootKey if ordering.compare(
        rootKey, key) > 0 => findRec(root.get.left, key)
      case _ => findRec(root.get.right, key)
    }
  }

  def insertRec(root: Option[BSTNode[Key, E]],
                key: Key, element: E): Option[BSTNode[Key, E]] = {
    if (root.isEmpty) return Some(new BSTNode[Key, E](key, element))
    root.get match {
      case node if
        ordering.compare(root.get.key, key) > 0 => node.setLeft(insertRec(node.left, key, element))
      case node => node.setRight(insertRec(node.right, key, element))
    }
    root
  }

  def removeRec(root: Option[BSTNode[Key, E]], key: Key): Option[BSTNode[Key, E]] = {
    if (root.isEmpty) return None
    root.get.key match {
      case rootKey if ordering.compare(
        rootKey, key) > 0 => root.get.setLeft(removeRec(root.get.left, key))
      case rootKey if ordering.compare(
        rootKey, key) < 0 => root.get.setRight(removeRec(root.get.right, key))
      case _ =>
        if (root.get.left.isEmpty) return root.get.right
        if (root.get.right.isEmpty) return root.get.left
        val temp: BSTNode[Key, E] = getMin(root.get.right)
        root.get.setElement(temp.element)
        root.get.setKey(temp.key)
        root.get.setRight(deleteMin(root.get.right))
    }
    root
  }

  // called after findRec find the key so that there must be the key
  def getMin(root: Option[BSTNode[Key, E]]): BSTNode[Key, E] = {
    root.get.left match {
      case None => root.get
      case Some(node) => getMin(root.get.left)
    }
  }

  // called after findRec find the key so that there must be the key
  def deleteMin(root: Option[BSTNode[Key, E]]): Option[BSTNode[Key, E]] = {
    root.get.left match {
      case None => root.get.right
      case Some(node) => deleteMin(root.get.left)
    }
  }
}
