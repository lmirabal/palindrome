package mirabal.string

import mirabal.string.StringHelper.{PalindromeResult, StringPalindrome}
import org.scalatest.{FunSuite, Matchers}

class PalindromeSuite extends FunSuite with Matchers {
  test("find the whole word to be a palindrome") {
    val result: Set[PalindromeResult] = "madam".findPalindromes
    result should contain only PalindromeResult("madam", 0, 5)
  }

  test("find palindrome in the middle") {
    val result = "bmadamq".findPalindromes
    result should contain only PalindromeResult("madam", 1, 5)
  }

  test("find palindromes in the edges") {
    val result = "madamqaba".findPalindromes
    result should contain only(
      PalindromeResult("madam", 0, 5),
      PalindromeResult("aba", 6, 3)
    )
  }

  test("find multiple palindromes") {
    val result = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop".findPalindromes
    result should contain only(
      PalindromeResult("hijkllkjih", 23, 10),
      PalindromeResult("defggfed", 13, 8),
      PalindromeResult("abccba", 5, 6),
      PalindromeResult("qrrq", 1, 4),
      PalindromeResult("mnnm", 35, 4),
      PalindromeResult("pop", 40, 3),
    )
  }

  test("empty result if could not find palindromes") {
    val result = "no-palindrome-found".findPalindromes
    result should be(empty)
  }
}
