package datastructure.stack

import datastructure.UnitTest

class AStackTest extends UnitTest("AStack") {
  it should "return the same value" in {
    val stack = new AStack[Int]()
    stack.push(1)
    stack.push(2)
    val peek = stack.peek
    val pop = stack.pop
    peek shouldEqual pop
  }
}
