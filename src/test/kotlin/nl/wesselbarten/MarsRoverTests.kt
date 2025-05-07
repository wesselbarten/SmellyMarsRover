package nl.wesselbarten

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MarsRoverTests {
    @ParameterizedTest
    @CsvSource(
        "1 2 N, ' ', 1 2 N",
        "1 2 N, L, 1 2 W",
        "1 2 W, L, 1 2 S",
        "1 2 S, L, 1 2 E",
        "1 2 E, L, 1 2 N",
        "1 2 N, R, 1 2 E",
        "1 2 E, R, 1 2 S",
        "1 2 S, R, 1 2 W",
        "1 2 W, R, 1 2 N",
        "1 2 N, M, 1 3 N",
        "1 2 E, M, 2 2 E",
        "1 2 S, M, 1 1 S",
        "1 2 W, M, 0 2 W",
        "1 2 N, LMLMLMLMM, 1 3 N",
        "3 3 E, MMRMMRMRRM, 5 1 E",
    )
    fun `execute commands`(startingPosition: String, instructions: String, expectedOutput: String) {
        val rover = Rover(startingPosition)
        rover.go(instructions)
        assertEquals(expectedOutput, rover.pose())
    }
}
