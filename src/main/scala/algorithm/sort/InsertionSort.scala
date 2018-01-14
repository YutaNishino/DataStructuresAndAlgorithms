package algorithm.sort

object InsertionSort {
  def sort[T](array: Array[T])(implicit ordering: Ordering[T]): Unit = {
    for (i <- 1 until array.length) {
      var j = i
      while (j > 0 && ordering.compare(array(j), array(j - 1)) < 0) {
        val temp = array(j - 1)
        array(j-1) = array(j)
        array(j) = temp
        j -= 1
      }
    }
  }
}
