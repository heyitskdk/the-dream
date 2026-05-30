# Fibonacci Number

## Problem Description

The Fibonacci numbers, commonly denoted as `F(n)`, form a sequence called the Fibonacci sequence.

Each number in the sequence is the sum of the two preceding numbers, starting from `0` and `1`.

```text
F(0) = 0
F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1
```

Given `n`, calculate `F(n)`.

## Problem Constraints

```text
0 <= n <= 30
```

## Input Format

```text
The only argument given is an integer n.
```

## Output Format

```text
Return F(n).
```

## Example Input

### Input 1

```text
n = 2
```

### Input 2

```text
n = 3
```

### Input 3

```text
n = 4
```

## Example Output

### Output 1

```text
1
```

### Output 2

```text
2
```

### Output 3

```text
3
```

## Example Explanation

### Explanation 1

```text
F(2) = F(1) + F(0) = 1 + 0 = 1.
```

### Explanation 2

```text
F(3) = F(2) + F(1) = 1 + 1 = 2.
```

### Explanation 3

```text
F(4) = F(3) + F(2) = 2 + 1 = 3.
```