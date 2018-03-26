package life.model

//import org.amshove.kluent.`should be false`
//import org.amshove.kluent.`should be true`
//import org.amshove.kluent.`should equal`
//import org.jetbrains.spek.api.Spek
//import org.jetbrains.spek.api.dsl.describe
//import org.jetbrains.spek.api.dsl.it
//import org.jetbrains.spek.api.dsl.on

/*
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
            val p = Point(1, 3)
            board.birth(p)
            it("Should make the point alive") {
                board.cellAt(p)
            }
        }

        on("Kill cell at point 2, 2") {
            board.birth(2, 2)
            board.kill(2, 2)
            it("Should make point dead") {
                board.cellAt(2, 2).`should be false`()
            }
        }

        on("Kill cell at point 3, 1 with a Point") {
            val p = Point(3, 1)
            board.birth(p)
            board.kill(p)
            it("Should make point dead") {
                board.cellAt(p).`should be false`()
            }
        }

        on("Toggle a cell at Point 2, 2") {
            board.toggle(2, 2)
            it( "Point should be alive") {
                board.cellAt(2, 2).`should be true`()
            }
        }

        on("Toggle a cell at Point 2, 2 with Point") {
            val p = Point(4, 2)
            board.toggle(p)
            board.toggle(p)
            it( "Point should be dead") {
                board.cellAt(p).`should be false`()
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
                board.getLiveNeighbours(Point(0, 0)) `should equal` 2
            }
        }

        on("Calculate Next State with live cell") {
            board.birth(1, 2)
            board.birth(2, 1)
            board.birth(3, 2)
            board.calculateNextState()
            it("Point at 1,2 and 2,2 lives, rest die.") {
                getBoardState(board) `should equal` arrayOf(false, false, false, false, false,
                                                            false, false, true, false, false,
                                                            false, false, true, false, false,
                                                            false, false, false, false, false,
                                                            false, false, false, false, false)
            }
        }

        on("Calculate next state with glider") {
            board.birth(2, 1)
            board.birth(3, 2)
            board.birth(3, 3)
            board.birth(2, 3)
            board.birth(1, 3)
            board.calculateNextState()
            it("Next State should advance the glider") {
                getBoardState(board) `should equal` arrayOf(false, false, false, false, false,
                                                            false, false, false, false, false,
                                                            false, true, false, true, false,
                                                            false, false, true, true, false,
                                                            false, false, true, false, false)
            }

        }
    }
})

private fun getBoardState(board: Game) = Array(board.width * board.height, { i: Int -> board.cellAt(i) })
        
*/
