## The bit-manipulation primitive table
This problem is a member of a very small family. Memorize all four — they come up constantly:

| Operation        | Expression                              | Why                                          |
|------------------|-----------------------------------------|----------------------------------------------|
| **Set** bit B    | `A \| (1 << B)`                         | OR with 1 forces to 1, OR with 0 preserves   |
| **Clear** bit B  | `A & ~(1 << B)`                         | AND with 0 forces to 0, AND with 1 preserves |
| **Toggle** bit B | `A ^ (1 << B)`                          | XOR with 1 flips, XOR with 0 preserves       |
| **Test** bit B   | `(A >> B) & 1` or `(A & (1 << B)) != 0` | Isolate the bit                              |

These four cover ~90% of bit-manipulation interview questions when combined with the two idioms (`n & (n-1)` and `n & -n`)

- `n & (n-1)` - Brian Kernighan's algorithm to count set bits <br>
- `n & -n` - Create a mask with `1` present only at the first set bit of `n` from left, rest all are `0's`