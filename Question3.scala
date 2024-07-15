object Question3 {
  def main(args: Array[String]): Unit = {
    print("Enter a number: ")
    try {
      val input = scala.io.StdIn.readInt()
      for (i <- 0 until input) {
        print(s"${Fibonacci(i)}, ")
      }
      println("")
    } catch {
      case _: NumberFormatException =>
        println("Please enter a valid integer!")
    }
  }

  def Fibonacci(n: Int): Int = {
    if (n <= 1)
      n
    else
      Fibonacci(n - 1) + Fibonacci(n - 2)
  }
}

