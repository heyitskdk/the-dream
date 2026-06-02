# All Indices Of Array

## Problem Description

Given an array of integers `A` with `N` elements and a target integer `B`, find all the indices at which `B` occurs in the array.

**Note:** The problem encourages recursive logic for learning purposes. Although the online judge does not enforce recursion, it is recommended to use recursive solutions to align with the question's spirit.

## Problem Constraints

```text
1 <= N <= 10^3
1 <= A[i] <= 10^3
1 <= B <= 10^3
```

It is guaranteed that the target `B` exists at least once in array `A`.

## Input Format

```text
First argument is an array of integers, A.
Second argument is the target integer, B.
```

## Output Format

```text
Return the sorted array of indices.
```

## Example Input

### Input 1

```text
A = [1, 2, 3, 4, 5]
B = 1
```

### Input 2

```text
A = [8, 9, 5, 6, 5, 5]
B = 5
```

## Example Output

### Output 1

```text
[0]
```

### Output 2

```text
[2, 4, 5]
```

## Example Explanation

### Explanation 1

```text
The target 1 occurs at index 0.
So, return [0].
```

### Explanation 2

```text
The target 5 occurs at indices [2, 4, 5].
```