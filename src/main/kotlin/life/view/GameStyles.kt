package life.view

import tornadofx.*

class GameStyles : Stylesheet() {

    companion object {
        val titleBarStyle by cssclass()
        val cell by cssclass()
        val liveCell by cssclass()

        private val BACKGROUND_TITLE_COLOUR = c("#1b1b1b")
        private val BACKGROUND_COLOUR = c("#424242")
        private val LIVE_CELL_COLOUR = c("#c6ff00")
        private val TEXT_COLOUR = c("#ffffff")
    }

    init {
        val cellStyle = mixin {
            borderRadius = multi(box(2.px))
        }

        titleBarStyle {
            textFill = TEXT_COLOUR
            backgroundColor = multi(BACKGROUND_TITLE_COLOUR)
        }

        cell {
            +cellStyle
            backgroundColor = multi(BACKGROUND_COLOUR)
        }

        liveCell {
            +cellStyle
            backgroundColor = multi(LIVE_CELL_COLOUR)
        }
    }
}