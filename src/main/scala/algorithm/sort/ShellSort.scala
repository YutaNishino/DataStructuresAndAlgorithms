package algorithm.sort

object ShellSort {
  def sort[T](array: Array[T])(implicit ordering: Ordering[T]): Unit = {
    val gaps = Array(701, 301, 132, 57, 23, 10, 4, 1)
    for (gap <- gaps)
      for (i <- gap until array.length) {
        val temp = array(i)
        var j = i
        while (j >= gap && ordering.compare(array(j - gap), temp) > 0) {
          array(j) = array(j - gap)
          j -= gap
        }
        array(j) = temp
      }
  }
}
