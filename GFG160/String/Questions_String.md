### String Questions

### 16. Anagram
```
Difficulty: Easy
Accuracy: 44.93%
Submissions: 364K+
Points: 2

Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

Note: You can assume both the strings s1 & s2 are non-empty.

Examples :

Input: s1 = "geeks", s2 = "kseeg"
Output: true
Explanation: Both the string have same characters with same frequency. So, they are anagrams.
Input: s1 = "allergy", s2 = "allergic"
Output: false
Explanation: Characters in both the strings are not same, so they are not anagrams.
Input: s1 = "g", s2 = "g"
Output: true
Explanation: Character in both the strings are same, so they are anagrams.

Constraints:
1 ≤ s1.size(), s2.size() ≤ 105
```

### 17. Non Repeating Character
```
Difficulty: Easy
Accuracy: 40.43%
Submissions: 258K+
Points: 2

Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s. If there is no non-repeating character, return '$'.
Note: When you return '$' driver code will output -1.

Examples:

Input: s = "geeksforgeeks"
Output: 'f'
Explanation: In the given string, 'f' is the first character in the string which does not repeat.
Input: s = "racecar"
Output: 'e'
Explanation: In the given string, 'e' is the only character in the string which does not repeat.
Input: s = "aabbccc"
Output: -1
Explanation: All the characters in the given string are repeating.

Constraints:
1 <= s.size() <= 105
```

### 20. String Rotations of Each Other
```
Difficulty: Easy
Accuracy: 43.83%
Submissions: 226K+
Points: 2

You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

Note: The characters in the strings are in lowercase.

Examples :

Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: After 2 right rotations, s1 will become equal to s2.
Input: s1 = "aab", s2 = "aba"
Output: true
Explanation: After 1 left rotation, s1 will become equal to s2.
Input: s1 = "abcd", s2 = "acbd"
Output: false
Explanation: Strings are not rotations of each other.

Constraints:
1 <= s1.size(), s2.size() <= 105
```