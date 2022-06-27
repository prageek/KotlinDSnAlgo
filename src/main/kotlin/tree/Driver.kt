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

fun main() {
  val tree = makeTree()
  tree.printEachLevel()

  findLeaves(tree)
}

fun makeTree(): TreeNode<Int> {
  // Build the sample tree shown in the diagram
  // Root of the tree
  val tree = TreeNode(15)

  // Second level
  val one = TreeNode(1)
  tree.add(one)

  val seventeen = TreeNode(17)
  tree.add(seventeen)

  val twenty = TreeNode(20)
  tree.add(twenty)

  // Third level
  val one2 = TreeNode(1)
  val five = TreeNode(5)
  val zero = TreeNode(0)
  one.add(one2)
  one.add(five)
  one.add(zero)

  val two = TreeNode(2)
  seventeen.add(two)

  val five2 = TreeNode(5)
  val seven = TreeNode(7)
  twenty.add(five2)
  twenty.add(seven)

  return tree
}

//fun findLeaves(root: TreeNode?): List<List<Int>> {
//  val result = mutableListOf<List<Int>>()
//  dfs(root, 0, result)
//
//  return result
//}
//
//fun dfs(node: TreeNode?, l : Int, result : List<List<Int>>) : Int {
//  if(node==null) return -1
//  var level = l
//  val left = dfs(node.left, level, result)
//  val right = dfs(node.right, level, result)
//
//  level = Math.max(left, right) // even if you are on a lower level, we need to consider the level higher that you be grouped with, ex: 4,5 at level 2 and 3 is at level 1
//
//  //result[level].
//
//  return level + 1 // You have visited the node
//}

fun findLeaves(root: TreeNode<Int>?): List<List<Int>> {
  val map = mutableMapOf<Int, MutableList<Int>>()

  fun getLevel(root: TreeNode<Int>?): Int {
    if(root == null) return 0
    val left = getLevel(root.left)
    val right = getLevel(root.right)
    val level = maxOf(left, right) + 1
    map.getOrPut(level, {mutableListOf()}).add(root.value)
    return level
  }

  getLevel(root)
  return map.values.toList()
}