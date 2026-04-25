# Java Method Overriding: Access Modifiers & Return Types

## The Guiding Principle

When overriding, **inputs can widen, outputs can narrow** — but never the reverse. The override must honor every promise the parent's signature made to its callers (Liskov Substitution Principle).

---

## 1. Access Modifiers: Can Widen, Can't Narrow

**Rule:** An override's access modifier must be **equal to or more permissive** than the parent's.

| Parent       | Child (allowed)                  | Child (illegal) |
|--------------|----------------------------------|-----------------|
| `public`     | `public`                         | anything else   |
| `protected`  | `protected`, `public`            | `private`, package-private |
| package-priv | package-priv, `protected`, `public` | `private`    |
| `private`    | not actually overridable (not inherited) | —      |

### Why narrowing is forbidden

```java
Parent p = new Child();
p.doSomething();  // compiler checks Parent's signature → public, OK
                  // runtime dispatches to Child's version → private?!
```

The compiler trusts the reference type's signature; dynamic dispatch executes the actual object's method. If the child narrowed access, a call site that's legal at compile time would be invoking a "private" method from outside — either silently breaking encapsulation or crashing at runtime. The language forbids the situation upstream.

### Why widening is safe

Every existing caller of the parent's method still has access. The child is just being more generous to additional callers. No promise is broken.

---

## 2. Return Types: Covariant Returns

**Rule:** An override's return type must be the **same type or a subtype** of the parent's return type. Never a supertype or unrelated type.

```java
class Parent {
    Animal getCreature() { return new Animal(); }
}

class Child extends Parent {
    @Override
    Dog getCreature() { return new Dog(); }  // covariant — legal
}
```

### Why subtype returns are safe

```java
Parent p = new Child();
Animal a = p.getCreature();  // caller expects Animal, gets Dog — Dog IS-A Animal ✓
```

Caller asked for an `Animal`, got something *more specific*. Every operation they planned to do on an `Animal` still works.

### Why supertype returns would break

```java
// hypothetical: Parent returns Dog, Child overrides to return Animal
Parent p = new Child();
Dog d = p.getCreature();  // compiler: "Parent returns Dog, fine"
d.bark();                 // runtime: actual return is Animal — no bark() — crash
```

Same failure mode as narrowing access: compile-time signature and runtime behavior disagree, breaking callers.

### Bonus: cleaner subclass-side calls

```java
Child c = new Child();
Dog d = c.getCreature();  // no cast needed — override's declared return is Dog
```

Pre-Java 5, every override had to match the parent's return type exactly, forcing ugly casts like `(Dog) c.getCreature()`. Covariant returns (Java 5+) removed that ceremony — visible in `clone()`, builders, factories, and fluent APIs.

---

## The Unified Pattern

The same "promises" logic governs every override constraint:

| Aspect            | Override can…                          | Override cannot…                |
|-------------------|----------------------------------------|----------------------------------|
| Access modifier   | Widen (`protected` → `public`)         | Narrow (`public` → `private`)   |
| Return type       | Narrow to subtype (`Animal` → `Dog`)   | Widen to supertype              |
| Checked exceptions| Throw fewer / narrower                 | Throw more / broader            |
| Parameter types   | (Java: must match exactly)             | —                                |

**One sentence:** *Keep every promise the parent made; you may make stronger promises on top, but never weaker ones.*