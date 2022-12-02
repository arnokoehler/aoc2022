package com.adventofcode.io.dayone

import org.junit.jupiter.api.Test


class InputCountingTest {

    @Test
    fun shouldCountAllTheCaloriesPerElf() {
        val resource = this::class.java.classLoader.getResource("input.data")
        val dataOfTheElves = resource.readText()
        val dataPerElve = dataOfTheElves.split("\n\n")

        var highScore = 0;
        for (data in dataPerElve) {
            val arrayOfCaloriesInText = data.split("\n")
            val valuesAsNumbers = arrayOfCaloriesInText.map(Integer::parseInt)
            valuesAsNumbers.sum()
            if (highScore < valuesAsNumbers.sum()) {
                highScore = valuesAsNumbers.sum();
            }
        }

        println(highScore)

    }

    @Test
    fun shouldCountAllTheCaloriesPerThreeElfs() {
        val resource = this::class.java.classLoader.getResource("input.data")
        val dataOfTheElves = resource.readText()
        val dataPerElve = dataOfTheElves.split("\n\n")

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