package KotlinLoops

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val mapped = mutableMapOf<Int, Int>()

        nums.forEachIndexed { index: Int, num: Int ->
            val diff = target - num
            if (mapped.contains(diff)) {
                return intArrayOf(mapped[diff]!!, index)
            } else
                mapped[num] = index
        }

        return intArrayOf()
    }


}

fun main() {
    println("${TwoSum().twoSum(intArrayOf(2, 7, 8, 9, 10), 9)}")
}

