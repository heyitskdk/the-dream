# Reverse an Array

## Problem Description

You are given an array of integers `arr[]`.

Reverse the given array.

**Note:** Modify the array in place.

## Problem Constraints

```text
1 <= arr.size() <= 10^5
0 <= arr[i] <= 10^5
```

## Input Format

```text
The only argument given is an integer array arr[].
```

## Output Format

```text
Return the reversed array.
```

## Example Input

### Input 1

```text
arr = [1, 4, 3, 2, 6, 5]
```

### Input 2

```text
arr = [4, 5, 2]
```

### Input 3

```text
arr = [1]
```

## Example Output

### Output 1

```text
[5, 6, 2, 3, 4, 1]
```

### Output 2

```text
[2, 5, 4]
```

### Output 3

```text
[1]
```

## Example Explanation

### Explanation 1

```text
The elements of the array are [1, 4, 3, 2, 6, 5].
After reversing the array, the first element goes to the last position,
the second element goes to the second last position, and so on.
Hence, the answer is [5, 6, 2, 3, 4, 1].
```

### Explanation 2

```text
The elements of the array are [4, 5, 2].
The reversed array will be [2, 5, 4].
```

### Explanation 3

```text
The array has only a single element.
Hence, the reversed array is same as the original.
```