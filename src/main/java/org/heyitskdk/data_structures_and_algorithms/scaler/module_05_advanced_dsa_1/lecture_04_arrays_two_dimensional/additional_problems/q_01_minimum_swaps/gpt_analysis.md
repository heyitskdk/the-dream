# Analysis

## Verdict
The solution is correct and optimal.

- **Time:** `O(n)`
- **Space:** `O(1)`

## Core idea
Let `k` be the count of elements `<= B`.

All such elements must end up inside some contiguous block of size `k`.  
So the problem reduces to finding a window of size `k` with the fewest elements `> B`.

That count equals the minimum swaps required.

## Important edge case
If `k == 0`, return `0` immediately.

Without this guard, the sliding-window logic runs with a zero-sized window and can behave incorrectly.

## Required fix
Add:

```java
if (window == 0) return 0;
```
