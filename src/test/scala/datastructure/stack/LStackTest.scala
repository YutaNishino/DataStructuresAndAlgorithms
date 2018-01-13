package datastructure.stack

import datastructure.UnitTest

class LStackTest extends UnitTest("LStack") {
  it should "return the same value" in {
    val stack = new LStack[Int]()
    stack.push(1)
    stack.push(2)
    val peek = stack.peek
    val pop = stack.pop
    peek shouldEqual pop
  }
}
