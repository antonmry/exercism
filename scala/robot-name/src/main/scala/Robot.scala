class Robot() {

  private var internalName: String = _;

  def name: String = internalName

  reset()

  def reset() = {
    internalName = Robot.generateUniqueName
  }
}

object Robot {
  private var char0 = 'A'
  private var char1 = 'A'
  private var char2 = '0'
  private var char3 = '0'
  private var char4 = '0'

  private def generateUniqueName = {
    this.synchronized {
      if (Robot.char4 == '9') {
        if (Robot.char3 == '9') {
          if (Robot.char2 == '9') {
            if (Robot.char1 == 'Z') {
              if (Robot.char0 == 'Z') {
                Robot.char0 = 'A'
                Robot.char1 = 'A'
                Robot.char2 = '0'
                Robot.char3 = '0'
                Robot.char4 = '0'
              } else {
                Robot.char0 = (Robot.char0.toInt + 1).toChar
                Robot.char1 = 'A'
                Robot.char2 = '0'
                Robot.char3 = '0'
                Robot.char4 = '0'
              }
            } else {
              Robot.char1 = (Robot.char1.toInt + 1).toChar
              Robot.char2 = '0'
              Robot.char3 = '0'
              Robot.char4 = '0'
            }
          } else {
            Robot.char2 = (Robot.char2.toInt + 1).toChar
            Robot.char3 = '0'
            Robot.char4 = '0'
          }
        } else {
          Robot.char3 = (Robot.char3.toInt + 1).toChar
          Robot.char4 = '0'
        }
      } else {
        Robot.char4 = (Robot.char4.toInt + 1).toChar
      }

      "" + Robot.char0 + Robot.char1 + Robot.char2 + Robot.char3 + Robot.char4
    }
  }
}
