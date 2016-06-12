/**
  * Created by mhd.ug on 6/12/16.
  */
object ImplicitConversion extends App {
  implicit def intToComplex(n: Int): Complex = new Complex(n, n)

  val c = new Complex()
  val imp = 2 * c

  println(implicitly(imp))

}

class Complex(val real: Int, val img: Int) {

  def this() = this(1, 1)

  def *(other: Complex): Complex = new Complex(other.real * real, other.img * img)

  def *(n: Int): Complex = new Complex(n * real, n * img)

  override def toString = {
    real.toString + {
      if (img < 0) "-" else "+"
    } + img + "i"
  }
}