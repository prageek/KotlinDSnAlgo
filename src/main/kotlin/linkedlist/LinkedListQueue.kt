

package linkedlist

import queue.Queue
import doublylinkedlist.DoublyLinkedList

class LinkedListQueue<T : Any> : Queue<T> {
  private val list = DoublyLinkedList<T>()

  private var size = 0

  override val count: Int
    get() = size

  override fun enqueue(element: T): Boolean {
    list.append(element)
    size++
    return true
  }

  override fun dequeue(): T? {
    val firstNode = list.first ?: return null
    size--
    return list.remove(firstNode)
  }

  override fun peek(): T? = list.first?.value

  override fun toString(): String = list.toString()
}
