import scala.collection.mutable

object MatchingBrackets {

  def isPaired(text: String): Boolean = {

    val lastBracket = mutable.Stack[Char]()
    val openBrackets = Array('[', '{', '(')
    val closeBrackets = Array(']', '}', ')')

    (0 until text.length).foreach(v => {
      if (openBrackets contains text.charAt(v)) {
        lastBracket.push(text.charAt(v))
      }

      if (closeBrackets contains text.charAt(v)) {
        if (lastBracket.isEmpty || lastBracket.pop() != openBrackets(closeBrackets.indexOf(text.charAt(v)))) return false
      }
    })

    lastBracket.isEmpty
  }
}