package com.adventofcode.io.daytwo.daytwo

class NewRulesMachine(val data: String?) {

    fun calculateGame(): Int {
        val gameLines = data?.split("\n") ?: getResourceFromClassPath()

        var humanScore = 0

        gameLines.map { calculateGameLine(it) }.map { x ->
            humanScore += x
        }

        return humanScore
    }

    private fun calculateGameLine(gameLine: String): Int {
        val chars = gameLine.toCharArray()
        assert(chars.size == 3)

        return score(
            PlayerOneMapping.valueOf(chars.get(0).toString()),
            OutcomeMapping.valueOf(chars.get(2).toString())
        )
    }

    private fun score(elfPlayer: PlayerOneMapping, humanPlayer: OutcomeMapping):Int {
        val yourGameOption = humanPlayer.resolveYourOption(elfPlayer.gameOption)
        val score = humanPlayer.score + yourGameOption.bonusPoint

        return score
    }

    private fun getResourceFromClassPath() = this.javaClass.classLoader
        .getResource("scores.data").readText().split("\n")

}