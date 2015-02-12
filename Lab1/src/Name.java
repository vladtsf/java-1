import java.util.Random;

public class Name {
  
  private String firstName, secondName;
  private int gender;
  
  public static void main(String[] args) {
    Name nate = new Name();
    nate.setName("Nate", "Titterton", 30);
    Name evan = new Name();
    evan.setName("Evan", "Johnson", 30);

    System.out.println("Name: \"" + nate.name() + "\"");
    System.out.println("Roll call name: \"" + nate.rollCallName() + "\"");
    System.out.println("Initials: \"" + nate.initials() + "\"");
    System.out.println("Pig Latin name: \"" + nate.pigLatinName() + "\"");
    
    System.out.println("------------------------");
    
    System.out.println("Name: \"" + evan.name() + "\"");
    System.out.println("Roll call name: \"" + evan.rollCallName() + "\"");
    System.out.println("Initials: \"" + evan.initials() + "\"");
    System.out.println("Pig Latin name: \"" + evan.pigLatinName() + "\"");
  }
  
  void setName(String firstName, String secondName, int gender) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.gender = gender;
  }
  
  String name() {
    return capitalizeWord(firstName) + " " + capitalizeWord(secondName);
  }
  
  String rollCallName() {
    return capitalizeWord(secondName) + ", " + capitalizeWord(firstName);
  }
  
  String initials() {
    return "" + firstName.charAt(0) + secondName.charAt(0);
  }
  
  String pigLatinName() {
    return toPigLatin(firstName) + " " + toPigLatin(secondName);
  }
  
  private static String toPigLatin(String str) {
    str = str.toLowerCase();

    if(isConsonant(str.charAt(0))) {
      //  For words that begin with consonant sounds, the initial consonant or consonant cluster is 
      //  moved to the end of the word, and "ay" (some people just add "a") is added, as in the 
      //    following examples:
      //
      //  "pig" → "igpay"
      //  "banana" → "ananabay"
      //  "trash" → "ashtray"
      //  "happy" → "appyhay"
      //  "duck" → "uckday"
      //  "glove" → "oveglay"
      int consonantClusterLength = 1;
      
      for(; consonantClusterLength < str.length(); consonantClusterLength++) {
        Character currentChar = str.charAt(consonantClusterLength);
        
        if(!isConsonant(currentChar)) {
          break;
        }
      }
      
      return str.substring(consonantClusterLength) + 
              str.substring(0, consonantClusterLength) + "ay";
    }
    
    //  For words that begin with vowel sounds or silent letter, you just add "way" (or "wa")
    //  to the end. Examples are:
    //
    //  "egg" → "eggway"
    //  "inbox" → "inboxway"
    //  "eight" → "eightway"
    return str + "way";
  }
  
  private static String capitalizeWord(String str) {
    return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
  }
  
  private static boolean isConsonant(Character ch) {
    switch("" + ch) {
      case "b":
      case "c":
      case "d":
      case "f":
      case "g":
      case "h":
      case "j":
      case "k":
      case "l":
      case "m":
      case "n":
      case "p":
      case "q":
      case "r":
      case "s":
      case "t":
      case "v":
      case "x":
      case "y":
      case "z":
      case "w":
        return true;
      default:
        return false;
    }
  }
}
