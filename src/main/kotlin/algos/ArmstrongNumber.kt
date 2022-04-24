package algos

/*
Check if a given number is an Armstrong number
A positive integer is called an Armstrong number of order n if
abcd... = an + bn + cn + dn + ...

ex : 153 = 1*1*1 + 5*5*5 + 3*3*3
 */

fun main(){
    val input = 153
    println("is $input armstrong number : ${isArmstringNumber(153)}")
}
fun isArmstringNumber(num : Int) = run {
    var remainder : Int
    var originalNumber : Int
    var digit =  0
    var count = 0
    originalNumber = num
    while (originalNumber != 0){
        originalNumber /= 10
        digit++
    }
    // digit 1>2>3

    originalNumber = num
    while (originalNumber != 0 ){
        remainder = originalNumber % 10
        count += Math.pow(remainder.toDouble(), digit.toDouble()).toInt()
        originalNumber /= 10
    }

    count == num
}
