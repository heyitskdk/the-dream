# Single Number II — Approach Validation

## You're on the right track. Stop calling it "brut-ish."
- Outer loop: 32 (constant, bit-width).
- Inner loop: n (array size).
- Total: **O(n) time, O(1) space.** The 32 is a constant, not a growth factor.
- This **fully satisfies** the problem's stated constraints (linear time, no extra memory).
- Distinguishing "aesthetically uglier" from "asymptotically worse" is part of the calibration interviewers test.

## Sharpen the invariant before coding
For any bit position `b`:
- Total count of 1s across the array = `C_b`.
- Each triplicated element contributes 0 or 3 to `C_b`.
- The singleton contributes 0 or 1.
- Therefore: **`C_b mod 3` = bit `b` of the answer.**

**Generalization:** if elements appeared `k` times except one, the answer's bit `b` is `C_b mod k`. This is the *strength* of the bit-counting approach — it's a family solution, not a one-off. State this aloud.

## Sign-bit hazard (familiar territory)
- `0 <= A[i] <= INT_MAX` → values fit in 31 bits, sign bit never set.
- Looping `b` from 0..31 is fine; from 0..30 is fine.
- Inputs are non-negative, so `>>` on `num` is safe — but **state the assumption** rather than rely silently.
- If you ever shift the *result* you're building, default to `>>>`.

## Don't optimize further yet
1. **Code the bit-counting version first.** Working + meets-stated-complexity beats half-finished + elegant.
2. There exists a 2-variable FSM solution that avoids the 32× factor. It's harder to derive, harder to explain, and **doesn't generalize** to k-times. Learn it as a second tool, not a first answer.

## Loop-order nudge
Outer loop = bits vs. outer loop = array — algorithmically equivalent. One has slightly better cache behavior. Worth thinking about; either is acceptable here.

## Action
Write it. State the invariant as you write each line. Hand it back. Then we'll discuss the FSM.