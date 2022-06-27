package solid.composition

import kotlin.math.max

/**
 * Classical example of the limitations in inheritance and why we should prefer composition or delegation over it.
 * Check the other package for the composition example
 * https://www.youtube.com/watch?v=baeHfmw1dis
 */
class Inheritance {
}

abstract class Animal {
    abstract val legs: Int
    abstract val arms : Int
    abstract val talk : String
    abstract val eats : String

    abstract fun canTalk() : String
    abstract fun canEat() : Boolean
    abstract fun canMove() : String

}

class Dog(override val legs: Int, override val arms: Int, override val talk: String, override val eats: String) : Animal() {
    override fun canTalk(): String = "$talk ..!!"

    override fun canEat(): Boolean = eats == "meat"

    override fun canMove(): String = "Fast"

}

//class Fish(override val legs: Int, override val arms: Int, override val talk: String, override val eats: String) : Animal(){
//
//}

private fun getMessage(s: String, a: IntArray): String? {
    val chars = s.toCharArray()
    // Initial message
// First letter in the array
    var finalMessage = chars[0].toString()
    // Person in spot 0 will tell me where to send the message
    var destination = a[0]
    while (destination != 0) {
        finalMessage += chars[destination]
        destination = a[destination]
    }
    return finalMessage
}

fun solution(S: String, A: IntArray): String {
    // write your code in Kotlin 1.3.11 (Linux)

    // A have no duplicates

    val result = StringBuilder() // We going to append letters to this
    val letters = S.toCharArray()
    result.append(letters[0])// Start with 0th all the time

    var jumpTo = A[0] // Same as S[0]

    while (jumpTo != 0){
        result.append(letters[jumpTo])
        jumpTo = A[jumpTo]
    }
    return result.toString()
}

fun main(){
//    val r = solution("cdeo", intArrayOf(3, 2, 0, 1))
//    println(r)
//
    val t = getTriangles(intArrayOf(8, 4, 8, 9, 7))
    println(t)
}


fun getTriangles(A: IntArray): Int {
    // write your code in Kotlin 1.3.11 (Linux)

    // We are trying to find the max so if we sort this first it will be easier to find the max combination with
    if(A.size < 3) return 0 // No need to check for triangle

    A.sort()
    var result = 0
    for( i in 0..A.size - 3){
        if(A[i] + A[i+1] > A[i+2]) {
            val tot = A[i] + A[i+1] + A[i+2]
            result = max(tot, result)
        }
    }
    return result
}