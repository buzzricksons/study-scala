object MyModule01_03 {

  def main(args: Array[String]): Unit = {
    val x = (1 to 6).toArray
    x.takeWhile(_ < 3).foreach(println)
    x.dropWhile(_ < 3).foreach(println)
  }
}
