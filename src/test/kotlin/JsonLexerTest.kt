import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JsonLexerTest {

    @Test
    fun skipWhiteSpace() {
        val lexer = JsonLexer()
        Assertions.assertAll(
             {
                 assertEquals(0, lexer.skipWhiteSpace("", 0))
             },
            {
                assertEquals(1, lexer.skipWhiteSpace(" a", 0))
            },
            {
                assertEquals(2, lexer.skipWhiteSpace("  a", 0))
            },
            {
                val sample = "  a   "
                assertEquals(2, lexer.skipWhiteSpace(sample, 0))
            },
            {
                val sample = "  a   "
                assertEquals(sample.length, lexer.skipWhiteSpace(sample, 3))
            },
            {
                val sample = "  aaaa   "
                assertEquals(3, lexer.skipWhiteSpace(sample, 3))
            },
            {
                val sample = "        a"
                assertEquals(sample.length-1, lexer.skipWhiteSpace(sample, 0))
            },
        )


    }
}