package datastructure.heap

import datastructure.UnitTest

class BinMaxHeapTest extends UnitTest("BinMaxHeap") {
  it should "be the same value" in {
    val a = Array[Int](1,2,3,4,5,6)
    val heap = new BinMaxHeap(a)
    val maxValue = heap.removeMax().get
    maxValue shouldEqual 6
    heap.insert(10)
    heap.remove(2).get shouldEqual 5
    heap.removeMax().get shouldEqual 10
  }
}
