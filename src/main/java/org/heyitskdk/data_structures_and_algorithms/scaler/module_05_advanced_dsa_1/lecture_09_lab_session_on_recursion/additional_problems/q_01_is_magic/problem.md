# Is Magic?

## Problem Description

Given a number `A`, check if it is a magic number or not.

A number is said to be a magic number if the sum of its digits is calculated recursively until a single digit is obtained.

If the single digit comes out to be `1`, then the number is a magic number.

## Problem Constraints

```text
1 <= A <= 10^9
```

## Input Format

```text
The first and only argument is an integer A.
```

## Output Format

```text
Return 1 if the given number is magic.
Return 0 otherwise.
```

## Example Input

### Input 1

```text
A = 83557
```

### Input 2

```text
A = 1291
```

## Example Output

### Output 1

```text
1
```

### Output 2

```text
0
```

## Example Explanation

### Explanation 1

```text
Sum of digits of 83557 = 28
Sum of digits of 28 = 10
Sum of digits of 10 = 1

The single digit is 1, so it is a magic number.
Return 1.
```

### Explanation 2

```text
Sum of digits of 1291 = 13
Sum of digits of 13 = 4

The single digit is not 1, so it is not a magic number.
Return 0.
```