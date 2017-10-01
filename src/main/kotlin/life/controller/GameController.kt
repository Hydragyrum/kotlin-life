package life.controller

import tornadofx.Controller
import life.model.Game

class GameController : Controller() {
    companion object {
        val DEFAULT_WIDTH = 32
        val DEFAULT_HEIGHT = 32
    }

    val MIN_SIZE = 5
    val MAX_SIZE = 64

    private var board = Game(DEFAULT_WIDTH, DEFAULT_HEIGHT)

    val width: Int
        get() = board.width

    val height: Int
        get() = board.height

    val isRunning: Boolean
        get() = false

    fun resetBoard(height: Int, width: Int) {
        board = Game(width, height)
    }

    fun incrementWidth(): Boolean {
        val newWidth = width + 1
        val isNewWidthWithinLimits = newWidth <= MAX_SIZE
        return resetBoardWidth(isNewWidthWithinLimits, newWidth)
    }

    private fun resetBoardWidth(isNewWidthWithinLimits: Boolean, newWidth: Int): Boolean {
        if (isNewWidthWithinLimits) {
            board = Game(newWidth, height)
        }
        return isNewWidthWithinLimits
    }

    fun decrementWidth(): Boolean {
        val newWidth = width - 1
        val isNewWidthWithinLimits = newWidth >= MIN_SIZE
        return resetBoardWidth(isNewWidthWithinLimits, newWidth)
    }

    fun incrementHeight(): Boolean {
        val newHeight = height + 1
        val newHeightWithinLimits = newHeight <= MAX_SIZE
        return resetBoardHeight(newHeightWithinLimits, newHeight)
    }

    private fun resetBoardHeight(isNewHeightWithinLimits: Boolean, newHeight: Int): Boolean {
        if (isNewHeightWithinLimits) {
            board = Game(width, newHeight)
        }
        return isNewHeightWithinLimits
    }

    fun decrementHeight(): Boolean {
        val newHeight = height - 1
        val newHeightWithinLimits = newHeight >= MIN_SIZE
        return resetBoardHeight(newHeightWithinLimits, newHeight)
    }

    fun cellAt(x: Int, y: Int): Boolean {
        return board.cellAt(x, y)
    }

    fun toggleCell(x: Int, y: Int) {
        board.toggle(x, y)
    }
}