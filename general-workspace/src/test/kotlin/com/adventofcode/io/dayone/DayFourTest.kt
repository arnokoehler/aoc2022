package com.adventofcode.io.dayone

import com.adventofcode.io.dayone.DayFour.Companion.splitLinesGroupedBySection
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DayFourTest {

    @Test
    fun `Should have 2 pairs should one range fully contain the other`() {
        val rangesLines = splitLinesGroupedBySection("verification-set-day-04.data")
        val positiveMatches = rangesLines.map { it.intersectFull() }


        assertThat(positiveMatches.count { it }).isEqualTo(2)
    }

    @Test
    fun `Should have 4 pairs should one range intersectPartial to the other`() {
        val rangesLines = splitLinesGroupedBySection("verification-set-day-04.data")
        val positiveMatches = rangesLines.map { it.intersectPartial() }


        assertThat(positiveMatches.count { it }).isEqualTo(4)
    }

    @Test
    fun `actual calculation number of pairs should one range fully contain the other`() {
        val rangesLines = splitLinesGroupedBySection("actual-input-day-04.data")

        val positiveMatches = rangesLines.map { it.intersectFull() }

        val count = positiveMatches.count { it }
        println("final score: $count")
    }

    @Test
    fun `actual calculation number that have intersectPartial to the other`() {
        val rangesLines = splitLinesGroupedBySection("actual-input-day-04.data")

        val positiveMatches = rangesLines.map { it.intersectFull() }

        val count = positiveMatches.count { it }
        println("final score: $count")
    }


}