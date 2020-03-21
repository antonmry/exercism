object BeerSong {
  def reciteVerse(verse: Int): String = verse match {
    case 0 =>
      "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    case 1 =>
      "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
    case 2 =>
      "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
    case _ => s"$verse bottles of beer on the wall, $verse bottles of beer.\n" +
      s"Take one down and pass it around, ${verse - 1} bottles of beer on the wall.\n"
  }

  def recite(verse: Int, numberOfVerses: Int): String = {
    ((verse - numberOfVerses + 1) to verse).reverse.map(reciteVerse(_)).reduce(_ + "\n" + _)
  }
}
