# Finding Good Days — Review

**Verdict: 9.5/10.** Correct, optimal, and you saw through the disguise.<br>
The comment alone earns half the score.

## What's good
- **You recognized the problem.** Day `d` contributes `2^(d-1)`; the total is a sum of distinct powers of 2 → binary representation. Number of days she behaved = number of 1 bits in A.
- That recognition *is* the skill being tested. Most candidates start simulating days; you wrote three lines of bit math.
- "Brian Kernighan says hold my coffee" — right energy. In interviews phrase it soberly: *"set-bit counting in disguise; Kernighan gives one iteration per set bit."*
- Textbook Kernighan: `n &= n - 1` clears lowest set bit, count iterations.

## Bug-class to flag (constraint protects you, not the code)
- `1 <= A <= 2^31 - 1` = `Integer.MAX_VALUE` exactly. A is always positive → safe.
- But: `while (num > 0)` is the same family of bug as your earlier Count Set Bits.
- **Kernighan is sign-agnostic** — `n & (n-1)` works on negatives too (e.g., `-1 = 1111...1111` decrements through cleanly to 0).
- Prefer `num != 0` over `num > 0`. Costs nothing, hardens against constraint change.
- Read constraints as *"the problem-setter chose this number for a reason."* `2^31 - 1` is the exact `int` boundary — relax it and `long` becomes mandatory.

## Production / interview move
```java
return Integer.bitCount(A);
```
Intrinsifies to hardware `POPCNT` on x86, SWAR elsewhere. Strictly faster.

Two-sentence interview script:
> *"In production I'd use `Integer.bitCount` — intrinsifies to a single CPU instruction. Manually, Kernighan's trick: `n & (n-1)` clears the lowest set bit, so the loop runs once per set bit instead of once per bit position."*

Signals taste + depth + platform awareness. Free points.

## What to say at the whiteboard
> *"Total = sum of `2^(d-1)` over good days. Any positive integer has a unique decomposition into distinct powers of 2 — its binary representation. Answer = number of set bits in A."*

That sentence solves the problem. Code is formality afterwards. Stating it before writing code is a power move.

## Meta-feedback
- **First time you've unmasked a story-shaped wrapper to find the primitive underneath.** Highest-leverage skill at FAANG-tier.
- Most "tricky" problems = familiar primitives in costume. Coins, days, batteries, robots, distances → counting, sorting, two-pointers, bit math, prefix sums, BFS/DFS, or DP.
- Habit: before coding, ask *"what is this problem stripped of its story?"* If you can name the primitive in one sentence, you're 80% done.
- **Calibration:** don't just *recognize*, also *justify* briefly. *"The doubling means each day = `2^(d-1)`, total is a sum of distinct such powers, hence set bits."* The second clause is the proof, not just the recognition. Interviewers want both.

## Minor
- `int num = A;` — defensive primitive copy is unnecessary in Java. Harmless habit.
- `days` vs. `count` — equivalent, not worth a thought.

## Action item
**Min XOR Value** — find pair with minimum XOR.<br>
Sort + adjacent pairs is the "aha" with a beautiful proof. Where bit manipulation graduates from primitives to algorithmic structure.