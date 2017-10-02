package life.view

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Parent
import javafx.scene.effect.Glow
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints
import javafx.scene.shape.Rectangle
import javafx.scene.text.Text
import javafx.stage.StageStyle
import life.controller.GameController
import life.model.Game
import tornadofx.*

class GameView : View("Game of Life") {

    val lifeController: GameController by inject()

    override val root: GridPane by fxid()

    private val grid: GridPane by fxid()
    private val titleBar: AnchorPane by fxid()

    private fun Text.updateWidth(it: MouseEvent) {
        if (lifeController.isRunning) return

        val change = when (it.button) {
            MouseButton.PRIMARY -> lifeController.incrementWidth()
            MouseButton.SECONDARY -> lifeController.decrementWidth()
            else -> false
        }

        if (change) {
            resetGrid()
            setupGrid()
            text = "${lifeController.width}"
        }
    }

    private fun Text.updateHeight(it: MouseEvent) {
        if (lifeController.isRunning) return

        val change = when (it.button) {
            MouseButton.PRIMARY -> lifeController.incrementHeight()
            MouseButton.SECONDARY -> lifeController.decrementHeight()
            else -> false
        }

        if (change) {
            resetGrid()
            setupGrid()
            text = "${lifeController.height}"
        }
    }

    private fun setupGrid() {
        for (i in 1..lifeController.width) {
            grid.columnConstraints.add(ColumnConstraints().apply {
                halignment = HPos.CENTER
                prefWidth = 100.0
            })
        }

        for (j in 1..lifeController.height) {
            grid.rowConstraints.add(RowConstraints().apply {
                valignment = VPos.CENTER
                prefHeight = 100.0
            })
        }

        val width = (grid.width - 10) / lifeController.width - 2
        val height = (grid.height - 10) / lifeController.height - 2
        for (x in 0 until lifeController.width) for (y in 0 until lifeController.height) {
            val cell = Rectangle(width, height).apply { addClass(GameStyles.cell) }

            grid.add(cell.apply {
                setOnMouseEntered {
                    effect = Glow(1.0)
                }

                setOnMouseExited {
                    removeClass(GameStyles.liveCell, GameStyles.cell)
                    addClass(if (lifeController.cellAt(x, y)) GameStyles.liveCell else GameStyles.cell)
                    effect = null
                }

                setOnMouseClicked {
                    lifeController.toggleCell(x, y)
                    removeClass(GameStyles.liveCell, GameStyles.cell)
                    addClass(if (lifeController.cellAt(x, y)) GameStyles.liveCell else GameStyles.cell)
                }
            }, y, x)
        }
    }

    private fun resetGrid() {
        grid.rowConstraints.clear()
        grid.columnConstraints.clear()
        grid.children.clear()
    }

    init {
        primaryStage.resizableProperty().set(false)
        primaryStage.initStyle(StageStyle.TRANSPARENT)


    }
}
