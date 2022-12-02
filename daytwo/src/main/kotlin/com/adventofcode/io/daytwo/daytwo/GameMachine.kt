package com.adventofcode.io.daytwo.daytwo

class GameMachine(val data: String?) {

    fun calculateGame(): Pair<Int, Int> {
        val gameLines = data?.split("\n") ?: getResourceFromClassPath()

        var playerOne = 0
        var playerTwo = 0

        gameLines.map { calculateGameLine(it) }.map { x ->
            playerOne += x.first
            playerTwo += x.second
        }

        return playerOne to playerTwo
    }

    private fun getResourceFromClassPath() = this.javaClass.classLoader
        .getResource("scores.data").readText().split("\n")

    private fun calculateGameLine(gameLine: String): Pair<Int, Int> {
        val chars = gameLine.toCharArray()
        assert(chars.size == 3)

        return score(
            PlayerOneMapping.valueOf(chars.get(0).toString()),
            PlayerTwoMapping.valueOf(chars.get(2).toString())
        )
    }

    private fun score(playerOne: PlayerOneMapping, playerTwo: PlayerTwoMapping): Pair<Int, Int> {
        val scorePlayerOne = playerOne.gameOption.score(playerTwo.gameOption)
        val scorePlayerTwo = playerTwo.gameOption.score(playerOne.gameOption)
        return scorePlayerOne to scorePlayerTwo
    }
}