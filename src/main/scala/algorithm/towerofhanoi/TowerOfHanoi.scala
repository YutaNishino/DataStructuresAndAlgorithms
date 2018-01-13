package algorithm.towerofhanoi

object Operation extends Enumeration {
  type Operation = Value
  val CALL, MOVE = Value
}

import java.util.Stack

import Operation._

case class TOH(operation: Operation, size: Int, start: Int, goal: Int, temp: Int) {
  def this(size: Int, start: Int, goal: Int, temp: Int) = this(CALL, size, start, goal, temp)

  def this(size: Int, start: Int, goal: Int) = this(MOVE, size, start, goal, -1)

  def move(): Unit = println(s"Move ring $size from pole $start to pole $goal")

  def solveTOH (height: Int): Unit = {
    val stack = new Stack[TOH]()
    stack.push (new TOH (height, 1, 2, 3) )
    while (stack.size() > 0) {
      val item: TOH = stack.pop
      item.operation match {
        case MOVE => item.move()
        case CALL if item.size > 0 =>
          stack.push (new TOH (item.size - 1, item.temp, item.goal, item.start))
          stack.push (new TOH (item.size, item.start, item.goal))
          stack.push (new TOH (item.size - 1, item.start, item.temp, item.goal))
        case _ =>
      }
    }
  }
}