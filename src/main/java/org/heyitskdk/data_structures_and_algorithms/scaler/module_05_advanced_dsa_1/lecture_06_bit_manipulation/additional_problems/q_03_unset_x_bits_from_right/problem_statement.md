# Unset X Bits from Right

## Problem Description

Given an integer `A`, unset `B` bits from the right of `A` in binary.

For example, if `A = 93` and `B = 4`, the binary representation of `A` is `1011101`.
If we unset the rightmost `4` bits, we get the binary number `1010000`, which is equal to the decimal value `80`.

## Problem Constraints

```text
1 <= A <= 10^18
1 <= B <= 60
```

## Input Format

```text
The first argument is a single integer A.
The second argument is a single integer B.
```

## Output Format

```text
Return the number with B unset bits from the right.
```

## Example Input

### Input 1

```text
A = 25
B = 3
```

### Input 2

```text
A = 37
B = 3
```

## Example Output

### Output 1

```text
24
```

### Output 2

```text
32
```

## Example Explanation

### Explanation 1

```text
A = 11001 to 11000
```

### Explanation 2

```text
A = 100101 to 100000
```