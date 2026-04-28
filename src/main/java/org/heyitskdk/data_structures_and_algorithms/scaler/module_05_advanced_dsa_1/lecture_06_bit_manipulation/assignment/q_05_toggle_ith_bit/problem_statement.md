## Problem Description

You are given two integers `A` and `B`.<br>
If `B`-th bit in `A` is set, make it unset.<br>
If `B`-th bit in `A` is unset, make it set.<br>
Return the updated `A` value.

---

## Problem Constraints

- `1 <= A <= 10^9`
- `0 <= B <= 30`

---

## Input Format

First argument `A` is an integer.<br>
Second argument `B` is an integer.

---

## Output Format

Return an integer.

---

## Example Input

**Input 1:**
```
A = 4
B = 1
```

**Input 2:**
```
A = 5
B = 2
```

---

## Example Output

**Output 1:**
```
6
```

**Output 2:**
```
1
```

---

## Example Explanation

**Explanation 1:**<br>
Given `A = 4` which is `100` in binary. The 1st bit is unset,<br>
so we make it set. It becomes `110` which is `6` in decimal.

**Explanation 2:**<br>
Given `A = 5` which is `101` in binary. The 2nd bit is set,<br>
so we make it unset. It becomes `001` which is `1` in decimal.