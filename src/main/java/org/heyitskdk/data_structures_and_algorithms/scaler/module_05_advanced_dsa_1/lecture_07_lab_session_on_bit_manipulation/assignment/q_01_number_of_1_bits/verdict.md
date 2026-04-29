# Number of 1 Bits — Review

## Submitted Solution
```java
public class Solution {
    public int numSetBits(int A) {
        int setBits = 0;
        for (int num = A; num > 0; num &= num - 1) setBits++;
        return setBits;
    }
}
```

## 1. Problem Understanding
Trivial problem, correctly understood. Nothing to discuss.

## 2. Correctness
Correct. Brian Kernighan's algorithm. Each iteration clears the lowest set bit; loop count = popcount.

## 3. Edge Cases
- Constraints say A ≥ 1, so no zero case to worry about — but in a real interview you should still say "A=0 returns 0, loop doesn't execute, handled."
- Negative numbers aren't in the constraint, but a staff candidate volunteers: "If A could be negative, `num > 0` would be wrong because of sign-extension; I'd switch to `num != 0`. The `n & (n-1)` trick works fine with `!= 0` since it operates on the bit pattern."
- You said none of this.

## 4. Complexity
- **Time:** O(k) where k = popcount, bounded by O(log A) = 30 for A ≤ 10⁹.
- **Space:** O(1).
- **You didn't state it.** Stop skipping this — it's free points and signals discipline.
- Strictly better than the naive `n & 1; n >>= 1` loop, which is always O(bitwidth) regardless of popcount. Worth saying out loud: "Kernighan's runs in O(popcount), not O(bitwidth) — meaningful when the number is sparse."

## 5. Optimal?
For a general-purpose answer, yes. "Optimal" has layers here, and a staff candidate enumerates them:

- **`Integer.bitCount(A)`** — JDK builtin, compiles to `POPCNT` on x86. One instruction. In a real codebase, this is the answer; mentioning it shows you know the language and the hardware.
- **SWAR / parallel bit-counting** (`0x55555555`, `0x33333333` masks) — O(1) with ~12 ops, no branches, no loop. Worth knowing exists; not worth writing unless asked.
- **Lookup table** (256-entry byte table, 4 lookups for a 32-bit int) — the classic before `POPCNT` existed.

Name all three in 15 seconds, pick Kernighan's because it's the cleanest to write and explain. Naming the alternatives is what separates senior from staff signal.

## 6. Code Quality
Clean. One-line for-loop is fine — the idiom is recognizable.

- Using `num = A` to avoid mutating the parameter — correct reflex.
- `num &= num - 1` inside the for-update is idiomatic but slightly cute. A `while` loop is more readable and harder to misread under pressure:
  ```java
  while (num != 0) { num &= num - 1; setBits++; }
  ```
  Stylistic, not a real critique.

## 7. Communication
Empty. You wrote code and stopped. For a problem this small, the *entire* signal is in what you say:

> "Brian Kernighan's: `n & (n-1)` clears the lowest set bit, so the loop runs exactly popcount times — O(popcount), better than the naive O(bitwidth) shift loop. In production I'd use `Integer.bitCount` which maps to the `POPCNT` instruction."

Three sentences. You said zero.

## 8. Better Approaches
Covered in §5. Key takeaway: **`Integer.bitCount` exists, and a strong candidate names it even when implementing the manual version.** Mentioning the builtin is not "cheating" — it shows engineering judgment. Then implement Kernighan's because the interviewer wants to see you can.

## 9. Pattern / Reusable Insight
**Bit manipulation idioms.** The `n & (n-1)` trick is the foundational one. Related kin to memorize as a bundle:

- `n & -n` → isolates the lowest set bit
- `n & (n-1) == 0` → power-of-2 check
- `n | (n-1)` → fills trailing zeros with 1s
- `n ^ (n-1)` → mask of lowest set bit + trailing zeros

Appear constantly: power-of-2 checks, Fenwick trees, subset enumeration, gray code.

## 10. Likely Interviewer Pushback
- **"Can you do it without a loop?"** → SWAR or builtin.
- **"What if A is a `long`?"** → same algorithm, loop bound becomes 64.
- **"What if A can be negative?"** → two's complement; `n & (n-1)` still works with `!= 0` because Java ints are 32-bit two's complement and the bit pattern is what matters.
- **"How does `POPCNT` work in hardware?"** → unlikely but possible at Google/Rubrik infra loops. "Dedicated instruction, ~1 cycle on modern x86, used heavily in cryptography and bitmap indexes" is enough.

---

## Verdict
- **Interview verdict:** Pass (Senior). Borderline (Staff) — only because you said nothing.
- **Score:** 7/10 for the code. 4/10 for the interview performance around it.

## Top 3 Weaknesses
1. **Still not narrating.** Same weakness as the previous problem. Correct code in silence. At staff level, silence on a 5-line problem is worse than silence on a hard one — it means you can't articulate trivial things, which makes interviewers doubt you can articulate hard ones.
2. **Didn't name `Integer.bitCount`.** Knowing the language's standard library is table stakes for senior+. Not naming it suggests either you don't know it exists or you don't think to mention builtins.
3. **No alternatives surfaced.** SWAR, lookup table, builtin — none mentioned. For a textbook problem, the discriminator between candidates is breadth of awareness, not the chosen solution.

## Most Important Correction
Treat every problem, no matter how small, as having three deliverables: **the algorithm, the complexity, the alternatives.** You're delivering 1 of 3.

## What to Practice Next
Build a 60-second verbal template and run it on every problem until it's automatic:
1. Restate the problem in one sentence.
2. State the approach + why.
3. State complexity (time + space).
4. Name 1–2 alternatives and why you rejected them.
5. Then code.

Run this on the next 5 trivial problems (reverse bits, single number, missing number, power of two, hamming distance) before moving on. The goal isn't the problems — it's making narration reflexive so it doesn't disappear when the problem gets hard.

---

## Recurring Weaknesses (Across Submissions)
1. **No spoken complexity analysis.** (2/2 problems)
2. **No alternatives surfaced.** (2/2 problems)
3. **Insight/approach not verbalized before coding.** (2/2 problems)