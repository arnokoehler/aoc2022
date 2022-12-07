package com.adventofcode.io.dayone

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DayThreeTest {

    @Test
    fun `should add up to a sum of 157`() {
        val theLogic = theBasicLogic(getRucksack("verification-set-day-03.data"))
        assertThat(theLogic).isEqualTo(157)
    }

    @Test
    fun `run the actual calculation`() {
        val actual = theBasicLogic(getRucksack("actual-input-day-03.data"))

        println(actual)
    }

    @Test
    fun `badges should add up to 70`() {
        val rucksack = getRucksack("verification-set-day-03.data")
        assertThat(complexLogic(rucksack)).isEqualTo(70)
    }

    @Test
    fun `run the actual complexLogic calculation`() {
        val actual = complexLogic(getRucksack("actual-input-day-03.data"))

        println(actual)
    }

    private fun getRucksack(s: String): List<String> {
        val resource = this::class.java.classLoader.getResource(s)
        val rucksackData = resource!!.readText()
        return rucksackData.split("\n")
    }

    private fun findSameLetterInOneWord(haystack: String): Char {
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

    private fun complexLogic(input: List<String>): Int {
        val groupOfElves = input.chunked(3)
        println(groupOfElves)
        val badgesPerGroup = groupOfElves.map { findSameLetterInThreeStrings(it) }
        val getScoreMap = badgesPerGroup.map { getCharScore(it, getAlphabet()) }

        return getScoreMap.sum()
    }

    private fun findSameLetterInThreeStrings(input: List<String>): Char {
        assert(input.size == 3)
        val charInAllWords = input[0].filter { char -> input[1].contains(char) && input[2].contains(char) }
        println(charInAllWords)
        return charInAllWords.first() // if more just select first
    }

    private fun theBasicLogic(input: List<String>): Int {
        val charList = input.map { findSameLetterInOneWord(it) }
        val scoreList = charList.map { getCharScore(it, getAlphabet()) }

        println("found chars: $charList")
        println("found scores: $scoreList")

        return scoreList.sum()
    }

    private fun getAlphabet(): MutableList<Char> {
        val alphabets = CharRange('a', 'z').toMutableList()
        val upperCase = CharRange('A', 'Z').toMutableList()
        alphabets.addAll(upperCase)
        return alphabets
    }
}
