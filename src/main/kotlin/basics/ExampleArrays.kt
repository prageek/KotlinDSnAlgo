package basics

class ExampleArrays {
}

fun main() {
    val n1 = intArrayOf(4,9,5)
    val n2 = intArrayOf(9, 4, 9, 8, 4)
    print("input n1 :")
    n1.forEach { print(it) }
    print("\n input n2 :")
    n2.forEach { print(it) }
    println("\n out :  ")
    val result = intersect(n1, n2)
    result.forEach { print(it) }

    println("\n \n out :  ")
    val result2 = intersect2(n1, n2)
    result2.forEach { print(it) }
}

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    if(nums1.size>nums2.size){
        return intersect(nums2, nums1)
    }

    val nums2Set = mutableSetOf<Int>()
    nums2.forEach{
        nums2Set.add(it)
    }
    val result = mutableListOf<Int>()
    nums1.forEach{
        if(nums2Set.contains(it)){
            result.add(it)
        }
    }
    return result.toIntArray()
}

fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
    val nums1set = nums1.toSet()
    val intersect = nums1set.filter { nums1.contains(it) }
    return intersect.toIntArray()
}

fun intersectPointers(nums1: IntArray, nums2: IntArray): IntArray {
    nums1.sort()
    nums2.sort()
    var ans = ArrayList<Int>()
    var i = 0
    var j = 0
    while (i < nums1.size && j < nums2.size) {
        when {
            nums1[i] > nums2[j] -> j++
            nums1[i] < nums2[j] -> i++
            else -> {
                ans.add(nums1[i])
                i++
                j++
            }
        }
    }
    return ans.toIntArray()
}
