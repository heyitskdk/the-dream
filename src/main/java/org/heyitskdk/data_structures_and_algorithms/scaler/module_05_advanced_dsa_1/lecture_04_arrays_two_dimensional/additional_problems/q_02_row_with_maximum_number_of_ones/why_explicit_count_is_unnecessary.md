# Why Explicit `count` Is Unnecessary in “Row with Maximum Number of 1s”

## Core Idea
In a **sorted binary row**, the number of `1`s is completely determined by the **leftmost `1`**.

If the first `1` in a row is at column `j`, then:

```text
number of 1s = m - j
```

So while traversing from the **top-right** corner, the column pointer `j` already tells us how good the best row found so far is.

- moving **left** means: found a row with **more 1s**
- moving **down** means: current row cannot beat the best found so far

Because of this, we do **not** need a separate `count`.

## Why `count` Is Misleading
In staircase traversal, every left move may happen in a **different row**.

So this:

```java
count++;
```

does **not** mean:

- “current row has one more 1”

It actually means:

- “during the whole traversal, I moved left one more time”

That is a **global traversal count**, not a valid per-row measure.

## What Actually Tracks the Answer
The current column `j` is enough.

- smaller `j` => leftmost `1` is farther left
- farther left => row has more `1`s

So `j` already encodes the maximum count indirectly.

## Tie-Breaking
If two rows have the same number of `1`s, return the smaller index.

This is handled automatically because we scan **top to bottom**:

- the first row that reaches a given best `j` is the smaller index
- later rows with the same number of `1`s won’t move further left
- so we do not need extra tie logic

## Your Version (with explicit count)

```java
public class Solution {
    public int solve(int[][] A) {
        // approach - staircase navigation, carry fwd count of max ones
        int n = A.length, m = A[0].length;

        // top-right corner
        int i = 0, j = m - 1;
        int count = 0, maxCount = 0;
        int row = -1;
        while (i < n && j >= 0) {
            int num = A[i][j];
            if (num == 1) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                    row = i;
                }
                j--;
            } else {
                i++;
            }
        }

        return row;
    }
}
```

### Problem with this version
- `count` is accumulated across the **entire traversal**
- it is **not** the count of `1`s in the current row
- it also returns `-1` for an all-zero matrix, but the correct answer should be `0`

## Optimized Correct Version

```java
public class Solution {
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int i = 0;
        int j = m - 1;
        int answer = 0;

        while (i < n && j >= 0) {
            if (A[i][j] == 1) {
                answer = i;
                j--;
            } else {
                i++;
            }
        }

        return answer;
    }
}
```

## Final Summary
Explicit `count` is unnecessary because:

1. each row is sorted
2. number of `1`s depends only on the **leftmost `1`**
3. the column pointer `j` already tracks that
4. staircase traversal naturally finds the best row in `O(n + m)` time and `O(1)` space
