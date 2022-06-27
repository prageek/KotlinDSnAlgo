package algos

class TrapRainWater {
}
fun trap(height: IntArray): Int {
    var left = 0 // start from start
    var right = height.lastIndex // height.size -1
    var wLevel = 0 // no water

    // each bar is 1
    // we need to trap water between leftMax value and rightMax value to hold max wLevel
    var leftMax = 0
    var rightMax = 0

    while(left < right){
        leftMax = maxOf(leftMax, height[left])
        rightMax = maxOf(rightMax, height[right])
        if(height[left] <= height[right]){
            wLevel += leftMax - height[left] // each bar is 1 and difference is water level
            left++
        } else {
            wLevel += rightMax - height[right]
            right--
        }
    }

    return wLevel
}

fun main(){
    /*
    var arr = IntArray(size){0}  // construct with size and fill array with 0
    var arr = IntArray(size){it} // construct with size and fill with its index
    var arr = intArrayOf(1, 2, 3, 4, 5) // create an array with 5 values

    var Arr1 = arrayOf(1,10,4,6,15)
    var Arr2 = arrayOf<Int>(1,10,4,6,15)
    var Arr3 = arrayOf<String>("Surat","Mumbai","Rajkot")
    var Arr4 = arrayOf(1,10,4, "Ajay","Prakesh")
    var Arr5: IntArray = intArrayOf(5,10,15,20)


    */

    val input = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)

    println("Max amount of water held = ${trap(input)}")

}