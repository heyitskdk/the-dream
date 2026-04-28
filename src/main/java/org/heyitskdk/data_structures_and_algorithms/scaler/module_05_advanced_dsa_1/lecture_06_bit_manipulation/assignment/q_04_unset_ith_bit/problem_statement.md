## Problem Description

You are given two integers `A` and `B`.<br>
If `B`-th bit in `A` is set, make it unset.<br>
If `B`-th bit in `A` is unset, leave as it is.<br>
Return the updated `A` value.<br><br>
**Note:**<br>
The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0.

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
4
```

**Output 2:**
```
1
```

---

## Example Explanation

**Explanation 1:**<br>
Given `A = 4` which is `100` in binary. The 1st bit is already unset.

**Explanation 2:**<br>
Given `A = 5` which is `101` in binary. We unset the 2nd bit.<br>
It becomes `001` which is `1` in decimal.