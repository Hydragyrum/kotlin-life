package life.model

import io.kotlintest.TestCase
import io.kotlintest.TestCaseContext
import io.kotlintest.specs.BehaviorSpec
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be`

class GameSpec : BehaviorSpec() {
    val board = Game(5, 5)
    init {
        Given("A Game Board" ) {
            When("The Board is created") {
                Then("it should be a 5x5 grid.") {
                    board.width `should be equal to` 5
                    board.height `should be equal to` 5
                }
            }
            
            When("A cell is birthed at point 2, 2") {
                board.birth(2, 2)
                Then("it should be alive") {
                    board.cellAt(2, 2) `should be` true 
                }
            }
        }
    }

    override fun interceptTestCase(context: TestCaseContext, test: () -> Unit) {
        board.clear()
        test()       
    }

}
