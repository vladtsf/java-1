public class Wug {
  
  int myAge;
  String myName;
  
  public static void main(String[] args) {
    Wug w1 = new Wug();
    w1.myAge = 3;
    w1.myName = "Strong Bad";
    
    w1.introduce();
    ageTheWug(w1);
    w1.introduce();
  }
  
  void introduce() {
    System.out.println("I'm " + myName + " and I'm " + myAge + "years old.");
  }
  
  boolean equals(Wug otherWug) {
    return myAge == otherWug.myAge && myName.equals(otherWug.myName);    
  }
  
  static int ageTheWug(Wug w) {
    w.myAge = w.myAge + 1;
    return w.myAge;
  }
}
