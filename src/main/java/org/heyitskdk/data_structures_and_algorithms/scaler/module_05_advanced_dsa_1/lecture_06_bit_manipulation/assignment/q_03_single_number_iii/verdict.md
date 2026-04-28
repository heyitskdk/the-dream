# Single Number III — Review

**Verdict: 8/10.** Correct, O(n) time, O(1) space, all the right ideas in the right order.<br>
You executed the canonical algorithm cleanly. The gap to 9.5 is one idiom and one bug-class awareness.

## What's good
- **Three-phase structure is exactly right:** XOR all → find a differentiating bit → partition and XOR each group.<br>That you arrived at this without scaffolding suggests the previous problem's review landed.
- Returning sorted via a single ternary at the end is clean — no unnecessary `Arrays.sort` for a 2-element array.
- Variable name `xor` clearly signals intent.

## Upgrade: use `n & -n` to isolate the lowest set bit
Your bit-finding loop works but is doing manually what one expression does atomically:

```java
int diffBit = xor & -xor;   // isolates the LOWEST set bit as a mask
```

Then partition with `(num & diffBit) == 0` instead of `((num >> i) & 1) == 0`.<br>
This is the `n & -n` idiom from the bit-library — **this is the problem where it earns its keep**, exactly as I flagged in the previous review. Worth recognizing and reaching for reflexively.

**Why it works:** in two's complement, `-n` is `~n + 1`. The `+1` propagates through the trailing zeros of `n`, flipping them back to zeros after the bitwise-not, and stops at the lowest set bit (which `~n` had flipped to 0, but `+1` flips back to 1). Everything above that bit in `-n` is the inverse of `n`, so AND wipes it. Net result: only the lowest set bit survives.

Cleaner full version:
```java
public int[] solve(int[] A) {
    int xor = 0;
    for (int num : A) xor ^= num;

    int diffBit = xor & -xor;

    int a = 0, b = 0;
    for (int num : A) {
        if ((num & diffBit) == 0) a ^= num;
        else                      b ^= num;
    }
    return a < b ? new int[]{a, b} : new int[]{b, a};
}
```

Six fewer lines, no mutation of the XOR result, no shift loop.

## Lurking bug (hidden by constraints, again)
`while (xor > 0 && ...)` — same family of bug as your Count Set Bits solution.<br>
Constraints say `A[i] <= 10^9 < 2^30`, so the XOR can't set the sign bit and you're safe *here*.<br>
But if A[i] could reach `INT_MAX`, the XOR result could be negative and the loop would exit immediately with `i = 0`, partitioning incorrectly.<br>
**Pattern to internalize:** when looping over bits, default to `!= 0` and `>>>` (unsigned shift), not `> 0` and `>>`.<br>
The `n & -n` rewrite sidesteps this entirely — another reason to prefer it.

## What to articulate in the interview
The three insights, in order — say each one out loud:
1. *"XOR-ing the whole array gives me `a ^ b`, since pairs cancel."*
2. *"`a ^ b` has a 1 in every bit position where `a` and `b` differ — so any set bit in the XOR partitions the array into two groups, one containing `a`, the other containing `b`."*
3. *"Within each group, all duplicates still appear twice (since duplicates share the same bit value), so XOR-ing each group recovers the singleton."*

That third point is the non-obvious one and the part interviewers are listening for.<br>
*"Why does partitioning preserve the pairing of duplicates?"* — because two equal numbers have identical bits, so they fall into the same group together. Stating this explicitly is the difference between "I memorized this" and "I understand this."

## The follow-up to be ready for
*"What if three elements appeared once and the rest appeared twice?"*<br>
XOR no longer cleanly partitions — `a ^ b ^ c` doesn't tell you a single bit that isolates one element.<br>
Now the answer drifts toward HashSet (O(n) space) or a more elaborate bit-counting argument. The interviewer is testing whether you understand the **boundary** of the XOR-partition technique: it works for exactly 2 singletons because 1 differentiating bit yields a clean 2-way split.

## Meta-feedback
- You're now 3-for-3 on bit problems with a recurring micro-bug: `> 0` vs `!= 0` on signed ints.<br>This is one of those things that, once internalized, you never get wrong again. Make a mental note: **bit loops use `!= 0`**, full stop.
- Pattern recognition is improving — you reached for XOR-partition without prompting, which is exactly the leap the previous review was setting up. Keep building this muscle: every problem you solve should be tagged in your head with *"this is a member of the X family,"* so when a new problem hits you can ask *"which family?"* before *"how do I solve it?"*

## Action item
Solve **Single Number II** (every element appears 3× except one) — try the two-variable state-machine version first, fall back to bit-counting if you stall.<br>
Then try **Find the Duplicate Number** (Floyd's tortoise-and-hare framing) — different family entirely (cycle detection on an implicit graph), but it's a Google favorite and worth the context-switch practice.