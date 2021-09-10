package com.example.myapplication2
fun main() {
    println("Enter String: ")
    val s = readLine()!!
    println("Enter Patten: ")
    val p = readLine()!!
    if(s.length >=0 && p.length <= 2000)
    {
        println(checkPattern(s,p))
    }
}
fun characters(p: String): Boolean
{
    for(i in p.indices)
    {
        if(p[i] == '?' || p[i] == '*')
            return false
    }
    return true
}
fun checkPattern(s: String, p:String): Boolean{
    var i = 0
    var j = 0
    var flag = true
    if (characters(p))
        return s.equals(p)
    else{
        while (i < s.length && j < p.length) {
            if (p[j] == '?' || s[i] == p[j]) {
                i++
                j++
            } else if (p[j] == '*') {
                j++
                if (j != p.length)
                    i = s.indexOf(p[j],i+1)
            } else {
                flag = false
                break
            }
        }
        return flag
    }
}
class Challenge1 {

}
