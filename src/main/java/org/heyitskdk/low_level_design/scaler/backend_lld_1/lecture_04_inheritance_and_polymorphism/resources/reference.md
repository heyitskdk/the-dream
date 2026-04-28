# Java Inheritance & Polymorphism — Quick Reference

---

## 1. The Two-Gate Model for Access

**Q: How do access modifiers behave on a class vs. on its members?**

To access anything, you pass through **two gates in sequence**. Both must be open.

```
Gate 1: Can you see the CLASS?
            ↓ only if yes
Gate 2: Can you see the MEMBER?
```

### Gate 1 — On the Class (top-level)

| Modifier    | Visible From      |
|-------------|-------------------|
| `public`    | Anywhere          |
| *(default)* | Same package only |

`protected` and `private` are illegal on top-level classes.

### Gate 2 — On the Member

| Modifier    | Same Class | Same Package | Subclass (diff pkg) | World |
|-------------|:----------:|:------------:|:-------------------:|:-----:|
| `public`    | ✅          | ✅            | ✅                   | ✅     |
| `protected` | ✅          | ✅            | ✅                   | ❌     |
| *(default)* | ✅          | ✅            | ❌                   | ❌     |
| `private`   | ✅          | ❌            | ❌                   | ❌     |

### The Classic Bug

```java
// package_a
public class Parent {
    Parent() {}  // default — package-private!
}

// package_b
public class Child extends Parent {
    // implicit super() → BOOM
    // Gate 1 OPEN (Parent is public), Gate 2 CLOSED (constructor is default)
}
```

> **Inheritance is an IS-A relationship. It does NOT bypass access rules.**

---

## 2. Why `protected` is Illegal on Top-Level Classes

**Q: `default` is more restrictive than `protected`. Why is `default` allowed but `protected` isn't?**

`protected` on a member gives one extra bonus over `default`: *subclasses in other packages can access it*. For that bonus to apply to a **class**, you'd need to subclass it — but to subclass it, you must first see it. **Paradox:**

```
See the class  → requires being a subclass
Be a subclass  → requires seeing the class
```

The bonus can never activate, so `protected` would behave identically to `default`. Java bans it as meaningless.

| Modifier    | Legal on Top-Level Class? | Reason                                  |
|-------------|:-------------------------:|------------------------------------------|
| `public`    | ✅                         | Clear meaning                           |
| *(default)* | ✅                         | Clear meaning                           |
| `protected` | ❌                         | Subclass bonus creates a paradox        |
| `private`   | ❌                         | Nothing outside the file could use it   |

---

## 3. `private` Fields, Inheritance & the Debugger

**Q: My debugger shows private parent fields on the child object. What's the point of `private` then?**

### Why the debugger shows them
The debugger talks directly to the **JVM** (via JDWP). Reflection too. They operate **below** the Java language. Access modifiers have no authority over them.

### Why they exist in the child's memory
`new Child()` allocates **all** fields — parent's private ones included. They must exist because parent's own methods still run on that object.

```
Heap: Child object
┌──────────────────────────┐
│  Parent's private field  │  ← parent's methods need it
│  Child's own fields      │
└──────────────────────────┘
```

The child cannot **name** them in code. The field exists; the door has no handle.

### `private` is a design contract, not a vault

| Design Choice                      | Contract                            |
|------------------------------------|-------------------------------------|
| `private`, no accessors            | Nobody touches this. Ever.          |
| `private` + getter only            | You may read, never write.          |
| `private` + getter + setter        | Interact only via my interface.     |
| `public` field                     | Free for all.                       |

A setter lets you **defend** state:
```java
public void setAge(int age) {
    if (age < 0) throw new IllegalArgumentException();
    this.age = age;
}
```
A `public` field gives you zero ability to do that.

### What `private` actually protects against
- **Accidental misuse** by other developers
- **Unintended coupling** — nobody depends on it, so you can change it freely
- **Invalid object states** — every write goes through your methods

> `private` doesn't mean *impossible to see*. It means *you are not supposed to depend on this, and the compiler will stop you if you try.*

---

## 4. Constructor Chaining & `super()`

**Q: With C extends B extends A and constructor chaining via `this()`, when does `super()` get called?**

### The One Rule
Every constructor must begin with **either** `this(...)` **or** `super(...)`. If you write neither, Java inserts `super()`. **Never both.**

| Call         | Meaning                                    |
|--------------|--------------------------------------------|
| `this(...)`  | Hand off to another constructor in same class |
| `super(...)` | Hand off to parent's constructor           |

### Key Insight
> `super()` is called **exactly once** per object construction — by whichever constructor sits at the **end of the `this()` chain**.

`this()` constructors are sideways redirectors. The terminal one calls `super()`.

### Example

```java
class A { A() { sout("A"); } }

class B extends A {
    B()         { this("hello");  sout("B no-arg"); }   // redirector
    B(String s) { super();        sout("B str: "+s); }   // terminal
}

class C extends B {
    C() { super(); sout("C"); }
}
```

`new C()` execution:
```
C() ──super()──► B() ──this()──► B(String) ──super()──► A()
                  ↑                  ↑
             redirector          terminal — calls super()
```
Output: `A`, `B str: hello`, `B no-arg`, `C`

---

## 5. Polymorphism: Feature, Not a Bug

**Q: With `Parent p = new Child()` and an overridden method, the child's version always runs. What if I wanted the parent's? Isn't this a problem for utility methods like `checkStatus(User u)`?**

**Not a bug — this IS the feature.** It's called **dynamic dispatch**.

The mental flip: *if the parent's version was good enough, you wouldn't have written the override.* The reference type is just a handle; the actual object knows what it is. This is the **Liskov Substitution Principle**.

The `checkStatus(User u)` example is the strongest argument *for* this design:

```java
void checkStatus(User user) {
    user.doSomething();   // does the right thing for whatever was passed
}
```

If Java called `User.doSomething()` here, polymorphism would be useless — you'd be writing `if (u instanceof Student) ... else if ...` everywhere, which is exactly what polymorphism eliminates.

### When you genuinely need the parent's version
- **Inside the child:** call `super.doSomething()` — common pattern is to extend behavior.
- **Outside:** you can't, and that's intentional. Letting external callers bypass overrides would break every subclass's invariants.
- **If both are legitimately needed externally:** that's a signal the hierarchy is wrong — use different method names, template method, strategy, or composition.

---

## 6. Overriding Rules — The Unified Pattern

**Q: When overriding, what can change and what can't (access modifiers, return types, exceptions)?**

### The Guiding Principle
> **Inputs can widen, outputs can narrow** — never the reverse. Keep every promise the parent made; you may make stronger promises on top, but never weaker.

### Access Modifiers — Can Widen, Can't Narrow

| Parent       | Child (allowed)                          | Child (illegal)            |
|--------------|------------------------------------------|----------------------------|
| `public`     | `public`                                 | anything else              |
| `protected`  | `protected`, `public`                    | `private`, package-private |
| package-priv | package-priv, `protected`, `public`      | `private`                  |
| `private`    | not actually overridable (not inherited) | —                          |

**Why narrowing is forbidden:** the compiler sees the reference type's signature; the runtime dispatches to the actual object's method. If the child narrowed access, a call site that's legal at compile time would invoke a "private" method from outside. Java forbids the situation upstream.

### Return Types — Covariant Returns (Java 5+)

The override's return type must be the **same or a subtype** of the parent's. Never a supertype.

```java
class Parent { Animal getCreature() { return new Animal(); } }
class Child  extends Parent {
    @Override
    Dog getCreature() { return new Dog(); }   // covariant — legal
}
```

**Why subtype is safe:** caller asked for `Animal`, got `Dog`. Every operation on `Animal` still works. Promise honored, just more specific.

**Why supertype would break:** parent returns `Dog`, child overrides to return `Animal` → caller does `d.bark()` → crash. Same disagreement between compile-time signature and runtime behavior.

**Bonus:** subclass-side callers don't need casts:
```java
Child c = new Child();
Dog d = c.getCreature();   // no cast needed
```
This is why `Object.clone()` overrides can return their own type now instead of forcing `(MyClass) original.clone()`.

### Unified Table

| Aspect             | Override CAN…                         | Override CANNOT…           |
|--------------------|---------------------------------------|----------------------------|
| Access modifier    | Widen (`protected` → `public`)        | Narrow (`public` → `private`) |
| Return type        | Narrow to subtype (`Animal` → `Dog`)  | Widen to supertype         |
| Checked exceptions | Throw fewer / narrower                | Throw more / broader       |
| Parameter types    | (Java: must match exactly)            | —                          |

**One sentence:** *Keep every promise the parent made; make stronger ones if you like, never weaker ones.*