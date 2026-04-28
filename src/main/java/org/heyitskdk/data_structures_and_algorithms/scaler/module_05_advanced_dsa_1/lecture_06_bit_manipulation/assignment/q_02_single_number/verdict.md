# Single Number — Review

**Verdict: 9.5/10.** This is the answer.<br>
O(n) time, O(1) space, three lines of logic, no edge cases to handle.<br>
At the elite bar, this is exactly what's expected — no notes on the code itself.

## Why this is the right answer
XOR has three properties that conspire perfectly here:
- **`x ^ x = 0`** — any number XORed with itself cancels.
- **`x ^ 0 = x`** — zero is the identity.
- **Commutative + associative** — order of operations doesn't matter.

So XORing the entire array pairs up every duplicate (each pair → 0), and the lone element survives.<br>
The constraint *"every element appears twice except one"* is what makes this work — the moment that constraint changes, the technique changes.

## What to say out loud in the interview
Don't just write the code — narrate the *why*.<br>
A strong candidate says:<br>
*"XOR is its own inverse, so duplicates cancel regardless of position. I'm essentially computing the XOR-sum of the multiset, and every paired element contributes 0."*<br>
That one sentence shows you understand the algebraic structure, not just the trick.

## The follow-ups you must be ready for
This problem is almost never asked in isolation at Google/Stripe/Rubrik — it's the **warm-up**.<br>
Expect one of these immediately after:

### 1. Single Number II — every element appears 3× except one
XOR breaks because `x ^ x ^ x = x`, not 0.<br>
Two clean approaches:

**Bit-by-bit counting** — O(32n) time, O(1) space:
```java
public int singleNumber(int[] A) {
    int result = 0;
    for (int bit = 0; bit < 32; bit++) {
        int sum = 0;
        for (int num : A) sum += (num >> bit) & 1;
        result |= (sum % 3) << bit;
    }
    return result;
}
```
Each bit position has a count divisible by 3, plus the lone element's bit. Mod 3 recovers it.

**Two-variable state machine** — O(n) time, O(1) space, the elite answer:
```java
public int singleNumber(int[] A) {
    int ones = 0, twos = 0;
    for (int num : A) {
        ones = (ones ^ num) & ~twos;
        twos = (twos ^ num) & ~ones;
    }
    return ones;
}
```
`ones` tracks bits that have appeared `1 mod 3` times, `twos` tracks `2 mod 3`.<br>
Hard to derive cold; worth memorizing the *idea* (finite-state-machine over bits) even if you re-derive the masks.

### 2. Single Number III — exactly two elements appear once, rest twice
XOR everything → you get `a ^ b` where `a, b` are the two singletons.<br>
Pick any set bit in the result (use `x & -x` to isolate the lowest) — that bit differs between `a` and `b`.<br>
Partition the array by that bit, XOR each partition separately. Two answers fall out.<br>
**This is the problem where `n & -n` earns its keep.** Connect it back to the bit-idiom library from the last review.

### 3. "What if the constraint were addition instead of XOR?"
i.e. every element appears twice except one — but the array contains floats, or strings.<br>
XOR no longer applies. Now you'd reach for a HashSet (O(n) space) — and the interviewer is testing whether you understand that **XOR is a domain-specific trick**, not a universal one.

## Meta-feedback
- You wrote this in ~10 seconds — good. But in an interview, **don't rush to code if the problem is this easy**.<br>Spend 20 seconds verbalizing the XOR properties first. Free signal that you know *why* it works, not just *that* it works.
- The hint `0 <= A[i] <= INTMAX` is a tell — when constraints emphasize integer range and forbid extra memory, **bit manipulation is almost always the intended path**. Train yourself to read constraints as hints.
- Notice the pattern: this problem (XOR) and Count Set Bits (Kernighan) both reward knowing a small algebraic identity cold.<br>This is the **bit-manipulation family** — maybe 6-8 core problems total. Worth grinding as a set.

## Action item
Solve **Single Number II** and **Single Number III** back-to-back.<br>
For II, attempt the state-machine version — even if you don't get it, the *attempt* trains pattern recognition for FSM-over-bits, which reappears in problems like "find the duplicate in [1..n]" variants.<br>
Send me whichever you find harder.