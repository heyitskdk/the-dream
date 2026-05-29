# Check if the Number is Armstrong

## Problem Description

You are given an integer `n`.

Check whether it is an Armstrong number or not.

Return `true` if it is an Armstrong number, otherwise return `false`.

An Armstrong number is a number that is equal to the sum of its digits, where each digit is raised to the power of the number of digits.

## Problem Constraints

```text
0 <= n <= 10^9
```

## Input Format

```text
The only argument given is an integer n.
```

## Output Format

```text
Return true if n is an Armstrong number.
Return false otherwise.
```

## Example Input

### Input 1

```text
n = 153
```

### Input 2

```text
n = 12
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

## Example Explanation

### Explanation 1

```text
Number of digits: 3

1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153

Therefore, it is an Armstrong number.
```

### Explanation 2

```text
Number of digits: 2

1^2 + 2^2 = 1 + 4 = 5

Therefore, it is not an Armstrong number.
```