package algorithm.sort

import algorithm.UnitTest

class HeapSortTest extends UnitTest("HeapSort") {
  it should "be the same ordering" in {
    val sorted = Array(1, 2, 3, 4, 5, 6, 7, 8 ,9)
    val unsorted = Array(6, 2, 5, 9, 3, 1, 4, 8, 7)
    HeapSort.sort(unsorted)
    sorted shouldEqual unsorted
  }
}
