package life.view

import tornadofx.*

class GameStyles : Stylesheet() {

    companion object {
        val titleBarStyle by cssclass()
        val titleBarTextStyle by cssclass()
        val cell by cssclass()
        val liveCell by cssclass()
        val grid by cssclass()

        private val BACKGROUND_TITLE_COLOUR = c("#1b1b1b")
        private val BACKGROUND_COLOUR = c("#424242")
        private val LIVE_CELL_COLOUR = c("#c6ff00")
        private val TEXT_COLOUR = c("#ffffff")
    }

    init {
        val cellStyle = mixin {
            borderRadius = multi(box(5.px))
        }

        titleBarStyle {
            backgroundColor = multi(BACKGROUND_TITLE_COLOUR)
            prefHeight = 200.0.px
            prefWidth = 200.0.px
        }

        titleBarTextStyle {
            textFill = TEXT_COLOUR
        }

        cell {
            +cellStyle
            backgroundColor = multi(BACKGROUND_COLOUR)
        }

        liveCell {
            +cellStyle
            backgroundColor = multi(LIVE_CELL_COLOUR)
        }

        grid {
            backgroundColor = multi(BACKGROUND_COLOUR)
        }
    }
}