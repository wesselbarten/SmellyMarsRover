package nl.wesselbarten

private const val DIRECTION_NORTH = 'N'
private const val DIRECTION_WEST = 'W'
private const val DIRECTION_SOUTH = 'S'
private const val DIRECTION_EAST = 'E'

private const val INSTRUCTION_ROTATE_LEFT = 'L'
private const val INSTRUCTION_ROTATE_RIGHT = 'R'
private const val INSTRUCTION_MOVE = 'M'

private const val POSITIONS_COUNT = 3
private const val POSITIONS_DELIMITER = ' '

class Rover(startingPosition: String) {

    private var rs = RoverState()

    init {
        rs.setStartingPosition(startingPosition)
    }

    fun go(instructions: String) {
        for (instruction in instructions) {
            rs.executeInstruction(instruction)
        }
    }

    fun pose(): String {
        return rs.pose()
    }
}

class RoverState {
    private var position: Position = Position(0, 0)
    private var direction: Direction = Direction.NORTH

    fun setStartingPosition(startingPosition: String) {
        val positions = startingPosition.split(POSITIONS_DELIMITER)
        if (positions.size >= POSITIONS_COUNT) {
            position = Position(x = positions[0].toInt(), y = positions[1].toInt())
            direction = Direction.valueOf(positions[2][0])
        }
    }

    fun pose(): String {
        return "${position.x} ${position.y} ${direction.char}"
    }

    fun executeInstruction(instruction: Char) {
        when (instruction) {
            INSTRUCTION_ROTATE_LEFT -> {
                rotateLeft()
            }

            INSTRUCTION_ROTATE_RIGHT -> {
                rotateRight()
            }

            INSTRUCTION_MOVE -> {
                move()
            }
        }
    }

    private fun rotateLeft() {
        direction = when (direction) {
            Direction.EAST -> Direction.NORTH
            Direction.NORTH -> Direction.WEST
            Direction.WEST -> Direction.SOUTH
            Direction.SOUTH -> Direction.EAST
        }
    }

    private fun rotateRight() {
        direction = when (direction) {
            Direction.EAST -> Direction.SOUTH
            Direction.SOUTH -> Direction.WEST
            Direction.WEST -> Direction.NORTH
            Direction.NORTH -> Direction.EAST
        }
    }

    private fun move() {
        when (direction) {
            Direction.EAST -> position.moveEast()
            Direction.SOUTH -> position.moveSouth()
            Direction.WEST -> position.moveWest()
            Direction.NORTH -> position.moveNorth()
        }
    }
}

enum class Direction(val char: Char) {
    NORTH(DIRECTION_NORTH),
    EAST(DIRECTION_EAST),
    SOUTH(DIRECTION_SOUTH),
    WEST(DIRECTION_WEST),
    ;

    companion object {
        fun valueOf(char: Char): Direction {
            return when (char) {
                DIRECTION_NORTH -> NORTH
                DIRECTION_EAST -> EAST
                DIRECTION_SOUTH -> SOUTH
                DIRECTION_WEST -> WEST
                else -> error("This value $char is not supported to parse to a direction.")
            }
        }
    }
}

class Position(
    var x: Int,
    var y: Int,
) {

    fun moveEast() {
        x++
    }

    fun moveSouth() {
        y--
    }

    fun moveWest() {
        x--
    }

    fun moveNorth() {
        y++
    }
}
