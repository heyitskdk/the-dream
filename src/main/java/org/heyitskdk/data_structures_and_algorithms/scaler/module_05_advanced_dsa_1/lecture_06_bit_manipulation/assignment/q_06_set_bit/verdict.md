# Set A-th and B-th Bits in 0 — Review

**Verdict: 9/10.** Correct, clean, two ORs and you're done.

The only thing standing between this and a 10 is recognizing it's literally one expression.

## What's good
- You used **OR** — the right primitive for "set a bit." Matches the operation-to-intent mapping from the previous review. ✅
- Starting from `0` and OR-ing in the bits you want is exactly the right mental model: *build up the result by adding bits*, rather than starting from something and clearing/toggling.
- Variable name `answer` is fine; some would prefer `result`, doesn't matter.

## The one-liner
```java
return (1 << A) | (1 << B);
```

Two operations, one expression, no intermediate state.

The `answer = 0` initialization and two compound assignments are scaffolding the optimizer will erase anyway, but **at the elite bar, expressing the result as a single expression signals you see the structure clearly**, not as a sequence of mutations.

This isn't pedantic shortening for its own sake — it's a habit.

Code that mutates an accumulator across multiple statements *should* exist when the accumulation is genuinely iterative (a loop, a reduction).

When it's just two terms, fold them into one expression. Reserve mutation for when it's earning its keep.

## The Example 2 edge case worth noticing
When `A == B == 4`, the expected output is `16`, not `32`. Your code handles this correctly — let's understand why.

`(1 << 4) | (1 << 4)` = `10000 | 10000` = `10000` = 16.

OR is **idempotent**: `x | x = x`. Setting an already-set bit is a no-op.

This is why OR is the right operation for "set" rather than, say, addition: `(1 << 4) + (1 << 4) = 32` would be wrong.

The problem's Example 2 is *specifically chosen* to test whether you reached for OR (correct) vs. addition (a common bug).

**Internalize this:** when a problem says "set these bits," and the bits might overlap, OR is the only primitive that handles overlap cleanly.

Addition silently gives wrong answers; XOR cancels them (also wrong).

Recognizing *why* OR is uniquely right here is the kind of articulation interviewers listen for.

## What to say out loud in the interview
*"Bit-setting is OR. Starting from 0, I OR in `1 << A` and `1 << B`. OR is idempotent, so this is correct even when A == B."*

That last clause — *especially when A == B* — is the free signal. It shows you considered the duplicate case without prompting.

## Meta-feedback
- You're building good momentum on bit primitives. Three out of four locked in (toggle, set, clear).
  The last one — **test bit** — will appear as a sub-step in almost every harder bit problem, so make sure `(A >> B) & 1` and `(A & (1 << B)) != 0` are both reflexive.
- Notice the trajectory of these problems: each one isolates one primitive in pure form, with no algorithmic structure around it.
  That's deliberate scaffolding. The next tier — counting set bits in a range, finding pairs with min/max XOR, single-number variants — is where you'll *combine* primitives with loops, sorts, or tries. That's where the bit-manipulation skill actually starts paying off in interviews.
- One more thing: this problem statement has a typo (*"Set the A-th bit and B-th bit in 0"* — should be *"of 0"*).
  At Stripe/Google interviews, **problem statements are sometimes ambiguous on purpose, sometimes by accident**. Train yourself to verify your reading against the examples before coding.
  You did this implicitly — your code matches the examples — but make it explicit.
  Restate the problem in your own words before writing code: *"Build a number where bits A and B are set, all others 0."* That clarifying restatement is a Stripe-style interviewer's favorite signal.

## Action item
Time to leave the primitives-in-isolation tier.

Try **Number of 1 Bits between 1 and N** (sum of `popcount(i)` for `i` in `[1, N]`) — there's an O(log N) solution using a recurrence on bit positions that's a beautiful "aha" once you see it.

If that's too steep, warm up with **Min XOR Value** (find pair in array with minimum XOR; sort + adjacent pairs is the trick).