package life

import javafx.application.Application
import life.view.GameStyles
import life.view.GameView
import tornadofx.App
import tornadofx.reloadStylesheetsOnFocus

fun main(args: Array<String>) {
    Application.launch(Main::class.java, *args)
}

class Main : App(GameView::class, GameStyles::class) {
    init {
        reloadStylesheetsOnFocus()
    }
}