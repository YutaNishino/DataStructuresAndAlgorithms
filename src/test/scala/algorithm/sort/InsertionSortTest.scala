package algorithm.sort

import algorithm.UnitTest

class InsertionSortTest extends UnitTest("InsertionSort") {
  it should "be the same ordering" in {
    val sorted = Array(1, 2, 3)
    val unsorted = Array(2, 3, 1)
    InsertionSort.sort(unsorted)
    sorted shouldEqual unsorted
  }
}
