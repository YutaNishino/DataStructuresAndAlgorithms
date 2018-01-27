package algorithm.search

object SequentialSearch {
  def search[T](array: Array[T], target: T)(implicit ordering: Ordering[T]): Boolean = {
    for (element <- array) {
      if (ordering.compare(target, element) == 0) return true
    }
    false
  }
}
