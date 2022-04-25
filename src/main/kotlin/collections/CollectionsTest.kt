package collections

import LinkedList
import linkedlist.Node

fun <T : Any> LinkedList<T>.printReverse() {
    this.nodeAt(0)?.printInReverse()
}

fun <T : Any> Node<T>.printInReverse() {
    this.next?.printInReverse()
    if (this.next != null) {
        print(" <- ")
    }
    print("${this.value}")
}

/**
 * Given the head node of a linked list, the task is to reverse the linked list
 */
fun <T : Any> reversedLinkedList(head : Node<T>?) : Node<T>? {
    var currentNode = head
    var nextNode : Node<T>?
    var prevNode : Node<T>? = null

    while(currentNode != null){
        nextNode = currentNode.next
        currentNode.next = prevNode
        prevNode = currentNode
        currentNode = nextNode
    }

    return prevNode
}

/**
 * Remove duplicate nodes
 * ex : 1, 3, 3, 5. 7, 7, 9 -> 1, 3, 5, 7, 8
 *
 */
fun <T : Any> removeDuplicates(head: Node<T>?) : Node<T>? {
    var current = head
    val start = current
    while (current != null) { // Need to move the current
        var temp = current
        while (temp != null && temp.value == current.value) {
            temp = temp.next
        }
        current.next = temp
        current = current.next // Moving current ahead
    }

    return start
}

fun <T : Any> LinkedList<T>.getMiddleNode(): Node<T>? {
//    var slow : Int = -1
//    var fast : Int = 0
//    var node = this.nodeAt(0)
//    while (node?.next != null){
//        fast += 1
//        node = node.next
//        fast++
//        slow++
//    }
//    return this.nodeAt(slow)

    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)

    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }
    return slow
}

fun <T : Comparable<T>> LinkedList<T>.mergeSorted(other: LinkedList<T>): LinkedList<T> {
    if (this.isEmpty()) return other
    if (other.isEmpty()) return this

    val result = LinkedList<T>()// Here we merge each node to this new list
    var left = head
    var right = other.head

    while (left != null && right != null) {
        if (left.value < right.value) {
            result.append(left.value)
            left = left.next
        } else {
            result.append(right.value)
            right = right.next
        }
    }
    while (left != null) {
        result.append(left.value)
        left = left.next
    }

    while (right != null) {
        result.append(right.value)
        right = right.next
    }

    return result
}

private fun <T : Comparable<T>> appendNode(node: Node<T>, out: LinkedList<T>): Node<T>? {
    out.append(node.value)
    return node.next
}


fun main() {

    val list = LinkedList<Int>()

    // Typical way to populate the LL
    list.push(1)
    list.push(2)
    list.push(5)
    list.push(4)
    list.push(9)

    print("$list")
    println("\n Reverse ^ ")
    list.printReverse()
    println("\n Find the middle node :")
    println("Middle ${list.getMiddleNode()}")
    println("\n Merge Two linked list \n")

    // Using varargs to populate the LL
    val newList1 = LinkedList<Int>(-4, 0, 3, 5, 7)
    val newList2 = LinkedList<Int>(4, 6, 9, 11, 15)
    print("$newList1")
    println()
    print("$newList2")
    println("\n Merged list :  \n")
    val sortedList = newList1.mergeSorted(newList2)
    print("$sortedList")

    println("\n Reverse linkedlist given a head node -->\n")

    val reversedNode = reversedLinkedList(newList2.head)
    print("$reversedNode")

    val duplicateList = LinkedList<Int>(4, 4,  6, 9, 9, 9, 11, 15, 15, 15)

    println("\n Remove duplicate elements : ")
    print("$duplicateList")
    println()
    val newUniqueNode = removeDuplicates(duplicateList.head)
    print("$newUniqueNode")


}