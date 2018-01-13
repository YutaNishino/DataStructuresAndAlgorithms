package datastructure.list

import datastructure.UnitTest

class LListTest extends UnitTest("LList") {
  it should "contain 1" in {
    val list = new LList[Int]()
    list.insert(1)
    list.getValue.get == 1
  }

  it should "return the same value" in {
    val list = new LList[Int]()
    list.append(1)
    list.append(2)
    list.append(3)
    list.next
    list.next
    list.next
    list.prev
    val value1 = list.getValue
    list.moveToStart
    list.moveToPos(2)
    val value2 = list.getValue
    list.moveToEnd
    list.prev
    val value3 = list.getValue
    value1 shouldEqual value2
    value2 shouldEqual value3
  }
}

