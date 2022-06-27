package basics

class ExampleLooping {
}

fun main(){
    val str = "Kotlin!"


    for (i in 0..str.length-1){
        println(str[i])
    }
    println("--------------------------")

    for(i in 0 until str.length){
        println(str[i])
    }
    println("--------------------------")

    for(i in str.indices) {
        println(str[i])
    }
    println("--------------------------")

    for (element in str) {
        println(element)
    }
    println("--------------------------")

    str.forEach { c->
        println(c)
    }

}

fun FrequencySort(str: String) : String {
    val frq = str.groupingBy { it }.eachCount()
    val sorted = frq.entries.sortedByDescending { (c, count) -> count }
    val res = StringBuilder()
    sorted.forEach {
        (c, count) -> repeat(count)  {res.append(c)}
    }
    return sorted.toString()
}