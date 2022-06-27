package algos

class MeetingRoomsII {
}

fun main() {

    Pair(10, 20)
    val intervals = arrayOf<IntArray>(intArrayOf(0, 30), intArrayOf(10, 15), intArrayOf(20, 35))

    println("min room req : ${minMeetingRooms(intervals)}")
}

// Meeting rooms II
fun minMeetingRooms(intervals:Array<IntArray>) : Int {

    val start = intervals.map { it[0] }.sorted()
    val end = intervals.map { it[1] }.sorted()

    var st =0
    var et = 0
    var resut = 0
    var count = 0
    while (st < start.size) {
        if(start[st] < end[et]){
            count+=1
            st+=1
        } else {
            et+=1
            count-=1
        }
        resut = Math.max(count, resut)
    }
    return resut
}
