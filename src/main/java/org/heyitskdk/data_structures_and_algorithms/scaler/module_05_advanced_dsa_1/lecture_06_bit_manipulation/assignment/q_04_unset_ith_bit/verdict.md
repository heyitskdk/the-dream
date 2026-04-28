# Unset i-th Bit — Review

**Verdict: 7/10.** Correct, O(1) time, O(1) space.<br>
The logic is right and the code works. But this is a one-liner problem, and you wrote two lines and a branch — that's the gap.

## What's good
- You correctly identified that XOR toggles, so XOR-ing only when the bit is set produces "unset if set, leave alone if not."
- The mask construction `1 << B` is idiomatic.
- No off-by-one on the 0-indexed bit position — many candidates trip on this.

## The upgrade: one expression, no branch
The canonical way to clear a bit is:

```java
return A & ~(1 << B);
```

That's it. Whole problem. Let's understand why this is *strictly better* than your version, not just shorter.

**How it works:**
- `1 << B` builds a mask with a 1 at position B and 0s everywhere else.
- `~(1 << B)` flips it: now there's a **0 at position B** and **1s everywhere else**.
- `A & ~(1 << B)` ANDs with `A`: every bit AND-ed with 1 stays itself; the bit at position B is AND-ed with 0, forcing it to 0.

**Net effect:** position B becomes 0; every other bit is preserved. Doesn't matter whether the bit was set or not — the result is the same either way. That's why the branch is unnecessary.

**Why this is better than your version:**
- **No branch** — branchless code is faster on modern CPUs (no pipeline flush risk on misprediction). Trivial here, but **the mindset matters at scale.**
- **Idempotent and obviously correct** — "AND with a mask that has 0 only at position B" maps directly to "force position B to 0." Your version requires the reader to trace: *"If set, XOR will flip it to 0; if unset, we skip, so it stays 0 — okay, both branches end at 0."* More cognitive load to verify.
- **Generalizes** — `A & mask` with a custom mask clears *any* set of bits at once. Your XOR-with-conditional doesn't generalize.

## The bit-manipulation primitive table
This problem is a member of a very small family. Memorize all four — they come up constantly:

| Operation        | Expression                              | Why                                          |
|------------------|-----------------------------------------|----------------------------------------------|
| **Set** bit B    | `A \| (1 << B)`                         | OR with 1 forces to 1, OR with 0 preserves   |
| **Clear** bit B  | `A & ~(1 << B)`                         | AND with 0 forces to 0, AND with 1 preserves |
| **Toggle** bit B | `A ^ (1 << B)`                          | XOR with 1 flips, XOR with 0 preserves       |
| **Test** bit B   | `(A >> B) & 1` or `(A & (1 << B)) != 0` | Isolate the bit                              |

These four cover ~90% of bit-manipulation interview questions when combined with the two idioms from last review (`n & (n-1)` and `n & -n`).<br>
**Action:** write these on a card. Drill them until they're reflexive. At the elite bar, you should not be *deriving* these in an interview — you should be *applying* them.

## Meta-feedback
- You over-engineered a one-liner. This is a real interview pattern: when a problem feels almost-trivial, **resist the urge to add structure**. The interviewer is testing whether you reach for the cleanest primitive — adding a branch signals you don't fully trust the underlying operation.
- Your XOR-toggle insight was correct but applied to the wrong tool. You used XOR (which *flips*) and then guarded it conditionally to *not* flip when the bit was 0 — effectively reconstructing AND-with-NOT-mask the long way around. **AND is the natural tool for "force to 0," XOR is the natural tool for "flip."** Match the operation to the intent.
- Read the problem statement one more time: *"If unset, leave as it is."* That phrasing is a hint that the correct operation should *not care* about the current state. Whenever a problem says "do X if condition, else leave alone," ask yourself: *is there a single operation whose behavior on the 'else' case is a no-op?* For "unset bit," AND-with-0 forces 0 *and* AND-with-1 is a no-op on 0 — perfect match.

## Action item
Solve **Set i-th Bit** and **Toggle i-th Bit** as warm-ups (each is one line — confirm you can write them without thinking).<br>
Then solve **Number of 1 Bits between A and B** (i.e., count set bits in a range of integers) — it forces you to combine bit-manipulation with a math observation, and is a classic Google-style "looks easy, isn't" problem.