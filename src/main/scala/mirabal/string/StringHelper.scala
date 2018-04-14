package mirabal.string

import scala.collection.SortedSet

object StringHelper {

  implicit class StringPalindrome(value: String) {

    import StringPalindrome.{MinLength, OrderByLengthDescIndexAsc}

    def findPalindromes: List[PalindromeResult] = {
      findPalindromes(0, value.length, SortedSet.empty(OrderByLengthDescIndexAsc)).toList
    }

    def isPalindrome: Boolean = value.equals(value.reverse)

    private def findPalindromes(begin: Int, end: Int, acc: Set[PalindromeResult]): Set[PalindromeResult] = {
      val currentLength = end - begin
      if (currentLength < MinLength) return acc

      val current = value.substring(begin, end)
      if (current.isPalindrome) {
        val result = PalindromeResult(current, begin, currentLength)
        findPalindromes(begin + current.length, value.length, acc + result)
      }
      else if (currentLength == MinLength) findPalindromes(begin + 1, value.length, acc)
      else findPalindromes(begin, end - 1, acc)
    }
  }

  object StringPalindrome {
    private val MinLength = 3
    private val OrderByLengthDescIndexAsc = Ordering[(Int, Int)].on[PalindromeResult](r => (-r.length, r.index))
  }

  case class PalindromeResult(value: String, index: Int, length: Int)

}