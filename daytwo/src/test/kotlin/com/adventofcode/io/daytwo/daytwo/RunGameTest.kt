package com.adventofcode.io.daytwo.daytwo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RunGameTest {

    @Test
    fun shouldConfirmTestScore() {
        val readText = this.javaClass.classLoader.getResource("test-scores.data").readText()
        val gameMachine = GameMachine(readText)
        val (_, playerTwo) = gameMachine.calculateGame()
        assertThat(playerTwo).isEqualTo(15)
    }

    @Test
    fun shouldCalculateRightScore() {
        val gameMachine = GameMachine(null)
        val (_, playerTwo) = gameMachine.calculateGame()

        println(playerTwo)

    }

    @Test
    fun shouldConfirmNewRuleSet() {
        val readText = this.javaClass.classLoader.getResource("test-scores.data").readText()
        val gameMachine = NewRulesMachine(readText)
        val humanScore = gameMachine.calculateGame()
        assertThat(humanScore).isEqualTo(12)
    }

    @Test
    fun shouldCalulateNewRules() {
        val gameMachine = NewRulesMachine(null)
        val humanScore = gameMachine.calculateGame()

        println(humanScore)

    }


}