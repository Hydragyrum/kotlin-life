package life.model

import com.sun.org.apache.xpath.internal.operations.Bool

class Game(val width: Int = 32, val height: Int = 32) {

    private var state: Array<Boolean> = Array(width * height, {_ -> false})

    fun cellAt(x: Int, y: Int): Boolean {
        return state[calculateIndex(x, y)]
    }

    fun birth(x: Int, y: Int) {
        state[calculateIndex(x, y)] = true
    }

    fun kill(x: Int, y: Int) {
        state[calculateIndex(x, y)] = false
    }

    private fun calculateIndex(x: Int, y: Int) = x * width + y
}