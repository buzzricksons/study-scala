import sun.reflect.generics.tree.Tree

sealed trait BinaryTree {
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

}
