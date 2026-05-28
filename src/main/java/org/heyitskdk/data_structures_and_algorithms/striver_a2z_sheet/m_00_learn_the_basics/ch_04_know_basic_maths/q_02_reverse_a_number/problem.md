# Reverse Integer

## Problem Description

Given a signed 32-bit integer `x`, return `x` with its digits reversed.

If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, then return `0`.

Assume the environment does not allow you to store 64-bit integers, signed or unsigned.

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
Return the integer x with its digits reversed.
If the reversed integer goes outside the signed 32-bit integer range, return 0.
```

## Example Input

### Input 1

```text
x = 123
```

### Input 2

```text
x = -123
```

### Input 3

```text
x = 120
```

## Example Output

### Output 1

```text
321
```

### Output 2

```text
-321
```

### Output 3

```text
21
```

## Example Explanation

### Explanation 1

```text
The reverse of 123 is 321.
```

### Explanation 2

```text
The reverse of -123 is -321.
```

### Explanation 3

```text
The reverse of 120 is 21.
```