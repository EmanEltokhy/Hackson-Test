package com.example.myapplication2
import java.util.*
fun main()
{
    val reader = Scanner(System.`in`)
    println("Enter matrix dimensions: ")
    val n = reader.nextInt()
    val matrix = Array(n){IntArray(n)}

    if (n in 2 .. 30) {
        println("Enter Matrix: ")
        for (i in 0 until n) {
            for (j in 0 until n) {
                matrix[i][j] = reader.nextInt()
            }
        }

        println("Output: " + moves(matrix))
    }
}

fun moves(arr: Array<IntArray>): Int {

    var rowtomove = 0
    var coltomove = 0
    var rowoncnt = 0
    var coloncnt = 0

    for (i in arr.indices) {
        rowoncnt += arr[0][i]
        coloncnt += arr[i][0]
        if (arr[i][0] == i % 2) {
            rowtomove++
        }
        if (arr[0][i] == i % 2) {
            coltomove++
        }
    }
    if (rowoncnt < arr.size / 2 || rowoncnt > (arr.size) / 2) {
        return -1
    }
    if (coloncnt < arr.size / 2 || coloncnt > (arr.size) / 2) {
        return -1
    }
    if (arr.size % 2 == 1) {
        if (coltomove % 2 == 1) {
            coltomove = arr.size - coltomove
        }
        if (rowtomove % 2 == 1) {
            rowtomove = arr.size - rowtomove
        }
    } else {
        coltomove = Math.min((coltomove), arr.size - coltomove)
        rowtomove = Math.min((rowtomove), arr.size - rowtomove)
    }
    return (coltomove + rowtomove) / 2
}



class Challenge6 {
}