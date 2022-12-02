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
}