# Counting Frequencies of Array Elements

## Problem Description

Given an array `nums` of size `n`, which may contain duplicate elements.

Return a list of pairs where each pair contains a unique element from the array and its frequency in the array.

The result may be returned in any order, but each element must appear exactly once in the output.

## Problem Constraints

```text
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
```

## Input Format

```text
The only argument given is an integer array nums.
```

## Output Format

```text
Return a list of pairs where each pair contains a unique element and its frequency.
```

## Example Input

### Input 1

```text
nums = [1, 2, 2, 1, 3]
```

### Input 2

```text
nums = [5, 5, 5, 5]
```

## Example Output

### Output 1

```text
[[1, 2], [2, 2], [3, 1]]
```

### Output 2

```text
[[5, 4]]
```

## Example Explanation

### Explanation 1

```text
1 appears 2 times.
2 appears 2 times.
3 appears 1 time.

Order of output can vary.
```

### Explanation 2

```text
5 appears 4 times.
```