package datastructure.deque

import datastructure.UnitTest

class ADequeTest extends UnitTest("ADeque") {
  it should "be the same value" in {
    val deque = new ADeque[Int]()
    val firstValue = 1
    deque.addFirst(firstValue)
    deque.addFirst(2)
    deque.addLast(3)
    deque.pollFirst
    deque.pollLast
    val secondValue = deque.peekFirst.get
    val thirdValue = deque.pollLast.get
    firstValue shouldEqual secondValue
    secondValue shouldEqual thirdValue
  }
}
