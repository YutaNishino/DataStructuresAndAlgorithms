package algorithm.sort

import algorithm.UnitTest

class SelectionSortTest extends UnitTest("SelectionSort") {
  it should "be the same ordering" in {
    val sorted = Array(1, 2, 3)
    val unsorted = Array(2, 3, 1)
    SelectionSort.sort(unsorted)
    sorted shouldEqual unsorted
  }
}
