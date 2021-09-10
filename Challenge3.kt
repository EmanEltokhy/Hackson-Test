package com.example.myapplication2

import java.util.*
import kotlin.collections.HashMap

fun main()
{
    val h:HashMap<Int, Int>  = HashMap<Int, Int>()
    val reader = Scanner(System.`in`)

    println("Enter Matrix dimensions: ")
    val rows: Int = reader.nextInt()
    val columns: Int = reader.nextInt()
    val matrix = Array(rows){IntArray(columns)}
    val newMatrix = Array(rows){IntArray(columns)}
    val arr = IntArray(rows*columns)
    var indx = 0

    println("Enter Matrix: ")
    for(i in 0 until rows)
    {
        for(j in 0 until columns)
        {
            matrix[i][j] = reader.nextInt()
            arr[indx] = matrix[i][j]
            indx++
        }
    }

    arr.sort()

    for(i in arr.indices)
    {
        if(i != 0 && arr[i] == arr[i-1])
        {
            val indices = indices(matrix, arr[i])
            newMatrix[indices[0]][indices[1]] = (h?.get(arr[i]).toString()).toInt()+1
        }
        else {
            val indices = indices(matrix, arr[i])
            val bigNum = biggestNum(newMatrix, indices)
            newMatrix[indices[0]][indices[1]] = bigNum + 1
            if (i+1<arr.count() && arr[i] == arr[i + 1]) {
                    h.put(arr[i], bigNum)
                }
            }
        }
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                print(newMatrix[i][j])
                print(" , ")
            }
            println("")
        }
}

    fun indices(matrix: Array<IntArray>, num: Int): Array<Int> {
        val size = 2
        val arr = Array<Int>(size) {0}
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (num == matrix[i][j]) {
                    arr[0] = i
                    arr[1] = j
                    matrix[i][j] = 0
                    return arr
                }
            }
        }
        return arr
    }
    fun biggestNum(newMatrix: Array<IntArray>, indices: Array<Int>): Int {
        var biggest = 0
            for (j in newMatrix[0].indices) {
                if (newMatrix[indices[0]][j] > biggest) {
                    biggest = newMatrix[indices[0]][j]
                }
            }
            for (j in newMatrix.indices) {
                if (newMatrix[j][indices[1]] > biggest) {
                    biggest = newMatrix[j][indices[1]]
                }
            }
        return biggest
    }

class Challenge3 {
}