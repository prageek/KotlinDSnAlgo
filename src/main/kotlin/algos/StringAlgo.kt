package algos

import stack.Stack
import stack.StackImpl
import kotlin.math.max

class StringAlgo {

    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var left = 0
        var right = 0
        var maxLength = 0
        while (right < s.length) {
            if (!set.contains(s.get(right))) {
                set.add(s.get(right++))
                maxLength = max(maxLength, set.size)
            } else {
                set.remove(s.get(left++))
            }
        }
        return maxLength
    }

    //---------------------------

    fun isPalindrome(s: String): Boolean {
        var l=0
        var r=s.length-1

        while(l<r){
            while(l<r && !(alphaNum(s[l]))){
                l=l+1
            }

            while(r>l && !(alphaNum(s[r]))){
                r=r-1
            }

            if(s[l].toLowerCase() != s[r].toLowerCase()){
                return false
            }
            l = l+1
            r=r-1

        }
        return true
    }

    fun alphaNum(c: Char): Boolean {

        if (c !in 'A'..'Z' && c !in 'a'..'z' && c !in '0'..'9') {
            return false
        }
        return true
    }
    //------------------------


    fun isValidParentheses(s:String) : Boolean {
        val stack = StackImpl<Char>()

        s.toCharArray().forEach { c ->
            if(c == '{')
                stack.push(c)
            if( c == '[')
                stack.push(c)
            if (c == '(')
                stack.push(c)
            else if(stack.isEmpty || stack.pop() != c){
                return false
            }
        }
        return stack.isEmpty
    }
}

fun main(){

    println("max uniwur substring length : ${StringAlgo().lengthOfLongestSubstring("abcabcbb")}")


    val p1 = "({[]})"
    val p2 = "{([]})"
    val p3 = "(([]}))"
    println("is valid $p1 : ${StringAlgo().isValidParentheses(p1)}")
    println("is valid $p2 : ${StringAlgo().isValidParentheses(p2)}")
    println("is valid $p3 : ${StringAlgo().isValidParentheses(p3)}")
}