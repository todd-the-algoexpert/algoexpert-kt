package algoexpert

import kotlin.test.Test
import kotlin.test.assertEquals


fun reverseWordsInString(s: String): String {
    if(s == "") {
        return s
    }
    val space = ' '
    var words = ""
    var i = 0
    var current = s[i++].toString()
    var ws = current.isBlank()
    while(i < s.length) {
        val c = s[i++]
        if(ws && c == space || !ws && c != space) {
            current += c
        }
        else {
            words = current + words
            current = "" + c
            ws = current.isBlank()
        }
    }
    words = current + words
    return words
}

class ReverseWordsInStringTest {

    @Test fun nothing() {
        val reverse = reverseWordsInString("")
        assertEquals("", reverse)
    }

    @Test fun singleChar() {
        val reverse = reverseWordsInString("c")
        assertEquals("c", reverse)
    }

    @Test fun basicSentence() {
        val reverse = reverseWordsInString("What is your name?")
        assertEquals("name? your is What", reverse)
    }
}