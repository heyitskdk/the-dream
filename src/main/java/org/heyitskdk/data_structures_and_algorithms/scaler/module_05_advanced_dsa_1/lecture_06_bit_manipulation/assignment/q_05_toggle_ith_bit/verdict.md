# Toggle i-th Bit — Review

**Verdict: 10/10.** Perfect.<br>
One line, the right operation, no ceremony. Nothing to add, nothing to remove.

## Why this is the right answer
XOR is *the* toggle operation by definition: `x ^ 1 = ~x`, `x ^ 0 = x`.<br>
So XOR-ing position B with a 1 flips that bit, and XOR-ing every other position with 0 leaves it untouched.<br>
The behavior matches the problem's intent **exactly**, with no branching, no conditional, no second-guessing.

## What I like compared to the previous problem
You internalized the meta-feedback from the last review immediately — *match the operation to the intent*.<br>
Last problem you reached for XOR-with-conditional when AND-with-mask was natural. This problem you reached for XOR cleanly because XOR *is* "flip." That's the muscle being built: read the problem's verb, pick the operator whose semantics match.

## Sanity-check the primitive table
You've now used three of the four bit primitives in three problems. Lock the table in:

| Operation | Expression |
|---|---|
| Set bit B | `A \| (1 << B)` |
| Clear bit B | `A & ~(1 << B)` |
| **Toggle bit B** | **`A ^ (1 << B)`** ← this problem |
| Test bit B | `(A >> B) & 1` |

If "Set i-th bit" comes next, you should be writing `A | (1 << B)` in five seconds without thinking. That's the bar.

## Meta-feedback
- Nothing on the code. The note is on **pace**: when a problem is genuinely a one-liner from the primitive table, don't linger. In an interview, write the line, briefly state *why* the operator matches the intent ("XOR with 1 flips, XOR with 0 preserves — so `A ^ (1 << B)` flips exactly position B"), and move on. Confidence + brevity on trivial problems leaves room for harder follow-ups.
- These three bit-fiddling problems in a row are scaffolding. The real test is the next tier: **Number of 1 Bits in range [A, B]**, **Min XOR value between any pair**, **Maximum XOR pair using a Trie**. Those are where bit manipulation stops being mechanical and starts being algorithmic. Ready when you are.

## Action item
Send the next problem. If you're picking, jump to **Min XOR Value** — pair of elements in an array with minimum XOR. There's a non-obvious sort-based insight that's a fun "aha."