# Single Number II — Review

**Verdict: 8.5/10.** Correct, O(32n) = O(n) time, O(1) space, meets every constraint.<br>
Clean, readable, top-to-bottom. Gap to 9.5 is one bug-class awareness and one structural improvement.

## What's good
- You translated the invariant directly into code — outer loop over bits, inner counts 1s, mod 3 detects the singleton's contribution. **The code reads like the proof.**
- Extracting `numberOfOneBits` as a helper makes the main loop almost English-readable. Good instinct.
- `answer |= (1 << i)` — right primitive, locked into muscle memory.

## Bug-class to flag (not a bug here)
- `% 3 == 1` is correct because inputs are non-negative; counts can only land on 0 or 1 mod 3 for valid input.
- `% 3 == 2` is impossible here — but in the FSM version, the `2` state is real and tracked.
- `% 3 != 0` is equivalent to `% 3 == 1` *in this problem*. Worth knowing why.

## Structural improvement: invert the loops
Current: 32 array traversals (32 × n memory reads, cache-cold after pass 1).<br>
Inverted: 1 array traversal, 32 register-level ops per element.

```java
public int singleNumber(final int[] A) {
    int[] bitCount = new int[32];
    for (int num : A) {
        for (int b = 0; b < 32; b++) {
            bitCount[b] += (num >> b) & 1;
        }
    }
    int answer = 0;
    for (int b = 0; b < 32; b++) {
        if (bitCount[b] % 3 != 0) answer |= (1 << b);
    }
    return answer;
}
```

Trade-off:
- **Your version:** 0 aux space, 32 passes.
- **Inverted:** 32 ints aux (still O(1)), 1 pass.

**Mention both, let the interviewer pick.** *"Outer-by-bit for zero aux memory; flip to outer-by-element if cache locality matters more."* That's the trade-off articulation that separates a 7 from a 9.

## Micro-optimization (Java: noise; systems interview: signal)
Lift `1 << i` out of the inner loop:
```java
int mask = 1 << i;
for (int j = 0; j < A.length; j++) {
    if ((A[j] & mask) != 0) oneBits++;
}
```
JIT will hoist this in Java. In C++/Rust, you'd lift it manually. Know it exists; deploy when relevant.

## What to say at the whiteboard
1. **Invariant:** *"At each bit position, count of 1s mod 3 equals the answer's bit. Triplicates contribute 0; singleton contributes 0 or 1."*
2. **Implementation choice:** *"Outer-by-bit gives O(1) aux. Inverted gives one pass with 32 ints aux — happy to flip."*
3. **Generalization:** *"Works for any k-times-except-one by changing `% 3` to `% k`."*

That third point is huge — volunteering generalization unprompted is a strong signal.

## The elegant alternative: 2-variable FSM
```java
public int singleNumber(final int[] A) {
    int ones = 0, twos = 0;
    for (int num : A) {
        ones = (ones ^ num) & ~twos;
        twos = (twos ^ num) & ~ones;
    }
    return ones;
}
```

**Intuition:** Per bit, track count mod 3 ∈ {0, 1, 2} using 2 bits encoded as `(twos[b], ones[b])` ∈ {00, 01, 10}. Across all 32 positions, `ones` and `twos` are parallel integers holding these encodings.

Transitions per bit on input `x`:

| (twos, ones) | x=0 | x=1 |
|---|---|---|
| 00 (count 0) | 00 | 01 |
| 01 (count 1) | 01 | 10 |
| 10 (count 2) | 10 | 00 |

Triplicates cycle `00 → 01 → 10 → 00` (contribute nothing). Singleton bumps `00 → 01` once, so `ones` = answer, `twos` = 0.

**Why it's harder to use under pressure:**
- Hard to derive cold.
- Doesn't generalize — k=4, 5, 7 each need a different FSM.
- Order-sensitive: `ones` must update before `twos` (second line uses new `ones`).
- Verifying correctness requires tracing the truth table.

**Why it's worth knowing:**
- "FSM over bits" pattern generalizes (with different FSMs) to other appears-k problems.
- Strictly O(1) memory, single pass.
- Interviewer-flex if delivered cleanly.

**Recommendation:** lead with bit-counting; mention FSM as follow-up if asked.<br>
Bit-counting = candidate who understands. FSM = candidate who memorized. Interviewers tell the difference; the former wins.

## Action item
Try **Min XOR Value** — pair in array with minimum XOR, sort + adjacent pairs is the "aha." Different family entirely, refreshes pattern-matching.