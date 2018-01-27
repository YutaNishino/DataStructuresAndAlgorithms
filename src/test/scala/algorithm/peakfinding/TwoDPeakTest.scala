package algorithm.peakfinding

import algorithm.UnitTest

class TwoDPeakTest extends UnitTest("TwoDPeak") {
  it should "be the same value" in {
    val matrix = Array(Array(1, 2, 3, 4), Array(0, 1, 2, 3))
    val ans = (0, 3)
    TwoDPeak.searchPeak(matrix) shouldEqual ans
    val matrix2 = Array(Array(0, 0, 0, 0, 0, 1, 2), Array(1, 2, 7, 6, 5, 4, 3))
    val ans2 = (1, 2)
    TwoDPeak.searchPeak(matrix2) shouldEqual ans2
  }
}
