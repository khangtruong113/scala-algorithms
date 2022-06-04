package com.leetCode.lengthOfTheLongestSubstringWithoutRepeatingCharacters

object Solution1 {
  def lengthOfLongestSubstring(s: String): Int = {
    val l = s.length
    var m = 0
    for (
      i <- 0 to l;
      j <- i to l
    ) {
      if (s.substring(i, j).toSet.sizeCompare(s.substring(i, j)) == 0 && s.substring(i, j).length > m)
        m = s.substring(i, j).length
    }
    m
  }
}

