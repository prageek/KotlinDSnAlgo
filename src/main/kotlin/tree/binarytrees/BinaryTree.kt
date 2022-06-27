package tree.binarytrees

import java.util.*


class BinaryTree {

    class Node<T> @JvmOverloads constructor(var `val`: T, var left: Node<T>? = null, var right: Node<T>? = null)

    private fun dfs(root: Node<Int>?, maxSoFar: Int): Int {
        if (root == null) return 0
        var total = 0
        if (root.`val` >= maxSoFar) {
            total++
        }
        // maxSoFar of the child node is the larger value of previous max and current node val
        total += dfs(root.left, Math.max(maxSoFar, root.`val`))
        total += dfs(root.right, Math.max(maxSoFar, root.`val`))
        return total
    }

    fun visibleTreeNode(root: Node<Int>?): Int {
        // Start maxSoFar with smallest integer value possible so any value root has is greater than it
        return dfs(root, Int.MIN_VALUE)
    }

//    fun <T> buildTree(iter: Iterator<String>, f: Function<String?, T>): Node<T>? {
//        val `val` = iter.next()
//        if (`val` == "x") return null
//        val left = buildTree<T>(iter, f)
//        val right = buildTree<T>(iter, f)
//        return Node(f.apply(`val`), left, right)
//    }

    fun splitWords(s: String): List<String?>? {
        return if (s.isEmpty()) java.util.List.of() else Arrays.asList(*s.split(" ").toTypedArray())
    }
}

//
//fun maxPerimeter(arr: IntArray, n: Int) {
//    arr.sort()
//    arr.size
//    // initialize maximum perimeter as 0.
//    var maxi = 0
//
//    // pick up 3 different elements
//    // from the array.
//    for (i in 0 until n - 2) {
//        for (j in i + 1 until n - 1) {
//            for (k in j + 1 until n) {
//
//                // a, b, c are 3 sides of
//                // the triangle
//                val a = arr[i]
//                val b = arr[j]
//                val c = arr[k]
//
//                // check whether a, b, c
//                // forms a triangle or not.
//                if (a < b + c && b < c + a && c < a + b) {
//
//                    // if it forms a triangle
//                    // then update the maximum
//                    // value.
//                    maxi = Math.max(maxi, a + b + c)
//
//            }
//        }
//    }
//
//    // If maximum perimeter is non-zero
//    // then print it.
//    if (maxi > 0) println(
//        "Maximum Perimeter is: "
//                + maxi
//    ) else println(
//        ("Triangle formation "
//                + "is not possible.")
//    )
//}
//


//class Sol {
//    public int dfs(int maxVal, Tree t){
//        if(t == null) return 0; // reached the bottom
//
//        int tot = 0; / # of nodes
//        if(t.x >= maxVal) {
//            tot++; // found the root always to be visible
//        }
//        tot += dfs(Math.max(maxVal, t.x), t.l);
//        tot += dfs(Math.max(maxVal, t.x), t.r);
//        return tot;
//    }
//}

