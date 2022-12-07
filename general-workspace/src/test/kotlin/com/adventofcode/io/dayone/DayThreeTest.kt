package com.adventofcode.io.dayone

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private const val i = 1

class DayThreeTest {

    @Test
    fun `should add up to a sum of 157`() {
        val theLogic = theLogic(getRucksack("verification-set-day-03.data"))
        assertThat(theLogic).isEqualTo(157)
    }

    @Test
    fun `run the actual calculation`() {
        val actual = theLogic(getRucksack("actual-input-day-03.data"))

        println(actual)
    }

    private fun getRucksack(s: String): List<String> {
        val resource = this::class.java.classLoader.getResource(s)
        val rucksackData = resource.readText()
        return rucksackData.split("\n")
    }

    private fun findSameLetter(haystack: String): Char {
        val chunked = haystack.chunked(haystack.length /2)
        println(chunked)

        val filter = chunked[0].filter { char -> chunked[1].contains(char) }
        println(filter)
        return filter.first()
    }

    private fun getCharScore(it: Char, alphabet: MutableList<Char>): Int {
        val indexOf = alphabet.indexOf(it)
        println("$it has an index $indexOf in $alphabet")
        return indexOf + 1 // zero based index correction
    }

    private fun theLogic(input: List<String>): Int {
        val alphabets = CharRange('a','z').toMutableList()
        val upperCase = CharRange('A','Z').toMutableList()
        alphabets.addAll(upperCase)
        val charList = input.map { findSameLetter(it) }
        val scoreList = charList.map { getCharScore(it, alphabets) }

        println("found chars: $charList")
        println("found scores: $scoreList")

        return scoreList.sum()
    }
}
