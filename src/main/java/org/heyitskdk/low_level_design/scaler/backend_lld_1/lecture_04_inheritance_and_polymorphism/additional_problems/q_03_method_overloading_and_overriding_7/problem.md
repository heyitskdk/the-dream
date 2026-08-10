# OOPs in Java (Inheritance and polymorphism - Method Overloading and Overriding) -7

Consider the following Code

## P class

```java
public class P {
   protected int d1 = 10;
   protected int d = 100;

   protected void fun1(){
       System.out.println("P's fun1");
   }

   protected void fun(){
       System.out.println("P's fun");
   }

   static protected void sfun(){
       System.out.println("P's sfun");
   }
}
```

## C class

```java
public class C extends P{
   protected int d2 = 20;
   protected int d = 200;

   protected void fun2(){
       System.out.println("C's fun2");
   }

   protected void fun(){
       System.out.println("C's fun");
   }

   static protected void sfun(){
       System.out.println("C's sfun");
   }
}
```

## Client class

```java
public class Client {
    public static void main(String[] args) {
        C obj = new P();
        System.out.println(obj.d1);
        System.out.println(obj.d);
        obj.fun1();
        obj.fun();
        obj.sfun();
    }
}
```

What is the output?
> Compile Time Error