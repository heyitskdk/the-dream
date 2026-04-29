## Deep Dive - Building the mask

### Goal
To unset the rightmost `B` bits of `A`, we need a mask of the form:

    ...11111000

That is:
- higher bits = `1` → preserve them
- lowest `B` bits = `0` → clear them

Then we do:

    A & mask

because:
- `x & 1 = x` → keeps the bit
- `x & 0 = 0` → clears the bit

---

### How the mask is built

#### Step 1: Create `B` ones on the right
    (1L << B) - 1

Why:
- `1L << B` gives a `1` followed by `B` zeros
- subtracting `1` turns that into `B` ones

Example for `B = 3`:
1L << 3      = 1000
(1L << 3)-1  = 0111

So this gives:
- `B = 3` → `000...0111`
- `B = 5` → `000...11111`

#### Step 2: Invert it
    ~((1L << B) - 1)

For `B = 3`:
000...0111  ->  111...1000

Now the lowest `B` bits are `0`, and all higher bits are `1`.

This is exactly the mask we need.

---

### Final expression
    A & ~((1L << B) - 1)

This clears the lowest `B` bits of `A`.

---

### Example
`A = 37`, `B = 3`

Binary:
A = 100101

Build mask:
1L << 3 = 001000
minus 1 = 000111
invert   = 111000

Apply AND:
100101
111000
------
100000

Result = `32`

---

### Why `1L` and not `1`
Use:
1L << B

Not:
1 << B

Reason:
- `1` is `int` in Java
- `1L` is `long`
- with `B` up to `60`, shifts must be done in 64-bit arithmetic

---

### Alternate equivalent solution
    (A >> B) << B

Why it works:
- right shift removes the lowest `B` bits
- left shift adds back `B` zero bits

This is often easier to reason about initially.

---

### Pattern to remember
- lowest `B` ones:  
  `(1L << B) - 1`
- clear lowest `B` bits:  
  `A & ~((1L << B) - 1)`
- keep only lowest `B` bits:  
  `A & ((1L << B) - 1)`