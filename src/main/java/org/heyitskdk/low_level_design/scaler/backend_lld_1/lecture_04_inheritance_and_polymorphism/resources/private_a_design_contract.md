# Java `private` — Not a Vault, a Design Contract

## Why the Debugger Shows Private Fields

The debugger talks to the **JVM directly** via JDWP — it bypasses access
modifiers entirely. Same with `Reflection`. These operate **below** the Java
language level. Access modifiers have no authority over them.

---

## Why Private Fields Exist in the Child Object's Memory

`new Child()` allocates **all fields** in memory — including parent's private ones.
They must exist because the **parent's own methods** still run on that object.

```
Heap: Child object
┌──────────────────────────┐
│  Parent's private field  │  ← Parent's methods need this
│  Child's own fields      │
└──────────────────────────┘
```

Child cannot **name** them in code. The field exists, but the door has no handle.

---

## Getters/Setters Don't Need Inheritance — That's the Point

`private` is not about locking data away. It's about **controlling interaction**.

| Design Choice                     | Contract                              |
|-----------------------------------|---------------------------------------|
| `private` field, no getter/setter | Nobody touches this. Ever.            |
| `private` + getter only           | You may read, never write.            |
| `private` + getter + setter       | Interact only through my interface.   |
| `public` field                    | Free for all.                         |

Without `private`, anyone can set a field to an invalid state and break your object.
`private` + setter lets you **defend**:

```java
public void setAge(int age) {
    if (age < 0) throw new IllegalArgumentException();
    this.age = age;
}
```

A `public` field gives you zero ability to do this.

---

## The "Sneaky Person" Problem

`private` is **not** protection against a determined adversary.
Reflection, debuggers, bytecode tools — all break through it. Java never claimed otherwise.

`private` protects against:
- **Accidental misuse** by other developers
- **Unintended coupling** — nobody builds code depending on it, so you can change it freely
- **Invalid object states** — every write goes through your methods

---

## One-Line Summary

> `private` doesn't mean *impossible to see*. It means *you are not supposed
> to depend on this, and the compiler will stop you if you try.*