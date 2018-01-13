package datastructure.util

class Link[E](item: Option[E], nextVal: Option[Link[E]]) {
  private var linkElement: Option[E] = item

  private var nextLink: Option[Link[E]] = nextVal

  def next: Option[Link[E]] = nextLink

  def setNext(nextVal: Option[Link[E]]): Unit = nextLink = nextVal

  def element: Option[E] = linkElement

  def setElement(item: Option[E]): Unit = linkElement = item
}
