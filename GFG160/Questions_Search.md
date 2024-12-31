### Search Questions

### 29. Sorted and Rotated Minimum
```
Difficulty: Easy
Accuracy: 40.57%
Submissions: 138K+
Points: 2

A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 

Examples:
Input: arr[] = [5, 6, 1, 2, 3, 4]
Output: 1
Explanation: 1 is the minimum element in the array.

Input: arr[] = [3, 1, 2]
Output: 1
Explanation: Here 1 is the minimum element.

Input: arr[] = [4, 2, 3]
Output: 2
Explanation: Here 2 is the minimum element.

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 109
```

### 30. Search in Rotated Sorted Array
```
Difficulty: Medium
Accuracy: 37.64%
Submissions: 251K+
Points: 4

Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.

Examples :
Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is found at index 8.

Input: arr[] = [3, 5, 1, 2], key = 6
Output: -1
Explanation: There is no element that has value 6.

Input: arr[] = [33, 42, 72, 99], key = 42
Output: 1
Explanation: 42 is found at index 1.

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106
1 ≤ key ≤ 106
```

### 31. Peak element
```
Difficulty: Basic
Accuracy: 38.86%
Submissions: 518K+
Points: 1

Given an array arr[] where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak if it is greater than its adjacent elements (if they exist). If there are multiple peak elements, return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".

Note: Consider the element before the first element and the element after the last element to be negative infinity.

Examples :
Input: arr = [1, 2, 4, 5, 7, 8, 3]
Output: true
Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].

Input: arr = [10, 20, 15, 2, 23, 90, 80]
Output: true
Explanation: arr[1] = 20 and arr[5] = 90 are peak elements because arr[0] < arr[1] > arr[2] and arr[4] < arr[5] > arr[6]. 

Input: arr = [1, 2, 3]
Output: true
Explanation: arr[2] is a peak element because arr[1] < arr[2] and arr[2] is the last element, so it has negative infinity to its right.

Constraints:
1 ≤ arr.size() ≤ 106
-231 ≤ arr[i] ≤ 231 - 1
``` 