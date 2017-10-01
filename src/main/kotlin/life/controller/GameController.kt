package life.controller

import tornadofx.Controller
import life.model.Game

class GameController : Controller() {
    val board = Game()
}