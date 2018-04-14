Palindrome Finder:
==================

Console application that finds the 3 longest unique palindromes in a supplied string. For the 3 longest palindromes, 
report the palindrome, start index and length, in descending order of length and ascending order of index if same
length.

## Run
In order to run the application, please run the following command:  
```./sbt "run <string>"```
  
For example:  
```./sbt "run sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop"```  
  
It will produce the following output:  
```
Text: hijkllkjih, Index: 23, Length: 10

Text: defggfed, Index: 13, Length: 8

Text: abccba, Index: 5, Length: 6
```  
  
Note: Using sbt extras so that the build tool sbt doesn't need to be pre-installed.  
https://github.com/paulp/sbt-extras  
  
  
#### Author:
Luis Mirabal  
lmirabal@gmail.com