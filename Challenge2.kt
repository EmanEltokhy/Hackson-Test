package com.example.myapplication2
fun main()
{
    println("Enter Expression: ")
    val exp: String = readLine()!!
    println(calculateEXP(exp))
}
fun calculateEXP(exp: String): Int
{
    var num = 0
    var result = 0
    var sign = 1
    for(i in exp.indices)
    {
        if(exp[i].isDigit())
            num = num* 10 + (exp[i]-'0')
        else if(exp[i] == '+' || exp[i] == '-')
        {
            result += num*sign
            sign = if(exp[i]=='+') 1 else -1
            num = 0
        }
    }
    result += num*sign
    return result
}
class Challenge2 {
}