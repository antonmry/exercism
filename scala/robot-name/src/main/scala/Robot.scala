class Robot() {

  private var internalName: String = _;

  def name: String = internalName

  reset()

  def reset() = {
    internalName = Robot.generateUniqueName
  }
}

object Robot {
  private var char0 = 0
  private var char1 = 0
  private var char2 = 0
  private var char3 = 0
  private var char4 = 0

  private def generateUniqueName = {
    this.synchronized {
      if (char4 == 9) {
        if (char3 == 9) {
          if (char2 == 9) {
            if (char1 == 25) {
              if (char0 == 25) {
                char0 = 0
                char1 = 0
                char2 = 0
                char3 = 0
                char4 = 0
              } else {
                char0 += 1
                char1 = 0
                char2 = 0
                char3 = 0
                char4 = 0
              }
            } else {
              char1 += 1
              char2 = 0
              char3 = 0
              char4 = 0
            }
          } else {
            char2 += 1
            char3 = 0
            char4 = 0
          }
        } else {
          char3 += 1
          char4 = 0
        }
      } else {
        char4 += 1
      }

      "" + ('A' to 'Z') (char0) + ('A' to 'Z') (char1) + ('0' to '9') (char2) + ('0' to '9') (char3) + ('0' to '9') (char4)
    }
  }
}
