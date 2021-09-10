package com.example.myapplication2
import java.util.*
fun main()
{
    val reader = Scanner(System.`in`)
    println("Enter matrix dimensions: ")
    val m = reader.nextInt()
    val n = reader.nextInt()
    val matrix = Array(m){CharArray(n)}
    if (m in 1..8 && n in 1..8) {
        println("Enter Matrix: ")
        for (i in 0 until m) {
            for (j in 0 until n) {
                matrix[i][j] = reader.next()[0]
            }
        }

        println("Output: " + calculateSeats(matrix))
    } else {
        println("Range of m or n isn't correct or both")
    }
}

fun calculateSeats(matrix: Array<CharArray>): Int {
    var counts = 0
    for (m in matrix.indices) {
        for (n in matrix[0].indices) {
            if (matrix[m][n] == '.') {
                if (m == 0) {
                    if (n == 0) {
                        if (matrix[m][n + 1] != '.')
                            counts++
                        else
                        matrix[m][n] = '#'

                    } else if (n == matrix[0].size - 1) {
                        if (matrix[m][n - 1] != '.')
                            counts++
                        else
                            matrix[m][n] = '#'

                    } else {
                        if (matrix[m][n + 1] != '.' && matrix[m][n - 1] != '.')
                            counts++
                        else
                            matrix[m][n] = '#'

                    }

                }else {
                    if (n == 0) {
                        if (matrix[m][n + 1] != '.' && matrix[m - 1][n + 1] != '.')
                            counts++
                        else
                            matrix[m][n] = '#'

                    } else if (n == matrix[0].size - 1) {
                        if (matrix[m][n - 1] != '.' && matrix[m - 1][n - 1] != '.')
                            counts++
                        else
                            matrix[m][n] = '#'

                    } else {
                        if (matrix[m][n + 1] != '.' && matrix[m][n - 1] != '.' && matrix[m - 1][n - 1] != '.' && matrix[m - 1][n + 1] != '.')
                            counts++
                        else
                            matrix[m][n] = '#'

                    }
                }
            }
        }
    }
    return counts
}




class Challenge5 {
}