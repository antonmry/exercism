object House {

  val names = List("house that Jack built", "malt", "rat", "cat", "dog",
    "cow with the crumpled horn", "maiden all forlorn", "man all tattered and torn",
    "priest all shaven and shorn", "rooster that crowed in the morn", "farmer sowing his corn",
    "horse and the hound and the horn")

  val verbs = List("lay in", "ate", "killed", "worried", "tossed", "milked", "kissed",
    "married", "woke", "kept", "belonged to")

  def reciteVerse(verse: Int): String =
    "This is the " + names(verse - 1) +
      (verse - 1 until 0 by -1)
        .map(i => s" that ${verbs(i - 1)} the ${names(i - 1)}")
        .mkString("") +
      ".\n"

  def recite(firstVerse: Int, lastVerse: Int): String =
    (firstVerse to lastVerse).map(reciteVerse).mkString("") + "\n"
}

