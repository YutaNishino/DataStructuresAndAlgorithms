package algorithm.sort

object QuickSort {
  def sort[T](array: Array[T])(implicit ordering: Ordering[T]): Unit = {
    qSort(array, 0, array.length - 1)

    def qSort(array: Array[T], start: Int, end: Int): Unit = {
      val pivotIndex = findPivot(array, start, end)
      val pivotValue = array(pivotIndex)
      array(pivotIndex) = array(end)
      array(end) = pivotValue
      val rightStart = partition(array, start, end - 1, pivotValue)
      array(end) = array(rightStart)
      array(rightStart) = pivotValue
      if (rightStart - start > 1) qSort(array, start, rightStart - 1)
      if (end - rightStart > 1) qSort(array, rightStart + 1, end)
    }

    def partition(array: Array[T], s: Int, e: Int, pivot: T): Int = {
      var start = s
      var end = e
      do {
        while (ordering.compare(array(start), pivot) < 0) start += 1
        while (end != 0 && ordering.compare(array(end), pivot) > 0) end -= 1
        val temp = array(start)
        array(start) = array(end)
        array(end) = temp
      } while (start < end)
      val temp = array(start)
      array(start) = array(end)
      array(end) = temp
      start
    }

    def findPivot(array: Array[T], start: Int, end: Int): Int = {
      if (end - start >= 2) {
        val mid = (start + end) / 2
        if (ordering.compare(array(start), array(mid)) < 0) {
          if (ordering.compare(array(start), array(end)) >= 0) return start
          else if (ordering.compare(array(mid), array(end)) < 0) return mid
        }
        else {
          if (ordering.compare(array(start), array(end)) < 0) return start
          else if (ordering.compare(array(mid), array(end)) >= 0) return mid
        }
        end
      }
      // only two elements
      else start
    }
  }
}
