package recursion;

public class ReverseMethods {

  public static void main(String[] args) {
    ReverseMethods rm = new ReverseMethods();

    System.out.println(rm.reverse2("12"));
    System.out.println(rm.reverse3("123"));
    System.out.println(rm.reverse16("1234567890123456"));
    System.out.println(rm.reverse17("12345678901234567"));
    System.out.println(rm.reverse("abcdefghklmnopqrstuvwxyz0123456789"));
  }

  // returns the reverse of a one-length string.  Easy!
  public String reverse1(String s) {
    return s;
  }

  //returns the reverse of a two-length string.
  public String reverse2(String s) {
    return (s.substring(1, 2) + s.substring(0, 1));
  }

  //returns the reverse of a three-length string.
  public String reverse3(String s) {
    return (s.substring(2, 3) + s.substring(1, 2) + s.substring(0, 1));
  }

  /*
   * more of the same here...
   */
  public String reverse16(String s) {
        // This is the *bad* way to write reverse!  
    // You'll do better with reverse17, right?
    return s.substring(15, 16)
            + s.substring(14, 15)
            + s.substring(13, 14)
            + s.substring(12, 13)
            + s.substring(11, 12)
            + s.substring(10, 11)
            + s.substring(9, 10)
            + s.substring(8, 9)
            + s.substring(7, 8)
            + s.substring(6, 7)
            + s.substring(5, 6)
            + s.substring(4, 5)
            + s.substring(3, 4)
            + s.substring(2, 3)
            + s.substring(1, 2)
            + s.substring(0, 1);
  }

  public String reverse17(String s) {
    return s.substring(16, 17) + reverse16(s);
  }

    // helper methods you can use (you should use one of them)
  // returns a string containing all the characters except the first
  public static String allButFirst(String s) {
    return s.substring(1);
  }

  // returns a string  containing all the characters except the last
  public static String allButLast(String s) {
    return s.substring(0, s.length());
  }

  /*
   * Now, write a recursive solution to reverse without using any helper methods.
   * That is, reverse should only call reverse! (and some string manipulation methods).
   */
  
  public String reverse(String s) {

    if (s.length() == 1) {
      // base case
      return s;
    } else {
      // the recursive case! 
      
      // I'm confused. The lab guide says,
      //  "Again, there are two ‘correct’ ways to write this; each way will use one of the two helper
      //   methods (allButFirst and allButLast)."
      // Idk if I'm allowed to use the helpers :/
      // return reverse(allButFirst(s)) + s.substring(0, 1);
      return reverse(s.substring(1)) + s.substring(0, 1);
    }
  }

}
