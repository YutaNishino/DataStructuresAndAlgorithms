package datastructure.queue

import datastructure.UnitTest

class AQueueTest extends UnitTest("AQueue"){
  it should "be the same value" in {
    val queue = new AQueue[Int]()
    val firstvalue = 1
    queue.enqueue(firstvalue)
    queue.enqueue(2)
    val secondvalue = queue.dequeue
    firstvalue shouldEqual secondvalue.get
  }
}
