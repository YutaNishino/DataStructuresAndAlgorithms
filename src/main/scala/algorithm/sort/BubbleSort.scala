package algorithm.sort

object BubbleSort {
  def sort[T](array: Array[T])(implicit ordering: Ordering[T]): Unit = {
    for (i <- 0 to array.length - 2)
      for (j <- array.length - 1 until i by -1)
        if (ordering.compare(array(j), array(j - 1)) < 0) {
          val temp = array(j - 1)
          array(j - 1) = array(j)
          array(j) = temp
        }
  }
}
