package mirabal.string

import java.io.ByteArrayOutputStream

import org.scalatest.{FunSuite, Matchers}

class MainSuite extends FunSuite with Matchers {
  test("Run Main with string sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop") {
    val out = new ByteArrayOutputStream()

    Console.withOut(out) {
      Main.main(Array("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop"))
    }

    val expected =
      """Text: hijkllkjih, Index: 23, Length: 10
        |
        |Text: defggfed, Index: 13, Length: 8
        |
        |Text: abccba, Index: 5, Length: 6
        |
        |""".stripMargin

    out.toString should equal(expected)
  }
  
  test("Error is expected when no string is provided") {
    an [IllegalArgumentException] should be thrownBy {
      Main.main(Array.empty)
    }
  }
}
