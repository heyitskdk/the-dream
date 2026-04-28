# Trapping Rain Water — Review

**Verdict: 7.5/10.** Correct, O(n) time, O(n) space, clean code.<br>
You nailed the core insight: water above index `i` = `min(leftMax, rightMax) - A[i]`, clamped at 0.<br>
That's the hard part.

## What's good
- **One-sided optimization:** rolling scalar for `leftMax` + suffix array for `rightMax`.<br>Skips a pass and halves auxiliary storage vs. the textbook two-array version. Good instinct.
- **`long` accumulator:** with |A| ≤ 10⁵ and A[i] ≤ 10⁵, max trapped water is 10¹⁰ — overflows `int`.<br>Quietly defensive. **Call this out verbally in interviews — free points.**
- Helper name `buildMaxHeightAtRightSuffixArray` is descriptive but verbose; `rightMax` / `suffixMax` is idiomatic.

## Upgrade to 9: two-pointer, O(1) space
Expected follow-up: *"Can you do it without the extra array?"*<br>
Hit it on the first try and you separate yourself.

```java
public int trap(final int[] A) {
    int l = 0, r = A.length - 1;
    int leftMax = 0, rightMax = 0;
    long water = 0;

    while (l < r) {
        if (A[l] < A[r]) {
            if (A[l] >= leftMax) leftMax = A[l];
            else water += leftMax - A[l];
            l++;
        } else {
            if (A[r] >= rightMax) rightMax = A[r];
            else water += rightMax - A[r];
            r--;
        }
    }
    return (int) water;
}
```

**Invariant to articulate:** you don't need the *exact* `rightMax` at position `l` — only that it's ≥ the side you're ignoring.<br>
The check `A[l] < A[r]` guarantees that.<br>
*"I don't need the exact value, just a safe bound"* is the reasoning that distinguishes strong candidates.

## Third approach to know: monotonic stack
Right tool when the problem shifts to streaming or generalizes (Largest Rectangle in Histogram, Next Greater Element).

```java
public int trap(int[] A) {
    Deque<Integer> stack = new ArrayDeque<>();
    int water = 0;
    for (int i = 0; i < A.length; i++) {
        while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
            int bottom = stack.pop();
            if (stack.isEmpty()) break;
            int left = stack.peek();
            int width = i - left - 1;
            int boundedHeight = Math.min(A[i], A[left]) - A[bottom];
            water += width * boundedHeight;
        }
        stack.push(i);
    }
    return water;
}
```

**Mental model shift:** your approach (and two-pointer) count water **column-by-column vertically**.<br>
Stack counts **layer-by-layer horizontally** — one trapped basin at a time.<br>
Same answer, different decomposition — and the decomposition matters because it generalizes.

## Minor
- `if (n < 3) return 0;` is dead weight — main loop handles n ≤ 2 correctly.<br>At this bar, every line should earn its keep.

## Meta-feedback
- **State the invariant + complexity target before coding.**<br>Your comment captured the invariant; saying *"the question is whether I can compute `min(lmax, rmax)` without storing both arrays"* immediately points at two-pointer.
- Three canonical approaches for this problem — know all three and when each wins:
    - **Prefix/suffix arrays** — O(n) / O(n), clearest to explain
    - **Two pointers** — O(n) / O(1), the expected optimal
    - **Monotonic stack** — O(n) / O(n), generalizes to a family of problems

## Action item
Re-solve tomorrow from scratch using two pointers, no peeking.<br>
Explain the invariant aloud as if to an interviewer.<br>
When that's fluent, it's internalized.