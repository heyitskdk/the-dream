## Consolidated Review

**Mode:** Solution review only

### Core assessment
Your solution is incorrect.

### Main correctness issue
The bug is here:
`1 << i`

Because `1` is an `int`, the shift is done in 32-bit arithmetic, not `long`.

This fails for large `i`:
- `B` can be up to `60`
- in Java, `int` shifts use only the lower 5 bits of the shift count
- so shifting by 32 or more does not behave as intended

That makes the solution wrong for valid inputs.

### Why the approach is also weaker
You are clearing bits one by one:
for (int i = 0; i < B; i++) {
A &= ~(1 << i);
}

But the problem is directly:
- zero out the lowest `B` bits
- keep all higher bits unchanged

This should be solved in one step.

### Stronger solutions

Best simple version:
public class Solution {
public long solve(long A, int B) {
return (A >> B) << B;
}
}

Also valid:
public class Solution {
public long solve(long A, int B) {
return A & ~((1L << B) - 1);
}
}

Important: use `1L`, not `1`.

### Why these work
They unset the rightmost `B` bit positions directly:
- `(A >> B) << B` removes the lowest `B` bits and appends `B` zeroes
- `A & ~((1L << B) - 1)` creates a mask with the lowest `B` bits as `0` and the rest as `1`

### Edge cases
- large `B`, such as `40` or `60`
- `B` larger than the number of significant bits in `A` → answer should become `0`
- 64-bit constraint handling must be correct

### Complexity
Your version:
- **Time:** `O(B)`
- **Space:** `O(1)`

Optimal version:
- **Time:** `O(1)`
- **Space:** `O(1)`

### What a top-tier interviewer would challenge
- Why are you looping instead of using a direct mask?
- Are the shifts being done in `int` or `long`?
- What happens in Java for shifts larger than 31 on `int`?

### Underlying pattern
This is a **clear-lower-k-bits / bitmask / truncation** problem.

Equivalent interpretation:
- zero out lowest `B` bits
- round down to a multiple of `2^B`

### Verdict
**Fail** at top-tier bar

### Score
**4/10**

### Top 3 improvements
1. Use the correct integer width for bit operations (`long` vs `int`)
2. Recognize direct masking/truncation patterns instead of iterative bit clearing
3. Be fluent with Java shift semantics under 64-bit constraints

### One focused practice recommendation
Practice Java bit-manipulation problems involving masks, 64-bit shifts, and clearing lower `k` bits until these transformations become immediate.