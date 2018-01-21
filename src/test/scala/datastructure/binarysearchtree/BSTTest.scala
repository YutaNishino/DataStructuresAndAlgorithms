package datastructure.binarysearchtree

import datastructure.UnitTest

class BSTTest extends UnitTest("BST") {
  it should "be the same value" in {
    val bst = new BST[Int, String]()
    bst.insert(1, "test")
    bst.insert(2, "test2")
    bst.find(1).get shouldEqual "test"
    bst.find(2).get shouldEqual "test2"
    bst.remove(2)
    bst.size shouldEqual 1
  }
}
