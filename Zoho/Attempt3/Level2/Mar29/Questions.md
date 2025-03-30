### Section A

1. Generate a Pattern:
    4 4 4 4 4 4 4 
    4 3 3 3 3 3 4 
    4 3 2 2 2 3 4 
    4 3 2 1 2 3 4 
    4 3 2 2 2 3 4 
    4 3 3 3 3 3 4 
    4 4 4 4 4 4 4 

2. You are given an array and an integer k = 5. Implement a program that reverses every consecutive k elements in the array. If the remaining elements are fewer than k but at least 2, reverse them as well.
    **Example:**
    Arr = {2, 1, 3, 5, 8, 6, 7, 9}
    k = 3

    **Output:**
    Arr = {3, 1, 2, 6, 8, 5, 9, 7}

### Section B

1. You are given an NxN matrix. Write a program to rotate the matrix 90 degrees clockwise in-place (i.e., without using extra space for another matrix).
    **Example:**
    1 2 3
    4 5 6
    7 8 9

    **output:** 
    7 4 1 
    8 5 2
    9 6 3

2. You are given two sorted arrays A and B that can be sorted in either ascending or descending order. Your task is to merge these arrays into a new array C, ensuring:

    C is always sorted in ascending order

    Duplicates are removed

    Only a single pass is allowed to merge and remove duplicates

    **Example 1:**
    Input:
    A = [2, 3, 56, 78, 90]
    B = [4, 4, 4, 56, 56, 78, 90, 90]

    **Output:**
    C = [2, 3, 4, 56, 78, 90]

    **Example 2:**
    Input:
    A = [9, 6, 3] (descending order)
    B = [5, 7, 8, 9] (ascending order)

    **Output:**
    C = [3, 5, 6, 7, 8, 9]

3. Given an integer N, find the next greater number using the same digits as N. If no such number exists, return -1.

    **Example 1:**
    Input:
    N = 315
    **Output:**
    351

    **Example 2:**
    Input:
    N = 4321
    **Output:**
    -1 (Since no greater number can be formed using the same digits)