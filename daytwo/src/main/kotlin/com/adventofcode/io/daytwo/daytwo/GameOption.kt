package com.adventofcode.io.daytwo.daytwo

enum class GameOption(val bonusPoint: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    fun score(other: GameOption): Int {
        if (this == other) {
            return 3 + this.bonusPoint
        }
        if(win(other)) {
            return 6 + this.bonusPoint
        }
        return 0 + this.bonusPoint
    }

    private fun win(other: GameOption): Boolean {
        return when (this) {
            ROCK -> other != PAPER
            PAPER -> other != SCISSORS
            SCISSORS -> other != ROCK
        }
    }
    public fun winsTo(): GameOption {
        return when (this) {
            ROCK -> SCISSORS
            PAPER -> ROCK
            SCISSORS -> PAPER
        }
    }

    public fun loosesTo(): GameOption {
        return when (this) {
            ROCK -> PAPER
            PAPER -> SCISSORS
            SCISSORS -> ROCK
        }
    }
}

enum class PlayerOneMapping(val gameOption: GameOption) {
    A(GameOption.ROCK),
    B(GameOption.PAPER),
    C(GameOption.SCISSORS)
}

enum class PlayerTwoMapping(val gameOption: GameOption) {
    X(GameOption.ROCK),
    Y(GameOption.PAPER),
    Z(GameOption.SCISSORS)
}

enum class OutcomeMapping(val score: Int) {
    X(0),
    Y(3),
    Z(6);

    fun resolveYourOption(other: GameOption): GameOption {
        return when (this.score) {
            0 -> other.winsTo()
            3 -> other
            6 -> other.loosesTo()
            else -> throw IllegalArgumentException("unknown score")
        }
    }
}