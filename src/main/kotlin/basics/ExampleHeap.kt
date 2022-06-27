package basics

import java.util.*

class KthLargest (val k : Int, nums: IntArray) {
    private val minHeap = PriorityQueue<Int>()
    // = PriorityQueue(k, kotlin.Comparator { o1, o2 -> o1 - o2 })
    init {
        nums.forEach { add(it)}
    }

    fun add(`val` : Int) : Int{
        if(minHeap.size < k) {
            minHeap.offer(`val`)
        } else if(minHeap.peek() < `val`){
            minHeap.offer(`val`)
        }

        return minHeap.peek()
    }
}

fun main() {
    val input = intArrayOf(3,2,3,1,2,4,5,5,6)
    val k = 4
    println("\n $k th largest : ${findKthLargest(input, k)}")
    println("\n $k th largest : ${findKthLargest2(input, k)}")

    val kth = KthLargest(4, intArrayOf(3,2,3,1,2,4,5,5,6))
    println(kth.add(4))
}

//Time = o(n log n)
fun findKthLargest(nums: IntArray, k: Int): Int {
    val N = nums.size
    nums.sort()
    return nums[N - k]
}

//Time = o(n log k)
//Space = o(k)
fun findKthLargest2(nums: IntArray, k: Int): Int {
    // init heap 'the smallest element first'
    val heap = PriorityQueue<Int>()//{n1,n2 -> n1-n2}

    // keep k largest elements in the heap
    for (n in nums) {
        heap.offer(n);
        if (heap.size > k)
            heap.poll()
    }

    // output
    return heap.poll()
}

//Time = o(n) average but o(n^2) worst
//Space = o(1)
//Quick select
//youtube.com/watch?v=XEmy13g1Qxc
fun findNthLargest(nums: IntArray, k: Int): Int {
    val k = nums.size - k //index of kth largest element after quick select

    fun quickSelect(l:Int, r:Int):Int{
        var pivot = nums[r]
        var p = l
        for(i in l..r-1){
            if(nums[i] <= pivot){
                val temp = nums[p]
                nums[p] = nums[i]
                nums[i] = temp

                p++
            }
        }

        val temp = nums[p]
        nums[p] = nums[r]
        nums[r] = temp

        if(p>k){
            return quickSelect(l,p-1)
        }else if(p<k){
            return quickSelect(p+1,r)
        }else{
            //p==k
            return nums[p]
        }

    }

    return quickSelect(0,nums.size-1)
}