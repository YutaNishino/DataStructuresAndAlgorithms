package algorithm.peakfinding

object OneDPeak {
  def searchPeak[T](array: Array[T])(implicit ordering: Ordering[T]): Int = {
    var low = 0
    var high = array.length - 1
    while(low <= high - 2) {
      val mid = (low + high) / 2
      val compLeft = ordering.compare(array(mid), array(mid - 1))
      val compRight = ordering.compare(array(mid), array(mid + 1))
      if (compLeft < 0) high = mid - 1
      else if (compRight < 0) low = mid + 1
      else return mid
    }

    // If the program reaches here, elements to be searched are only low and high
    if (ordering.compare(array(low), array(high)) > 0) low
    else high
  }
}
