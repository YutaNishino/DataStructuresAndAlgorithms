package algorithm.peakfinding

import algorithm.UnitTest

class OneDPeakTest extends UnitTest("OneDPeak") {
  it should "be the same value" in {
    val array = Array(1, 2, 3, 4)
    val ans = 3
    OneDPeak.searchPeak(array) shouldEqual ans
    val array2 = Array(1, 2, 7, 6, 5, 4, 3)
    val ans2 = 2
    OneDPeak.searchPeak(array2) shouldEqual ans2
  }
}

