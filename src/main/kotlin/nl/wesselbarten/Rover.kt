package nl.wesselbarten

class Rover(startingPosition: String) {

    private var rs = RoverState()
    private val pose: String
        get() = "${rs.xPosition} ${rs.yy} ${rs.dd}"

    init {
        val positions = startingPosition.split(' ')
        if (positions.size >= 3) {
            rs.xPosition = positions[0].toInt()
            rs.yy = positions[1].toInt()
            rs.dd = positions[2][0]
        }
    }

    fun go(instructions: String) {
        for (instruction in instructions) {
            when (instruction) {
                'L' -> {
                    when (rs.dd) {
                        'E' -> rs.dd = 'N'
                        'N' -> rs.dd = 'W'
                        'W' -> rs.dd = 'S'
                        'S' -> rs.dd = 'E'
                    }
                }

                'R' -> {
                    when (rs.dd) {
                        'E' -> rs.dd = 'S'
                        'S' -> rs.dd = 'W'
                        'W' -> rs.dd = 'N'
                        'N' -> rs.dd = 'E'
                    }
                }

                'M' -> {
                    when (rs.dd) {
                        'E' -> rs.xPosition++
                        'S' -> rs.yy--
                        'W' -> rs.xPosition--
                        'N' -> rs.yy++
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
    var yy: Int = 0
    var dd: Char = 'N'
}
