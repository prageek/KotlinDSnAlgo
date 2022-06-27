package algos


// Recursion O(2^n)
fun climbingStairsRecursive(nStairs: Int): Int {
    if (nStairs <= 1) {
        return 1
    }
    return climbingStairsRecursive(nStairs - 1) + climbingStairsRecursive(nStairs - 2)
}

/**
 * bottom up
 * Complexity : Time: O(n) ; Space: O(n)
 */
fun climbingStairsRecursionMemoization(n: Int): Int {
    val mem = mutableMapOf<Int, Int>()
    mem[1] = 1
    mem[2] = 2

    return climbingStairsHelper(n - 1, mem) + climbingStairsHelper(n - 2, mem)
}

fun climbingStairsHelper(n: Int, mem: MutableMap<Int, Int>): Int {
    if (mem.contains(n)) {
        return mem.get(n)!!
    }
    mem[n] = (climbingStairsHelper(n - 1, mem) + climbingStairsHelper(n - 2, mem))
    return mem[n]!!
}

/**
 * top down
 * Complexity : Time: O(n) ; Space: O(1)
 */
fun climbingStairsIterativeTopDown(n:Int) : Int {
    // from Nth stair there is only 1 step can be taken
    // from N-1th stair it can be taken 1 step or 1 two steps sp 2 methods
    if(n<=1){
        return 1
    }

    var prev1 = 1
    var prev2 = 2

    for(i in 3..n){
        val newVal = prev1 + prev2
        prev1 = prev2
        prev2 = newVal
    }
    return prev2
}

fun main() {

    var steps = 3
    println("climbingStairsRecursive $steps- ${climbingStairsRecursive(steps)}")
    steps = 4
    println("climbingStairsRecursive $steps- ${climbingStairsRecursive(steps)}")
    steps = 5
    println("climbingStairsRecursive $steps- ${climbingStairsRecursive(steps)}")
    steps = 10
    println("climbingStairsRecursive $steps- ${climbingStairsRecursive(steps)}")

    steps = 3
    println("climbingStairsRecursionMemoization $steps- ${climbingStairsRecursionMemoization(steps)}")
    steps = 4
    println("climbingStairsRecursionMemoization $steps- ${climbingStairsRecursionMemoization(steps)}")
    steps = 5
    println("climbingStairsRecursionMemoization $steps- ${climbingStairsRecursionMemoization(steps)}")
    steps = 10
    println("climbingStairsRecursionMemoization $steps- ${climbingStairsRecursionMemoization(steps)}")


    steps = 3
    println("climbingStairsIterativeTopDown $steps- ${climbingStairsIterativeTopDown(steps)}")
    steps = 4
    println("climbingStairsIterativeTopDown $steps- ${climbingStairsIterativeTopDown(steps)}")
    steps = 5
    println("climbingStairsIterativeTopDown $steps- ${climbingStairsIterativeTopDown(steps)}")
    steps = 10
    println("climbingStairsIterativeTopDown $steps- ${climbingStairsIterativeTopDown(steps)}")
}


