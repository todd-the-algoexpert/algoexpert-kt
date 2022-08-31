package algoexpert

import kotlin.math.max
import kotlin.math.min
import kotlin.test.Test
import kotlin.test.assertEquals

class MergeOverlappingIntervalsTest {

    private fun overlap(a: List<Int>, b: List<Int>): Boolean {
        return a[1] >= b[0]
    }

    private fun merge(a: List<Int>, b: List<Int>): List<Int> {
        val x = min(a[0], b[0])
        val y = max(a[1], b[1])
        return listOf(x, y)
    }

    private fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {
        val sorted = intervals.sortedBy { it[0] }
        val merged = mutableListOf<List<Int>>()
        var acc = sorted[0]
        for (i in 1 until sorted.size) {
            acc = if(overlap(acc, sorted[i])) {
                merge(acc, sorted[i])
            } else {
                merged.add(acc)
                sorted[i]
            }
        }
        merged.add(acc)
        return merged
    }

    @Test fun baseCase() {
        val intervals = listOf(listOf(3, 5), listOf(4, 7), listOf(1, 2), listOf(6, 8), listOf(9, 10))
        val expected = listOf(listOf(1, 2), listOf(3, 8), listOf(9, 10))
        val output = mergeOverlappingIntervals(intervals)
        assertEquals(expected, output)
    }

    @Test fun absorbed() {
        val intervals = listOf(listOf(1, 22), listOf(-20, 30))
        val expected = listOf(listOf(-20, 30))
        val output = mergeOverlappingIntervals(intervals)
        assertEquals(expected, output)
    }
}