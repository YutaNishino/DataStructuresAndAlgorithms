package algorithm.sort

object HeapSort {
  def sort[T](array: Array[T])(implicit ordering: Ordering[T]): Unit = {
    buildHeap(array)
    for (i <- array.length - 1 to 1 by -1) {
      val temp = array(0)
      array(0) = array(i)
      array(i) = temp
      heapify(array, 0, i)
    }
  }

  def buildHeap[T](array: Array[T])(implicit ordering: Ordering[T]): Unit = {
    for (i <- array.length / 2 - 1 to 0 by -1)
      heapify(array, i, array.length)
  }

  def heapify[T](array: Array[T], index: Int, maxIndex: Int)
                (implicit ordering: Ordering[T]): Unit = {
    var largestIndex = index
    var leftIndex = 2 * index + 1
    var rightIndex = 2 * index + 2

    if (leftIndex < maxIndex
      && ordering.compare(array(leftIndex), array(largestIndex)) > 0)
      largestIndex = leftIndex
    if (rightIndex < maxIndex
      && ordering.compare(array(rightIndex), array(largestIndex)) > 0)
      largestIndex = rightIndex
    if (largestIndex != index) {
      val temp = array(index)
      array(index) = array(largestIndex)
      array(largestIndex) = temp
      heapify(array, largestIndex, maxIndex)
    }
  }
}
