# Magic Number

## Problem Description

Given an integer `A`, find and return the `A`-th magic number.

A magic number is defined as a number that can be expressed as a power of `5` or as a sum of **unique** powers of `5`.

The first few magic numbers are:

```text
5, 25, 30 (5 + 25), 125, 130 (125 + 5), ...
```

## Problem Constraints

```text
1 <= A <= 5000
```

## Input Format

```text
The only argument given is integer A.
```

## Output Format

```text
Return the A-th magic number.
```

## Example Input

### Example Input 1

```text
A = 3
```

### Example Input 2

```text
A = 10
```

## Example Output

### Example Output 1

```text
30
```

### Example Output 2

```text
650
```

## Example Explanation

### Explanation 1

```text
Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
3rd element in this is 30
```

### Explanation 2

```text
In the sequence shown in explanation 1, 10th element will be 650.
```