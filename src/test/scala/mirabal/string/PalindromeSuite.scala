package mirabal.string

import mirabal.string.StringHelper.StringPalindrome
import org.scalatest.{FunSuite, Matchers}

class PalindromeSuite extends FunSuite with Matchers {
  test("find the whole word to be a palindrome") {
    val result: Set[String] = "madam".findPalindromes
    result should contain only "madam"
  }

  test("find palindrome in the middle") {
    val result = "bmadamq".findPalindromes
    result should contain only "madam"
  }

  test("find palindromes in the edges") {
    val result = "madamqaba".findPalindromes
    result should contain only("madam", "aba")
  }

  test("find multiple palindromes") {
    val result = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop".findPalindromes
    result should contain only("hijkllkjih", "defggfed", "abccba", "qrrq", "mnnm", "pop")
  }

  test("empty result if could not find palindromes") {
    val result = "no-palindrome-found".findPalindromes
    result should be(empty)
  }
}
