import java.util.*

data class Token(val Pos: Int, val tokenType: JsonLexer.TokenType)

class JsonLexer {

    enum class TokenType {
        CURLY_BRACE_OPEN, CURLY_BRACE_CLOSE, BRACKET_OPEN, BRACKET_CLOSE, COMMA, COLON, STRING, DIGIT
    }


    fun tokenizeString(stream: String) : List<Token> {
        val tokens : List<Token> = ArrayList<Token>()
        var position = 0

        while (position < stream.length) {
            position = skipWhiteSpace(stream, position)

            when (stream[position]) {
                '{' -> tokens.add(Token(position, TokenType.CURLY_BRACE_OPEN))
                '}' -> tokens.add(Token(position, TokenType.CURLY_BRACE_CLOSE))
                '[' -> tokens.add(Token(position, TokenType.BRACKET_OPEN))
                ']' -> tokens.add(Token(position, TokenType.BRACKET_CLOSE))
                ',' -> tokens.add(Token(position, TokenType.COMMA))
                ':' -> tokens.add(Token(position, TokenType.COLON))
                '"' -> {
                    tokens.add(Token(position, TokenType.STRING))
                    position = parseString(stream, position)
                }
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                    tokens.add(Token(position, TokenType.DIGIT))
                    position = parseNumber(stream, position)
                }

            }
        }
        return tokens
    }

    fun parseString(stream: String, curPosition: Int) : Int {
        return 0
    }

    fun parseNumber(stream: String, curPosition: Int) : Int {
        return 0
    }

    fun skipWhiteSpace(stream: String, curPosition: Int) : Int {
        var position = curPosition
        while (position < stream.length && stream[position].isWhitespace()) {
            position++
        }
        return position
    }
}