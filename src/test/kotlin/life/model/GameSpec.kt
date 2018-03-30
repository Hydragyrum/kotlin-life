package life.model

import io.kotlintest.specs.BehaviorSpec
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be`
import org.amshove.kluent.`should equal`

class GameSpec : BehaviorSpec() {
    val board : Game = Game(5, 5)
    init {
        Given("A Game Board" ) {
            When("The Board is created") {
                Then("it should be a 5x5 grid.") {
                    board.width `should be equal to` 5
                    board.height `should be equal to` 5
                }
            }
            
            When("A cell is birthed at point 2, 2") {
                board.clear()
                board.birth(2, 2)
                Then("it should be alive") {
                    board.cellAt(2, 2) `should be` true 
                }
            }
            
            When("A cell is birthed at point 1, 3 using a Point") {
                board.clear()
                val p = Point(1, 3)
                board.birth(p)
                Then("it should be alive") {
                    board.cellAt(p) `should be` true 
                }
            }
            
            When("A cell is killed at point 2, 2") {
                board.clear()
                board.birth(2, 2)
                board.kill(2, 2)
                Then("it should be dead") {
                    board.cellAt(2, 2) `should be` false
                }
            }

            When("A cell is killed at point 3, 1 with a Point") {
                board.clear()
                val p = Point(3, 1)
                board.birth(p)
                board.kill(p)
                Then("it should be dead") {
                    board.cellAt(p) `should be` false
                }
            }

            When("A cell is toggled at Point 2, 2") {
                board.clear()
                board.toggle(2, 2)
                Then( "it should be alive") {
                    board.cellAt(2, 2) `should be` true
                }
            }

            When("A cell is toggled at Point 4, 2 with Point") {
                board.clear()
                val p = Point(4, 2)
                board.toggle(p)
                Then( "it should be alive") {
                    board.cellAt(p) `should be` true
                }
            }
            
            When("We get number of live neighbours around a cell") {
                board.clear()
                board.birth(1, 1)
                board.birth(3, 3)
                Then( "the point 2, 2, should have 2 live neighbours") {
                    board.getLiveNeighbours(2, 2) `should be equal to` 2
                }
            }
            
            When("We get number of live neighbours from the edge") {
                board.clear()
                board.birth(1, 0)
                board.birth(4, 4)
                Then("the point 0, 0 should have 2 neighbours") {
                    board.getLiveNeighbours(Point(0, 0)) `should be equal to` 2
                }
            }
            
            When("We calculate the Next State with live cells") {
                board.clear()
                board.birth(1, 2)
                board.birth(2, 1)
                board.birth(3, 2)
                board.calculateNextState()
                Then("the points at 1,2 and 2,2 live, and the rest die.") {
                    getBoardState(board) `should equal` arrayOf(false, false, false, false, false,
                            false, false, true, false, false,
                            false, false, true, false, false,
                            false, false, false, false, false,
                            false, false, false, false, false)
                }
            }
            
            When("We calculate next state with glider") {
                board.clear()
                board.birth(2, 1)
                board.birth(3, 2)
                board.birth(3, 3)
                board.birth(2, 3)
                board.birth(1, 3)
                board.calculateNextState()
                Then("the next State should advance the glider") {
                    getBoardState(board) `should equal` arrayOf(false, false, false, false, false,
                            false, false, false, false, false,
                            false, true, false, true, false,
                            false, false, true, true, false,
                            false, false, true, false, false)
                }
            }
        }
    }
        
    private fun getBoardState(board: Game) = Array(board.width * board.height, { i: Int -> board.cellAt(i) })
}
