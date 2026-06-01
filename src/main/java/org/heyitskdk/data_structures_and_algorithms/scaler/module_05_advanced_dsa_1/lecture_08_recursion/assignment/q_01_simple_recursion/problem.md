# Simple Recursion

What will be the output of the following program?

```java
public class solve {

    static int bar(int x, int y) {
        if (y == 0) return 0;
        return (x + bar(x, y - 1));
    }

    static int foo(int x, int y) {
        if (y == 0) return 1;
        return bar(x, foo(x, y - 1));
    }

    public static void main(String[] args) {
        System.out.println(foo(3, 5));
    }
}
```

### Answer : 243

---

### Time and Space Complexity
- The function `bar(x, y)` does repeated addition calling itself `y` times, resulting in `x * y`
- Hence, T.C. for `bar` is `O(N)` and S.C. is `O(N)` 


- The function `foo(x, y)` works like this -
```markdown
foo(x, 0) = 1
foo(x, 1) = bar(x, 1) = x
foo(x, 2) = bar(x, x) = x^2
foo(x, 3) = bar(x, x^2) = x^3
foo(x, y) = x^y
```
- The calls look like 
```markdown
bar(x, 1)
bar(x, x)
bar(x, x²)
bar(x, x³)
...
bar(x, x^(y-1))
```

- So total work is 
```markdown
1 + x + x² + x³ + ... + x^(y-1) &rarr; Geometric Progression
```

- Hence, the `T.C` is `O(x^y)`
- The largest recursive stack comes from the biggest bar call: `bar(x, x^(y-1))` which can grow up to `S.C.(x^(y-1))`
- Hence the `S.C.` is `O(x^y)`