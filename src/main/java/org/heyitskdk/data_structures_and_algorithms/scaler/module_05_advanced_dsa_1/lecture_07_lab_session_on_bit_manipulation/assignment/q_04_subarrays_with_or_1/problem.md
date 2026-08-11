# Subarrays with OR 1

## Problem Description

You are given a binary array A of length N where each element is either 0 or 1.

Your task is to count the number of subarrays where the bitwise OR of all the elements in the subarray is 1.

## Problem Constraints

```text
1 <= N <= 10^4
A[i] is either 0 or 1
```

## Input Format

The First and the only argument is an Integer Array where each element is either 0 or 1.

## Output Format

Return a single Integer representing the number of subarrays where the bitwise OR is 1

## Example Input

### Input 1:

```text
A = [0, 0, 1, 1, 0]
```

### Input 2:

```text
A = [0, 0, 0]
```

## Example Output

### Output 1:

```text
11
```

### Output 2:

```text
0
```

## Example Explanation

### Explanation 1:

The only subarrays with OR = 1 are

```text
[0, 0, 1], [0, 0, 1, 1], [1], [1], [1, 1], [1, 0], [1, 1, 0], [0, 0, 1, 1, 0], [0, 1], [0, 1, 1], [0, 1, 1, 0]
```

### Explanation 2:

There is no subarray, whose bitwise OR is 0.