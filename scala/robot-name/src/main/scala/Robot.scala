class Robot() {

  var name: String = _;

  reset()

  def reset() = {
    name = generateUniqueName
  }

  private def generateUniqueName = {
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

object Robot {
  var char0 = 'A'
  var char1 = 'A'
  var char2 = '0'
  var char3 = '0'
  var char4 = '0'
}
