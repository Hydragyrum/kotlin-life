package life.view

import javafx.scene.text.Font
import life.controller.GameController
import tornadofx.*

class GameView : View("Game of Life") {

    val lifeController: GameController by inject()

    override val root = gridpane {
        val titleBar = anchorpane {
            addClass(GameStyles.titleBarStyle)
            val widthField = text {
                addClass(GameStyles.titleBarStyle)
            }
            val xLabel = text {
                addClass(GameStyles.titleBarStyle)
                text = "x"
            }
            val heightField = text {
                addClass(GameStyles.titleBarStyle)
            }
            val playButton = button {
                addClass(GameStyles.titleBarStyle)
            }
            val nextButton = button {
                addClass(GameStyles.titleBarStyle)
            }
            val resetButton = button {
                addClass(GameStyles.titleBarStyle)
            }
            val closeButton = button {
                addClass(GameStyles.titleBarStyle)
            }

        }
        anchorpane {
            val grid = gridpane {
                addClass(GameStyles.cell)
            }
        }
    }

    init {

    }
}
