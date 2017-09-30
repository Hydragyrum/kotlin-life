package life.model

import org.amshove.kluent.`should be false`
import org.amshove.kluent.`should be true`
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object GameSpek : Spek ({
    describe("A Game Board" ) {
        val board = Game(5, 5)

        on("Creation") {
            it("Should be a 5 x 5 grid.") {
                board.width `should equal` 5
                board.height `should equal` 5
            }
        }

        on("Birth a cell at point 2, 2." ) {
            board.birth(2, 2)
            it("Should make the point alive") {
                board.cellAt(2, 2).`should be true`()
            }
        }

        on("Kill cell at point 2, 2") {
            board.birth(2, 2)
            board.kill(2, 2)
            it("Should make point dead") {
                board.cellAt(2, 2).`should be false`()
            }
        }
    }
})