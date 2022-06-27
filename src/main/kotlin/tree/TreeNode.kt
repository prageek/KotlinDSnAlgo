import list.ArrayListQueue
import kotlin.math.abs

/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
//* class TreeNode(var `val`: Int) {
//  *     var left: TreeNode? = null
//  *     var right: TreeNode? = null
//  * }

class TreeNode<T>(val value: T) {
  private val children: MutableList<TreeNode<T>> = mutableListOf()
  var left : TreeNode<T>? = null
  var right : TreeNode<T>? = null


  fun add(child: TreeNode<T>) = children.add(child)

  // solution
  fun printEachLevel() {
    val queue = ArrayListQueue<TreeNode<T>>()
    var nodesLeftInCurrentLevel = 0

    queue.enqueue(this)
    while (queue.isEmpty.not()) {
      nodesLeftInCurrentLevel = queue.count

      while (nodesLeftInCurrentLevel > 0) {
        val node = queue.dequeue()
        node?.let {
          print("${node.value} ")
          node.children.forEach { queue.enqueue(it) }
          nodesLeftInCurrentLevel--
        } ?: break
      }

      println()
    }
  }

  /**
   * LC https://leetcode.com/problems/find-leaves-of-binary-tree
   */
  fun findLeaves(root: TreeNode<Int>?): List<List<Int>> {

    val map = mutableMapOf<Int, MutableList<Int>>()

    fun getLevel(root: TreeNode<Int>?): Int {
      if(root == null) return 0
      val left = getLevel(root.left)
      val right = getLevel(root.right)
      val level = maxOf(left, right) + 1
      map.getOrPut(level, {mutableListOf()}).add(root.value)
      root.left = null // Remove leaf
      root.right = null
      return level
    }

    getLevel(root)
    return map.values.toList()
  }
/*
  fun isBalanced(root: TreeNode<T>?): Boolean {
    return helper(root).first
  }
  private fun helper(root: TreeNode<T>?): Pair<Boolean, Int> {
    if (root == null) return Pair(true, 0)
    val left = helper(root.left)
    val right = helper(root.right)
    if (!left.first || !right.first || Math.abs(left.second - right.second) > 1)
      return Pair(false, -1)
    return Pair(true, maxOf(left.second, right.second) + 1)
  }
  */

  fun isBalanced(root: TreeNode<T>?): Boolean {
    // at max difference in height between two node in same level should be <= 1
    // 15 -> h 1 (diff 0), 7 -> h 1 (diff 0)=> at 20 node height = maxOf(1, 1) + 1 = 2 (diff 1-1)
    // 9 -> h 1 (diff 0) , 20 -> h  2 (coz it has two nodes), diff (2-1) <= 1
    // 3 -> h = maxOf (2, 1) = 2, (diff 2-1) <= 1 so its true
    val result = dfs(root)
    return result.first
  }

  private fun dfs(node : TreeNode<T>?) : Pair<Boolean, Int>{
    if(node == null) return Pair(true, 0)

    val left = dfs(node.left)
    val right = dfs(node.right)
    //if either of the pairs return False, or height is > 1 it will be not balance
    if(!left.first || !right.first || Math.abs(left.second - right.second) > 1) {
      return Pair(false, -1)
    }

    return Pair(true, maxOf(left.second, right.second) + 1) // +1 Since you have stepped into a level
  }

}