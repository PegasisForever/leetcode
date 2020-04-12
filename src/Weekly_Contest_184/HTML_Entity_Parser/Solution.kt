package Weekly_Contest_184.c

//https://leetcode.com/contest/weekly-contest-184/problems/html-entity-parser/
class Solution {
    fun entityParser(text: String): String {
        val sb = StringBuilder()

        var cursor = 0
        while (cursor < text.length) {
            val char = text[cursor]
            try {
                if (char == '&') {
                    if (text[cursor + 1] == 'a') {
                        if (text[cursor + 2] == 'p' && text[cursor + 3] == 'o' && text[cursor + 4] == 's' && text[cursor + 5] == ';') {
                            sb.append('\'')
                            cursor += 6
                            continue
                        } else if (text[cursor + 2] == 'm' && text[cursor + 3] == 'p' && text[cursor + 4] == ';') {
                            sb.append('&')
                            cursor += 5
                            continue
                        }
                    } else if (text[cursor + 1] == 'q' && text[cursor + 2] == 'u' && text[cursor + 3] == 'o' && text[cursor + 4] == 't' && text[cursor + 5] == ';') {
                        sb.append('\"')
                        cursor += 6
                        continue
                    }else if (text[cursor + 1] == 'g' && text[cursor + 2] == 't' && text[cursor + 3] == ';') {
                        sb.append('>')
                        cursor += 4
                        continue
                    }else if (text[cursor + 1] == 'l' && text[cursor + 2] == 't' && text[cursor + 3] == ';') {
                        sb.append('<')
                        cursor += 4
                        continue
                    }else if (text[cursor + 1] == 'f' && text[cursor + 2] == 'r' && text[cursor + 3] == 'a' && text[cursor + 4] == 's' && text[cursor + 5] == 'l' && text[cursor + 6] == ';') {
                        sb.append('/')
                        cursor += 7
                        continue
                    }
                }
            }catch (e:Throwable){}

            sb.append(char)
            cursor++
        }

        return sb.toString()
    }
}