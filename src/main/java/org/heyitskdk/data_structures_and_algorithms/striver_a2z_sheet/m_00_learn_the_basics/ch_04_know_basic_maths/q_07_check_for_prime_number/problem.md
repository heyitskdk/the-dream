# Check for Prime Number

## Problem Description

Given a number `n`, determine whether it is a prime number or not.

A prime number is a number greater than `1` that has no positive divisors other than `1` and itself.

## Problem Constraints

```text
1 <= n <= 10^9
```

## Input Format

```text
The only argument given is an integer n.
```

## Output Format

```text
Return true if n is a prime number.
Return false otherwise.
```

## Example Input

### Input 1

```text
n = 7
```

### Input 2

```text
n = 25
```

### Input 3

```text
n = 1
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
7 has exactly two divisors: 1 and 7, making it a prime number.
```

### Explanation 2

```text
25 has more than two divisors: 1, 5, and 25, so it is not a prime number.
```

### Explanation 3

```text
1 has only one divisor, which is 1 itself.
This is not sufficient for it to be considered prime.
```