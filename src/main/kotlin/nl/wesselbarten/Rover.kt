package nl.wesselbarten

class Rover {
    constructor(p: String) {
        val s = p.split(' ')
        if (s.size >= 3) {
            rs.xx = s[0].toInt()
            rs.yy = s[1].toInt()
            rs.dd = s[2][0]
        }
    }

    fun go(cms: String) {
        for (c in cms) {
            when (c) {
                'L' -> { when (rs.dd) { 'E' -> rs.dd = 'N' 'N' -> rs.dd = 'W' 'W' -> rs.dd = 'S' 'S' -> rs.dd = 'E' } }
                'R' -> { when (rs.dd) { 'E' -> rs.dd = 'S' 'S' -> rs.dd = 'W' 'W' -> rs.dd = 'N' 'N' -> rs.dd = 'E' } }
                'M' -> { when (rs.dd) { 'E' -> rs.xx++ 'S' -> rs.yy-- 'W' -> rs.xx-- 'N' -> rs.yy++ } }
            }
        }
    }

    val xyd: String
        get() = "${rs.xx} ${rs.yy} ${rs.dd}"

    fun pos(): String {
        return xyd
    }

    private var rs = RoverState()
}

class RoverState {
    var xx: Int = 0
    var yy: Int = 0
    var dd: Char = 'N'
}
