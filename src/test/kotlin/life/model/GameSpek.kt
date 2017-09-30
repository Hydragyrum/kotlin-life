package life.model

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
    }
})