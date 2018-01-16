package algorithm.sort

object MergeSort {
  def sort[T](array: Array[T])(implicit ordering: Ordering[T]): Unit = {
    val copy = array.clone
    mergesortRec(copy, array, 0, array.length)

    def mergesortRec(array: Array[T], result: Array[T],
                     start: Int, end: Int): Unit = {
      if (end - start < 2) return
      if (end - start == 2)
        if (ordering.compare(result(start), result(start + 1)) > 0) {
          val temp = result(start)
          result(start) = result(start + 1)
          result(start + 1) = temp
          return
        }

      val mid = (start + end) / 2
      mergesortRec(result, array, start, mid)
      mergesortRec(result, array, mid, end)

      // merge
      var i = start
      var j = mid
      var index = start
      while(index < end) {
        if (j >= end ||
          (i < mid && ordering.compare(array(i), array(j)) < 0)) {
          result(index) = array(i)
          i += 1
        }
        else {
          result(index) = array(j)
          j += 1
        }
        index += 1
      }
    }
  }
}
