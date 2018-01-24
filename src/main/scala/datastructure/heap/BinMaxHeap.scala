package datastructure.heap

import scala.reflect.ClassTag

class BinMaxHeap[T: ClassTag](val heap: Array[T])
                             (implicit val ordering: Ordering[T]) {
  private val maxSize = heap.length
  private var size = maxSize
  buildHeap()

  def heapSize: Int = size

  def isLeaf(pos: Int): Boolean = (pos >= size / 2) && (pos < size)

  def leftChild(pos: Int): Option[Int] = {
    pos match {
      case _ if pos >= size / 2 => None
      case _ => Some(2 * pos + 1)
    }
  }

  def rightChild(pos: Int): Option[Int] = {
    pos match {
      case _ if pos < (size - 1) / 2 => None
      case _ => Some(2 * pos + 2)
    }
  }

  def parent(pos: Int): Option[Int] = {
    pos match {
      case _ if pos <= 0 || pos >= size => None
      case _ => Some((pos - 1) / 2)
    }
  }

  def insert(element: T): Unit = {
    if (size >= maxSize) return
    var curr = size
    size += 1
    heap(curr) = element
    while(curr != 0 && ordering.compare(heap(curr), heap(parent(curr).get)) > 0) {
      val parentCurr = parent(curr).get
      val temp = heap(parentCurr)
      heap(parentCurr) = heap(curr)
      heap(curr) = temp
      curr = parentCurr
    }
  }

  def siftDown(pos: Int): Unit = {
    if (pos < 0 || pos >= size) return
    var curr = pos
    while(!isLeaf(curr)) {
      // if it is not a leaf, then it must have left child
      var left = leftChild(curr).get
      if (left < size - 1 && ordering.compare(heap(left), heap(left + 1)) < 0)
        left += 1
      if (ordering.compare(heap(curr), heap(left)) >= 0) return
      val temp = heap(curr)
      heap(curr) = heap(left)
      heap(left) = temp
      curr = left
    }
  }

  def buildHeap(): Unit = {
    for(i <- (size - 1)/ 2 to 0 by -1) siftDown(i)
  }

  def removeMax(): Option[T] = {
    size match {
      case 0 => None
      case _ =>
        size -= 1
        val maxValue = heap(0)
        heap(0) = heap(size)
        if (size != 0) siftDown(0)
        Some(maxValue)
    }
  }

  def remove(pos: Int): Option[T] = {
    pos match {
      case _ if pos < 0 || pos >= size => None
      case _ =>
        size -= 1
        val value = heap(pos)
        heap(pos) = heap(size)
        var curr = pos
        while (curr > 0 && ordering.compare(heap(curr), heap(parent(curr).get)) > 0) {
          val temp = heap(curr)
          heap(curr) = heap(parent(curr).get)
          heap(parent(curr).get) = temp
          curr = parent(curr).get
        }
        if (size != 0) siftDown(curr)
        Some(value)
    }
  }
}
