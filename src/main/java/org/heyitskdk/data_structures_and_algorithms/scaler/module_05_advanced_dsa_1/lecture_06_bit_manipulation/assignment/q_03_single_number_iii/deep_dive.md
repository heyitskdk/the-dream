# Bit Manipulation Deep Dive: `n & (n-1)` vs `n & -n`

Totally fair — this is one of those things that feels like *magic* until you see it once, then becomes *obvious* forever.<br>
Let me break it down properly.<br>
We're actually talking about **two different idioms**, and I think mixing them is part of what spun your head. Let's separate them.

## The two idioms, side by side

| Expression | What it does | Used for |
|---|---|---|
| `n & (n - 1)` | **Clears** the lowest set bit | Counting set bits (Kernighan) |
| `n & -n` | **Isolates** the lowest set bit (everything else becomes 0) | Getting a mask of just that bit |

They look similar, but one *removes* the bit and the other *extracts* it.<br>
Different jobs. Let's understand each.

---

## Idiom 1: `n & (n - 1)` clears the lowest set bit

Take `n = 12`, which is `1100` in binary.

```
n     = 1100   (12)
n - 1 = 1011   (11)
```

What happened when we subtracted 1? Walk through it like grade-school subtraction.<br>
You start at the rightmost bit. It's 0, so you can't subtract 1 from it — you have to **borrow** from the next bit.<br>
That bit is also 0, borrow again. Next is also 0, borrow again.<br>
Finally you hit a 1 — that's the **lowest set bit**.<br>
You take from it (it becomes 0), and all the bits you borrowed *through* turn into 1s.

So the rule is:

> Subtracting 1 **flips the lowest set bit to 0**, and **flips every bit below it from 0 to 1**.

Now AND them:

```
n       = 1100
n - 1   = 1011
n & n-1 = 1000
```

The lowest set bit position: `n` has 1, `n-1` has 0 → AND gives 0. ✅ *Bit cleared.*<br>
Bits below it: `n` has 0, `n-1` has 1 → AND gives 0. ✅ *Stay 0.*<br>
Bits above it: `n` and `n-1` are identical (subtraction never reached up there) → AND preserves them. ✅ *Untouched.*

**Net effect:** lowest set bit is wiped, everything else is preserved.<br>
Run this in a loop and you peel off one set bit per iteration → that's Kernighan's algorithm.

---

## Idiom 2: `n & -n` isolates the lowest set bit

This is the one we used for `diffBit`. Same number, `n = 12 = 1100`.

To understand `-n`, you need to know how negative numbers work in two's complement. The rule is:

> `-n` = flip all the bits of `n`, then add 1.

Let's compute it (using 8 bits for clarity):

```
n       = 0000 1100   (12)
~n      = 1111 0011   (flip every bit)
~n + 1  = 1111 0100   (add 1)
so -n   = 1111 0100
```

Now AND:

```
 n     = 0000 1100
-n     = 1111 0100
n & -n = 0000 0100
```

**Only the lowest set bit survives.** Everything else became 0. Why?

Here's the key intuition.<br>
When you do `~n + 1`, the `+1` has to propagate through trailing zeros (just like the borrow did before, but in reverse).<br>
It propagates until it hits a 0 in `~n` — which is exactly where `n` had its lowest 1.<br>
Let me show this carefully, splitting `n` into three regions:

```
n       =  [ upper bits ] [ lowest 1 ] [ trailing 0s ]

~n      =  [ flipped    ] [    0    ] [    1s        ]

~n + 1  =  [ flipped    ] [    1    ] [    0s        ]    ← the +1 ripples through
                                                            the 1s, turns them to 0,
                                                            and lands on the 0,
                                                            flipping it back to 1.
```

So in `-n`:
- The trailing zeros of `n` are still 0s.
- The lowest set bit position is **1** (matching `n`).
- Every bit above it is **flipped** relative to `n`.

When you AND `n & -n`:
- Trailing zeros: 0 AND 0 = 0.
- Lowest set bit: 1 AND 1 = **1** ✅ *survives*.
- Upper bits: `n` is some pattern, `-n` is its inverse → AND is always 0. *Wiped.*

**Net effect:** a mask with exactly one bit set — the lowest set bit of `n`.

---

## So why does `(num & diffBit) == 0` partition the array correctly?

Now we can answer your real question.<br>
In Single Number III, after XORing everything we got `xor = a ^ b`.<br>
This XOR has a 1 in every bit position where `a` and `b` *differ*.<br>
We want to pick **any one** of those differing positions and split the array by it.

`diffBit = xor & -xor` gives us a mask with a single 1, located at the lowest position where `a` and `b` differ.<br>
Then for each `num`:

```java
(num & diffBit) == 0
```

This expression asks: *"Is `num`'s bit at the diffBit position a 0 or a 1?"*<br>
The mask zeros out all other bits, leaving only that one bit's value.<br>
If it's 0, the result is 0; if it's 1, the result is non-zero.

Two numbers fall into the same group iff they have the same value at that bit.<br>
Since `a` and `b` differ at that bit (by construction), they end up in **different groups**.<br>
And since duplicates have *identical* bits everywhere, every duplicate pair ends up in the *same* group, where they cancel via XOR.<br>
The lone singleton in each group survives.

That's the entire trick.

---

## A concrete walkthrough

Take `A = [1, 2, 3, 1, 2, 4]`. Singletons are 3 and 4.

```
xor = 1^2^3^1^2^4 = 3^4 = 011 ^ 100 = 111   (7)
```

The XOR is `111`, meaning 3 and 4 differ in *all three* of the lowest bits.<br>
We just need any one of them.

```
-7      = ...11111001   (in two's complement)
7 & -7  = 001            ← lowest set bit isolated
```

So `diffBit = 1` (the rightmost bit). Now partition:

```
1 = 001 → bit 0 is 1 → groupB
2 = 010 → bit 0 is 0 → groupA
3 = 011 → bit 0 is 1 → groupB
1 = 001 → bit 0 is 1 → groupB
2 = 010 → bit 0 is 0 → groupA
4 = 100 → bit 0 is 0 → groupA

groupA: 2 ^ 2 ^ 4 = 4 ✅
groupB: 1 ^ 3 ^ 1 = 3 ✅
```

The duplicates `1` and `1` both went to groupB (same bit pattern, so same group).<br>
The duplicates `2` and `2` both went to groupA.<br>
And `3` and `4` were forced into different groups *because* they differ at bit 0 — which is exactly the bit we picked.

---

## The one-line summary to lock this in

> `n & (n-1)` **deletes** the lowest set bit. `n & -n` **extracts** the lowest set bit. The `+1` in two's complement is what makes both work — in one case via borrow propagation, in the other via carry propagation.

If you remember just that, you can re-derive both any time.