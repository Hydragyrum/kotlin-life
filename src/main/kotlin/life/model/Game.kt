package life.model

import kotlin.coroutines.experimental.buildSequence

class Game(val width: Int = 32, val height: Int = 32) {

    private var state: Array<Boolean> = Array(width * height, { _ -> false })

    private val NEIGHBOURS = listOf(Point(-1, -1), Point(0, -1), Point(1, -1),
            Point(-1, 0), Point(1, 0),
            Point(-1, 1), Point(0, 1), Point(1, 1))

    fun cellAt(x: Int, y: Int) = cellAt(Point(x, y))

    fun cellAt(p: Point): Boolean = state[calculateIndex(p)]

    fun cellAt(i: Int): Boolean = state[i % (width * height)]

    fun birth(x: Int, y: Int) = birth(Point(x, y))

    fun birth(p: Point) {
        state[calculateIndex(p)] = true
    }

    fun kill(x: Int, y: Int) = kill(Point(x, y))

    fun kill(p: Point) {
        state[calculateIndex(p)] = false
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

    fun calculateNextState() {
        state = getAllPoints().map{computeBehaviour(it)}.toList().toTypedArray()
    }

    private fun computeBehaviour(p: Point): Boolean {
        val neighbours = getLiveNeighbours(p)
        return when (neighbours) {
            2 -> cellAt(p)
            3 -> true
            else -> false
        }
    }

    private fun calculateIndex(x: Int, y: Int) = calculateIndex(Point(x, y))

    private fun calculateIndex(p: Point) = ((p.y + height) % height) * height + ((p.x + width) % width)

    private fun getAllPoints(): Sequence<Point> = buildSequence {
        yieldAll((0 until height).flatMap { y -> (0 until width).map { x -> Point(x, y) } })
    }
}

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point = Point(x + other.x, y + other.y)
}