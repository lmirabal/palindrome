package mirabal.string

object StringHelper {

  implicit class StringPalindrome(value: String) {

    import StringPalindrome.MinLength

    def findPalindromes: Set[String] = {
      findPalindromes(value, value, Set.empty)
    }

    def isPalindrome: Boolean = value.equals(value.reverse)

    private def findPalindromes(current: String, remaining: String, acc: Set[String]): Set[String] = {
      if (remaining.length < MinLength) acc
      else if (current.length < MinLength) {
        val updatedRemaining = remaining.tail
        findPalindromes(updatedRemaining, updatedRemaining, acc)
      }
      else if (current.isPalindrome) {
        val updatedRemaining = remaining.drop(current.length)
        findPalindromes(updatedRemaining, updatedRemaining, acc + current)
      }
      else findPalindromes(current.init, remaining, acc)
    }
  }

  object StringPalindrome {
    private val MinLength = 3
  }

}