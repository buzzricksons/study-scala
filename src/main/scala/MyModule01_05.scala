object MyModule01_05 {
  def failingFn(i: Int): Int = {
    val y: Int = throw new Exception("fail!")
    try {
      val x = 42 + 5
      x + y
    }
    catch  { case e: Exception => 43}
  }

  def main(args: Array[String]): Unit = {
    println(failingFn(12))
  }

}
