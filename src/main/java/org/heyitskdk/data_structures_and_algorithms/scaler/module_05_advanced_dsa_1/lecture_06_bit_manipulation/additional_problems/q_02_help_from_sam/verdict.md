## Consolidated Review

**Mode:** Solution review only

### Core assessment
Your solution is correct. The minimum number of times Alex needs help is exactly the **number of set bits in `A`**.

### Why this works
- `+1` from Sam is the only operation that creates a new `1` bit
- doubling is equivalent to a left shift
- so constructing `A` optimally is equivalent to constructing its binary representation
- each `1` bit requires exactly one help operation

Equivalent reverse view:
- if `A` is odd, the last step must have been `+1`
- if `A` is even, the last step could have been doubling
- therefore the answer is the count of `1`s in `A`

### Code assessment
Your Brian Kernighan implementation is correct:
for (int num = A; num > 0; num &= (num - 1)) setBits++;

It removes one set bit per iteration, so the number of iterations equals the popcount.

### Edge cases
- `A = 0` → `0`
- powers of 2 → `1`
- numbers like `7` (`111`) → `3`

### Complexity
- **Time:** `O(number of set bits)`, worst case `O(log A)`
- **Space:** `O(1)`

### Main feedback
1. Correct solution and good implementation
2. The main weakness is communication, not logic
3. In an interview, do not say “from memory”; state the binary invariant clearly

### Better interview phrasing
“The answer is the number of set bits in `A`, because doubling shifts the current value left in binary, while each help operation contributes one required `1` bit.”

### What a top-tier interviewer may ask
- Why is this minimal, not just valid?
- Can you prove each `1` bit corresponds to one help operation?
- Can you explain it without relying on the bit trick?

### Underlying pattern
This is a **reverse-process / popcount / binary-construction** problem.

### Verdict
**Pass** at top-tier bar

### Score
**8/10**

### Top 3 improvements
1. Lead with the binary invariant before the implementation
2. Give a minimal correctness proof, not just the algorithm
3. Avoid “I remember this” style reasoning in interviews

### One focused practice recommendation
Practice problems where the optimal answer comes from analyzing the target in reverse and reducing it to a bit-based invariant.