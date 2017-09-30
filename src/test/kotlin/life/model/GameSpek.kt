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

        beforeEachTest {
            board.clear()
        }

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

        on("Birth a cell at point 1, 3 with a Point") {
            board.birth(Point(1, 3))
            it("Should make the point alive") {
                board.cellAt(Point(1, 3))
            }
        }

        on("Kill cell at point 2, 2") {
            board.birth(2, 2)
            board.kill(2, 2)
            it("Should make point dead") {
                board.cellAt(2, 2).`should be false`()
            }
        }

        on("Get number of live neighbours") {
            board.birth(1, 1)
            board.birth(3, 3)
            it( "Point 2, 2, should have 2 neighbours") {
                board.getLiveNeighbours(2, 2) `should equal` 2
            }
        }

        on("Get number of live neighbours from the edge") {
            board.birth(1, 0)
            board.birth(4, 4)
            it("Point 0, 0 should have 2 neighbours") {
                board.getLiveNeighbours(0, 0) `should equal` 2
            }
        }
    }
})