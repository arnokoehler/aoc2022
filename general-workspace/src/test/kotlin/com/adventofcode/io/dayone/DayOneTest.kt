package com.adventofcode.io.dayone

import com.adventofcode.io.dayone.FileUtils.Companion.splitLinesGroupedByNewline
import org.junit.jupiter.api.Test


class DayOneTest {

    @Test
    fun shouldCountAllTheCaloriesPerElf() {
        val dataPerElve = splitLinesGroupedByNewline("input-day-one.data")

        var highScore = 0
        for (data in dataPerElve) {
            val arrayOfCaloriesInText = data.split("\n")
            val valuesAsNumbers = arrayOfCaloriesInText.map(Integer::parseInt)
            valuesAsNumbers.sum()
            if (highScore < valuesAsNumbers.sum()) {
                highScore = valuesAsNumbers.sum()
            }
        }

        println(highScore)

    }

    @Test
    fun shouldCountAllTheCaloriesPerThreeElfs() {
        val dataPerElve = splitLinesGroupedByNewline("input-day-one.data")

        val highScore = mutableListOf<Int>()
        for (data in dataPerElve) {
            val arrayOfCaloriesInText = data.split("\n")
            val valuesAsNumbers = arrayOfCaloriesInText.map(Integer::parseInt)
            highScore.add(valuesAsNumbers.sum())
        }

        highScore.sort()
        highScore.reverse()

        val sum = highScore[0] + highScore[1] + highScore[2]
        println(highScore)
        println(sum)

    }
}