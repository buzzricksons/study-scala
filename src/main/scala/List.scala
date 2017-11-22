

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
//    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(h, t) => Cons(h, append(t, a2))
  }

  def dropWhile[A](as: List[A])(f: A => Boolean): List[A] = as match {
    case Cons(h, t) if f(h) => dropWhile(t)(f)
    case _ => as
  }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  def sum2(ns: List[Int]) =
    foldRight(ns, 0)((x, y) => x + y)

  def product2(ns: List[Double]) =
    foldRight(ns, 1.0)(_ * _)//_ * _ is simple version of (x, y) => x * y


  def main(args: Array[String]): Unit = {
    val ex1: List[Double] = Nil
    val ex2: List[Int] = Cons(1, Nil)
    val ex3: List[String] = Cons("a", Cons("b", Nil))

    println(List(1,2,3) match { case _ => 42 })
    println(List(1,2,3) match { case Cons(h, _) => h })
    println(List(1,2,3) match { case Cons(_, t) => t })
//    println(List(1,2,3) match { case Nil => 42 }) //Match Error

    val xs: List[Int] = List(1,2,3,4,5)
    val ex1_1 = dropWhile(xs)(x => x < 4)
    println(ex1_1)
  }

}
