package datastructure.util

class DLink[E](item: Option[E], nextVal: Option[DLink[E]], prevVal: Option[DLink[E]]) {
  private var linkElement: Option[E] = item

  private var nextLink: Option[DLink[E]] = nextVal

  private var prevLink: Option[DLink[E]] = prevVal

  def next: Option[DLink[E]] = nextLink

  def setNext(nextVal: Option[DLink[E]]): Unit = nextLink = nextVal

  def prev: Option[DLink[E]] = prevLink

  def setPrev(prevVal: Option[DLink[E]]): Unit = prevLink = prevVal

  def element: Option[E] = linkElement

  def setElement(item: Option[E]): Unit = linkElement = item
}
