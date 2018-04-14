package mirabal.string

import mirabal.string.StringHelper.{PalindromeResult, StringPalindrome}

object Main extends App {
  require(args.length == 1, "String needs to be supplied")

  val input = args(0)
  input.findPalindromes(3)
    .map {
      case PalindromeResult(text, index, length) => s"Text: $text, Index: $index, Length: $length\n"
    }
    .foreach(println)
}
