object BeerSong {
  private val verse: Int => String = {
    case 0 =>
      "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    case 1 =>
      "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
    case 2 =>
      "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
    case verse => s"$verse bottles of beer on the wall, $verse bottles of beer.\n" +
      s"Take one down and pass it around, ${verse - 1} bottles of beer on the wall.\n"
  }

  def recite(firstVerse: Int, numberOfVerses: Int): String = {
    (firstVerse until (firstVerse - numberOfVerses) by -1).map(verse).reduce(_ + "\n" + _)
  }
}
