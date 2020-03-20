import scala.collection.mutable

object MatchingBrackets {

  // brackets [], braces {}, parentheses ()

  def isPaired(text: String): Boolean = {

    var countBrackets = 0
    var countBraces = 0
    var countParentheses = 0
    val openBrackets = mutable.Stack[Char]()

    (0 until text.length).foreach(v => {
      if (text.charAt(v) == '[') {
        openBrackets.push('[')
        countBrackets += 1
      }

      if (text.charAt(v) == ']') {
        if ((countBrackets < 1) || (openBrackets.pop() != '[')) return false
        countBrackets -= 1
      }

      if (text.charAt(v) == '{') {
        openBrackets.push('{')
        countBraces += 1
      }

      if (text.charAt(v) == '}') {
        if ((countBraces < 1) || (openBrackets.pop() != '{')) return false
        countBraces -= 1
      }

      if (text.charAt(v) == '(') {
        openBrackets.push('(')
        countParentheses += 1
      }

      if (text.charAt(v) == ')') {
        if ((countParentheses < 1) || (openBrackets.pop() != '(')) return false
        countParentheses -= 1
      }

    })

    countBrackets == 0 && countBraces == 0 && countParentheses == 0
  }
}