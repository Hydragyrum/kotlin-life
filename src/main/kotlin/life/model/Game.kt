package life.model

class Game(val width: Int = 32, val height: Int = 32) {

    private var state: Array<Boolean> = Array(width * height, { _ -> false })

    private val NEIGHBOURS = listOf(Point(-1, -1), Point(0, -1), Point(1, -1),
            Point(-1, 0), Point(1, 0),
            Point(-1, 1), Point(0, 1), Point(1, 1))

    fun cellAt(x: Int, y: Int) = cellAt(Point(x, y))

    fun cellAt(p: Point) : Boolean = state[calculateIndex(p)]

    fun birth(x: Int, y: Int) = birth(Point(x, y))

    fun birth(p: Point) {
        state[calculateIndex(p)] = true
    }

    fun kill(x: Int, y: Int) {
        state[calculateIndex(x, y)] = false
    }

    fun clear() {
        state.fill(false)
    }

    fun getLiveNeighbours(x: Int, y: Int): Int = getLiveNeighbours(Point(x, y))

    fun getLiveNeighbours(p: Point): Int {
        return NEIGHBOURS.map { p + it }
                .filter { this.cellAt(it) }
                .count()
    }

    private fun calculateIndex(x: Int, y: Int) = calculateIndex(Point(x, y))
    private fun calculateIndex(p: Point) = ((p.x + width) % width) * width + ((p.y + height) % height)
}

class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point = Point(x + other.x, y + other.y)
}