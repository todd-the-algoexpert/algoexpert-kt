package com.algoexpert.program

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    val lastIndex = array.size - 1

    for(i in 0..(lastIndex - 1)) {
        val n1 = array[i]
        for(j in (i + 1)..lastIndex) {
            val n2 = array[j]
            val sum = n1 + n2
            if(sum == targetSum) {
                return listOf(n1, n2)
            }
        }
    }
    return listOf<Int>()
}
