object Twofer {
  def twofer(): String = twofer("you")

  def twofer(name: String): String = String.format("One for %1$s, one for me.", name)
}
