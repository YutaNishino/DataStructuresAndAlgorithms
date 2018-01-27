package algorithm.search

object BinarySearch {
  // We assume input array is sorted!
  def search[T](array: Array[T], target: T)(implicit ordering: Ordering[T]): Boolean = {
    var low = 0
    var high = array.length - 1
    while(low <= high) {
      val mid = (low + high) / 2
      val comp = ordering.compare(target, array(mid))
      if (comp < 0) high = mid - 1
      else if (comp > 0) low = mid + 1
      else {
        return true
      }
    }
    false
  }
}
