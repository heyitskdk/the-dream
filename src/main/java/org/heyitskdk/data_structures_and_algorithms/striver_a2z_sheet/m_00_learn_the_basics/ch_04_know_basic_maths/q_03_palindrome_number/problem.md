# Palindrome Number

## Problem Description

Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.

A palindrome number reads the same from left to right and from right to left.

## Problem Constraints

```text
-2^31 <= x <= 2^31 - 1
```

## Input Format

```text
The only argument given is an integer x.
```

## Output Format

```text
Return true if x is a palindrome.
Return false otherwise.
```

## Example Input

### Input 1

```text
x = 121
```

### Input 2

```text
x = -121
```

### Input 3

```text
x = 10
```

## Example Output

### Output 1

```text
true
```

### Output 2

```text
false
```

### Output 3

```text
false
```

## Example Explanation

### Explanation 1

```text
121 reads as 121 from left to right and from right to left.
```

### Explanation 2

```text
From left to right, it reads -121.
From right to left, it becomes 121-.
Therefore it is not a palindrome.
```

### Explanation 3

```text
10 reads as 01 from right to left.
Therefore it is not a palindrome.
```