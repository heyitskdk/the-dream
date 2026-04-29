# Minimum Number of Help Requests

## Problem Description

Alex and Sam are good friends. Alex is doing a lot of programming these days, and he has set a target score of `A` for himself.

Initially, Alex's score is `0`. He can perform either of the following operations:

- Double his current score by solving a question.
- Take help from Sam, which increases his score by `1`.

Alex wants to reach **exactly** score `A`. He also wants to take as little help from Sam as possible.

Find and return the minimum number of times Alex needs to take help from Sam to achieve a score of `A`.

## Problem Constraints

```text
0 <= A <= 10^9
```

## Input Format

```text
The only argument given is an integer A.
```

## Output Format

```text
Return the minimum number of times help taken from Sam.
```

## Example Input

### Input 1

```text
A = 5
```

### Input 2

```text
A = 3
```

## Example Output

### Output 1

```text
2
```

### Output 2

```text
2
```

## Example Explanation

### Explanation 1

```text
Initial score : 0
Takes help from Sam, score : 1
Alex solves a question, score : 2
Alex solves a question, score : 4
Takes help from Sam, score : 5
```

### Explanation 2

```text
Initial score : 0
Takes help from Sam, score : 1
Alex solves a question, score : 2
Takes help from Sam, score : 3
```