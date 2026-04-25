# Java Access Modifiers — The Two Gate Model

## The Two Gates

To access anything in Java, you pass through **two gates in sequence**.
Both must be open. A public member behind a closed class is still unreachable.

```
Gate 1: Can you see the CLASS?
            ↓ only if yes
Gate 2: Can you see the MEMBER?
```

---

## Gate 1 — On the Class

Top-level classes only get two choices:

| Modifier    | Visible From        |
|-------------|---------------------|
| `public`    | Anywhere            |
| *(default)* | Same package only   |

> `protected` and `private` are **illegal** on top-level classes (reasons below).

---

## Gate 2 — On the Member

| Modifier    | Same Class | Same Package | Subclass (diff pkg) | World |
|-------------|------------|--------------|---------------------|-------|
| `public`    | ✅          | ✅            | ✅                   | ✅     |
| `protected` | ✅          | ✅            | ✅                   | ❌     |
| *(default)* | ✅          | ✅            | ❌                   | ❌     |
| `private`   | ✅          | ❌            | ❌                   | ❌     |

---

## The Classic Bug

```java
// package_a
public class Parent {
    Parent() {}  // default — package-private!
}

// package_b
public class Child extends Parent {
    // Java implicitly calls super() here → BOOM
    // Gate 1: OPEN (Parent is public)
    // Gate 2: CLOSED (constructor is default, Child is in package_b)
}
```

**Fix:** Mark constructors and members meant for subclasses as `protected` or `public`.

> Inheritance is an IS-A relationship. It does NOT bypass access rules.

---

## Why `protected` is Illegal on Top-Level Classes

The restriction scale: `private < default < protected < public`

So why is the *more restrictive* `default` allowed, but `protected` isn't?

Because `protected` on a member gives one **extra bonus** over `default`:
> *Subclasses in other packages can access this.*

For that bonus to work on a **class**, you'd need to subclass it first.
But to subclass it, you must first see it. **Paradox:**

```
See the class → requires being a subclass
Be a subclass → requires seeing the class
```

The subclass bonus can never activate. `protected` would behave
identically to `default` — so Java bans it as meaningless.

| Modifier    | Legal on Top-Level Class? | Reason                              |
|-------------|---------------------------|-------------------------------------|
| `public`    | ✅                         | Clear meaning                       |
| *(default)* | ✅                         | Clear meaning                       |
| `protected` | ❌                         | Subclass bonus creates a paradox    |
| `private`   | ❌                         | Nothing outside the file could use it |