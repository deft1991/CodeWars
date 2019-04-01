package com.codewars.hackerRank;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 3/19/2019
 */
public class HabrPazzler {
  public static void main(String[] args) {
    boolean b1 = false;
    boolean b2 = false;
    if ( b1 = b2) {
      System.out.println("YES");
    }
    else {
      System.out.println("NO");
    }
  }
}

class Super {
  public String name = "Tort";
  public String getName() {
    return name;
  }
}
class Sub extends Super {
  public String name = "Habr";
  public String getName() {
    return name;
  }
  public static void main(String[] args) {
    Super s = new Sub();
    System.out.println(s.name + " " + s.getName());
  }
}

class Test{
  public static void main(String[] args)   {
    String s = "old";
    print(s, s = "new");
  }
  static void print(String s1, String s2)   {
    System.out.println(s1 +" "+ s2);
  }
}

class A {
  A() {  print();   }
  void print() { System.out.println("A"); }
}
class B extends A {
  int i = Math.round(3.5f);
  public static void main(String[] args) {
    A a = new B();
    a.print();
  }
  void print() { System.out.println(i); }
}

class Threader extends Thread {
  public void run() {
    System.out.println("In Threader");
  }
}
class Pooler extends Thread {
  public Pooler(){ }
  public Pooler(Runnable r) {
    super( r );
  }
  public void run() {
    System.out.println("In Pooler");
  }
}
 class TestClass {
  public static void main(String[] args) {
    Threader t = new Threader();
    Thread h = new Pooler(t);
    h.start();
  }
}