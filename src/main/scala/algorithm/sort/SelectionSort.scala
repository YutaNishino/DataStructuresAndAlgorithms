package algorithm.sort

object SelectionSort {
  def sort[T](array: Array[T])(implicit ordering: Ordering[T]): Unit = {
    for (i <- 0 to array.length - 2) {
      var minIndex = i
      for (j <- array.length - 1 until i by -1)
        if (ordering.compare(array(j), array(minIndex)) < 0) minIndex = j
      val temp = array(minIndex)
      array(minIndex) = array(i)
      array(i) = temp
    }
  }
}
