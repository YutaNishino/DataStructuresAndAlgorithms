package algorithm.sort

object InsertionSort {
  def sort[T](array: Array[T])(implicit ordering: Ordering[T]): Unit = {
    for (i <- 1 until array.length) {
      var j = i - 1
      val value = array(j + 1)
      while (j >= 0 && ordering.compare(value, array(j)) < 0) {
        array(j + 1) = array(j)
        j -= 1
      }
      array(j + 1) = value
    }
  }
}
