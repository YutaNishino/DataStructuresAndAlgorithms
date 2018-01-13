package datastructure.queue

import datastructure.UnitTest

class LQueueTest extends UnitTest("LQueue"){
  it should "be the same value" in {
    val queue = new LQueue[Int]()
    val firstvalue = 1
    queue.enqueue(firstvalue)
    queue.enqueue(2)
    val secondvalue = queue.dequeue
    firstvalue shouldEqual secondvalue.get
  }
}

