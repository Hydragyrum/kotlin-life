package life.controller

import tornadofx.Controller
import life.model.Game

class GameController : Controller() {
    private val DEFAULT_WIDTH = 32
    private val DEFAULT_HEIGHT = 32

    private var board = Game(DEFAULT_WIDTH, DEFAULT_HEIGHT)

    val width : Int
    get() = board.width

    val height : Int
    get() = board.height

    fun resetBoard(height: Int, width: Int) {
        board = Game(width, height)
    }
}