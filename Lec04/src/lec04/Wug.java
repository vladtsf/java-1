package lec04;

public class Wug {
  private int myAge;
  private String myName;
  
  public static void main(String[] args) {
    Wug wug = new Wug(30, 2);
    
    System.out.println("I'm " + wug.myName + " and I'm " + wug.myAge + " years old");
  }
  
  Wug() {
    this(0, "idk");
  }
  
  Wug(int age) {
    this(age, "idk");
  }
  
  Wug(String name) {
    this(0, "idk");
  }
  
  Wug(int age, int name) {
    this(age, "number " + name);
  }
  
  Wug(int age, String name) {
    myAge = age;
    myName = name;
  }
  
  public void setAge(int age) {
    myAge = age;
  }
  
  public void setName(String name) {
    myName = name;
  }
  
  public void setName(int num) {
    myName = "number " + num;
  }
}
