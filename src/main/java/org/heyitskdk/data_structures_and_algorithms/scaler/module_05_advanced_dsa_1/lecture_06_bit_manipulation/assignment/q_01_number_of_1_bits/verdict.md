# Count Set Bits — Review

**Verdict: 7/10.** Correct, O(32) time, O(1) space. Baseline answer, not the strong one.

## What's good
- Not mutating input is a good habit (though Java passes `int` by value, so it's defensively unnecessary *here* — matters for objects/arrays).
- Clean bit-test-and-shift execution.

## Upgrade: Brian Kernighan's trick
Your loop runs once **per bit position** (~30 iterations always). Better: once **per set bit**.

```java
public int numSetBits(int A) {
    int count = 0;
    while (A != 0) {
        A &= (A - 1);   // clears the lowest set bit
        count++;
    }
    return count;
}
```

**Why it works:** `A - 1` flips the lowest set bit to 0 and turns all zeros below it into 1s. ANDing wipes out that lowest bit, leaving every other set bit untouched. Each iteration kills exactly one 1.

Example: `12 = 1100`, `11 = 1011`, `12 & 11 = 1000`.

Same speed for dense numbers; dramatically faster for sparse ones. The idiom `n & (n-1)` reappears in: power-of-two check (`n > 0 && (n & (n-1)) == 0`), subset enumeration, Gray code.

## Lurking bug (hidden by constraints)
`while (num > 0)` fails on negative integers. Java's `>>` is *arithmetic* right shift — preserves sign bit, so a negative number stays negative and the loop returns 0.

Fix:
```java
while (num != 0) { ... num >>>= 1; }   // logical right shift
```

`>>>` is Java-specific and a classic interview gotcha. Brian Kernighan's version sidesteps this — `n & (n-1)` works correctly in two's complement.

## Know the landscape
Production: `Integer.bitCount(A)`. JVM intrinsifies to hardware `POPCNT` or a SWAR bit-twiddle. Interview move: *"I'd use `Integer.bitCount` in production; here's the manual version,"* then write Kernighan's.

## Meta-feedback
- **State the complexity ladder before coding:** O(bit-width) → O(set-bit-count) → O(1) word-level. Walking up the rungs out loud shows how you think about optimization.
- **Build a bit-idiom library** — small, finite, recurring:
    - `n & (n-1)` — clear lowest set bit
    - `n & -n` — isolate lowest set bit
    - `n | (n-1)` — set all bits below highest
    - `n ^ (n >> 1)` — binary → Gray code
    - `(n & (n-1)) == 0` — power-of-two check

## Action items
Solve **Reverse Bits** and **Single Number II** (every element appears 3× except one). Send the harder one.