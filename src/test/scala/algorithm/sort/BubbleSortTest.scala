package algorithm.sort

import algorithm.UnitTest

class BubbleSortTest extends UnitTest("BubbleSort") {
  it should "be the same ordering" in {
    val sorted = Array(1, 2, 3)
    val unsorted = Array(2, 3, 1)
    BubbleSort.sort(unsorted)
    sorted shouldEqual unsorted
  }
}
