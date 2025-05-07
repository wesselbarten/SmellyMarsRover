package nl.wesselbarten

class Rover(startingPosition: String) {

    private var rs = RoverState()
    private val pose: String
        get() = "${rs.xPosition} ${rs.yPosition} ${rs.direction}"

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
                'L' -> {
                    when (rs.direction) {
                        'E' -> rs.direction = 'N'
                        'N' -> rs.direction = 'W'
                        'W' -> rs.direction = 'S'
                        'S' -> rs.direction = 'E'
                    }
                }

                'R' -> {
                    when (rs.direction) {
                        'E' -> rs.direction = 'S'
                        'S' -> rs.direction = 'W'
                        'W' -> rs.direction = 'N'
                        'N' -> rs.direction = 'E'
                    }
                }

                'M' -> {
                    when (rs.direction) {
                        'E' -> rs.xPosition++
                        'S' -> rs.yPosition--
                        'W' -> rs.xPosition--
                        'N' -> rs.yPosition++
                    }
                }
            }
        }
    }

    fun pose(): String {
        return pose
    }
}

class RoverState {
    var xPosition: Int = 0
    var yPosition: Int = 0
    var direction: Char = 'N'
}
