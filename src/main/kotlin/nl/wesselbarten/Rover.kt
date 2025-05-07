package nl.wesselbarten

private const val DIRECTION_NORTH = 'N'
private const val DIRECTION_WEST = 'W'
private const val DIRECTION_SOUTH = 'S'
private const val DIRECTION_EAST = 'E'

private const val INSTRUCTION_ROTATE_LEFT = 'L'
private const val INSTRUCTION_ROTATE_RIGHT = 'R'
private const val INSTRUCTION_MOVE = 'M'

class Rover(startingPosition: String) {

    private var rs = RoverState()

    init {
        val positions = startingPosition.split(' ')
        if (positions.size >= 3) {
            rs.xPosition = positions[0].toInt()
            rs.yPosition = positions[1].toInt()
            rs.direction = positions[2][0]
            rs.newDirection = Direction.valueOf(positions[2][0])
        }
    }

    fun go(instructions: String) {
        for (instruction in instructions) {
            when (instruction) {
                INSTRUCTION_ROTATE_LEFT -> {
                    when (rs.direction) {
                        DIRECTION_EAST -> rs.direction = DIRECTION_NORTH
                        DIRECTION_NORTH -> rs.direction = DIRECTION_WEST
                        DIRECTION_WEST -> rs.direction = DIRECTION_SOUTH
                        DIRECTION_SOUTH -> rs.direction = DIRECTION_EAST
                    }
                    when (rs.newDirection) {
                        Direction.EAST -> rs.newDirection = Direction.NORTH
                        Direction.NORTH -> rs.newDirection = Direction.WEST
                        Direction.WEST -> rs.newDirection = Direction.SOUTH
                        Direction.SOUTH -> rs.newDirection = Direction.EAST
                    }
                }

                INSTRUCTION_ROTATE_RIGHT -> {
                    when (rs.direction) {
                        DIRECTION_EAST -> rs.direction = DIRECTION_SOUTH
                        DIRECTION_SOUTH -> rs.direction = DIRECTION_WEST
                        DIRECTION_WEST -> rs.direction = DIRECTION_NORTH
                        DIRECTION_NORTH -> rs.direction = DIRECTION_EAST
                    }
                    when (rs.newDirection) {
                        Direction.EAST -> rs.newDirection = Direction.SOUTH
                        Direction.SOUTH -> rs.newDirection = Direction.WEST
                        Direction.WEST -> rs.newDirection = Direction.NORTH
                        Direction.NORTH -> rs.newDirection = Direction.EAST
                    }
                }

                INSTRUCTION_MOVE -> {
                    when (rs.newDirection) {
                        Direction.EAST -> rs.xPosition++
                        Direction.SOUTH -> rs.yPosition--
                        Direction.WEST -> rs.xPosition--
                        Direction.NORTH -> rs.yPosition++
                    }
                }
            }
        }
    }

    fun pose(): String {
        return rs.pose()
    }
}

class RoverState {
    var xPosition: Int = 0
    var yPosition: Int = 0
    var direction: Char = DIRECTION_NORTH
    var newDirection: Direction = Direction.NORTH

    fun pose(): String {
        return "$xPosition $yPosition ${newDirection.char}"
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
