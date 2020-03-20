import scala.collection.mutable

object MatchingBrackets {

  def isPaired(text: String): Boolean = {

    val lastBracket = mutable.Stack[Char]()
    val brackets = List(('[', ']'), ('{', '}'), ('(', ')'))

    text.chars().forEach(c => {
      brackets.
        filter(_._1 == c).
        foreach {
          case (c, _) => lastBracket.push(c)
        }

      brackets.
        filter(_._2 == c).
        foreach {
          case (openBracket, _) =>
            if (lastBracket.isEmpty || lastBracket.pop() != openBracket) return false
        }
    })

    lastBracket.isEmpty
  }

}