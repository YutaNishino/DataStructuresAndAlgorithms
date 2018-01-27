package algorithm.peakfinding

object TwoDPeak {
  def searchPeak[T](matrix: Array[Array[T]])(implicit ordering: Ordering[T]): (Int, Int) = {
    var low = 0
    var high = matrix.length - 1
    while (low <= high - 2) {
      val mid = (low + high) / 2
      val array = matrix(mid)
      val maxIndex = array.indexOf(array.max)
      val compAbove = ordering.compare(array(maxIndex), matrix(mid - 1)(maxIndex))
      val compBelow = ordering.compare(array(maxIndex), matrix(mid + 1)(maxIndex))
      if (compAbove < 0) high = mid - 1
      else if (compBelow < 0) low = mid + 1
      else return (mid, maxIndex)
    }

    if (low == high) (low, matrix(low).indexOf(matrix(low).max))
    else {
      val maxLow = matrix(low).indexOf(matrix(low).max)
      if (ordering.compare(matrix(low)(maxLow), matrix(high)(maxLow)) >= 0)
        return (low, maxLow)
      (high, matrix(high).indexOf(matrix(high).max))
    }
  }
}
