package com.example.myapplication2

import java.util.*

fun main()
{
    val reader = Scanner(System.`in`)
    println("Enter matrix dimensions: ")
    val m = reader.nextInt()
    val n = reader.nextInt()
    val matrix = Array(m){IntArray(n)}

    println("Enter Matrix: ")
    for (i in 0 until m) {
        for (j in 0 until n) {
           matrix[i][j] = reader.nextInt()
        }
    }

    println("Output: " + calculateHealth(matrix))

}
fun calculateHealth(dungeon: Array<IntArray>): Int
{
    val result = Array(dungeon.size){IntArray(dungeon[0].size)}
    for(i in dungeon.size-1 downTo  0)
    {
        //val row = dungeon[i];
        for(j in dungeon[0].size-1 downTo  0)
        {
            val rowEnd = i == dungeon.size-1
            val columnEnd = j == dungeon[0].size-1
            if(rowEnd && columnEnd)
                result[i][j] = dungeon[i][j]
            else if(!rowEnd && !columnEnd)
                result[i][j] = dungeon[i][j] - Math.min(result[i+1][j], result[i][j+1])
            else
                result[i][j] = dungeon[i][j]-result[i + if(rowEnd)  0 else 1][j + if(columnEnd)  0 else 1]

            result[i][j] = if(result[i][j] > 0)  0 else -result[i][j]
        }
    }
    return result[0][0] + 1
}


class Challenge4 {
}