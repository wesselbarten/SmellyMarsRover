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
                }

                INSTRUCTION_ROTATE_RIGHT -> {
                    when (rs.direction) {
                        DIRECTION_EAST -> rs.direction = DIRECTION_SOUTH
                        DIRECTION_SOUTH -> rs.direction = DIRECTION_WEST
                        DIRECTION_WEST -> rs.direction = DIRECTION_NORTH
                        DIRECTION_NORTH -> rs.direction = DIRECTION_EAST
                    }
                }

                INSTRUCTION_MOVE -> {
                    when (rs.direction) {
                        DIRECTION_EAST -> rs.xPosition++
                        DIRECTION_SOUTH -> rs.yPosition--
                        DIRECTION_WEST -> rs.xPosition--
                        DIRECTION_NORTH -> rs.yPosition++
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

    fun pose(): String {
        return "$xPosition $yPosition $direction"
    }
}
