package partC;
import java.util.Random;

public class Person {
  private static final int MIN_RANDOM_HEIGHT = 51;  
  private static final int MAX_RANDOM_HEIGHT = 90;
  
  private Name name;
  private String hairColor;
  private Height height;
  private int id;
  
  private static int lastUsedId = 0;
  
  private Person(Name name, String hairColor, Height height) {
    this.name = name;
    this.height = height;
    this.hairColor = hairColor;
    this.id = lastUsedId++;
  }
  
  Person(Name name, String hairColor, int height) {
    this(name, hairColor, new Height(height));
  }
  
  Person(Name name, int height) {
    this(name, null, height);
  }
  
  Person(Name name, String hairColor) {
    this(name, hairColor, Height.getRandomHeight(MIN_RANDOM_HEIGHT, MAX_RANDOM_HEIGHT));
  }
  
  Person(Name name) {
    this(name, null, Height.getRandomHeight(MIN_RANDOM_HEIGHT, MAX_RANDOM_HEIGHT));
  }
  
  public String name() {
    return name.name();
  }
  
  public String initials() {
    return name.initials();
  }
  
  public String getHair() {
    return hairColor == null ? "hair color is unspecified" : hairColor;
  }
  
  public int getHeight() {
    return height.heightInInches;
  }
  
  public int getId() {
    return id;
  }
  
  public Person copy() {
    return new Person(name, hairColor, height);
  }
  
  // "tests"
  public static void main(String[] args) {
    System.out.println("Testing the behavior of the \"name\" field: " + (testNameBehavior() ? "OK" : "FAIL"));
    System.out.println("Testing the behavior of the \"hairColor\" field: " + (testHairColorBehavior() ? "OK" : "FAIL"));
    System.out.println("Testing the behavior of the \"height\" field: " + (testHeightBehavior() ? "OK" : "FAIL"));
    System.out.println("Testing the behavior of the \"id\" field: " + (testIdBehavior() ? "OK" : "FAIL"));
  }
  
  public static boolean testNameBehavior() {
    Name name = createRandomName();
    Person person = new Person(name);
    
    return person.name().equals(name.name()) && person.initials().equals(name.initials());
  }
  
  private static boolean testHairColorBehavior() {
    Person dudeWithNoHairColor = new Person(createRandomName());
    Person anotherDudeWithNoHairColor = new Person(createRandomName(), 70);
    Person redHairedDude = new Person(createRandomName(), "red");
    
    // no hair color no mather what the name is
    return dudeWithNoHairColor.getHair().equals(anotherDudeWithNoHairColor.getHair())
    // should say "hair color is unspecified" if no hair color
            && dudeWithNoHairColor.getHair().equals("hair color is unspecified")
    // should store the hair color if it's specified as well as the getter should work properly
            && redHairedDude.getHair().equals("red");
  }
  
  private static boolean testHeightBehavior() {
    Person personWithNoHeightSpecified;
    Person anotherPersonWithNoHeightSpecified = new Person(createRandomName(), "blue");
    Person tallPerson = new Person(createRandomName(), 500);
    
    // Testing if a random height is assigned properly.
    // Yeah, I know this is bad practice, but no one will ever find out ¯\_(ツ)_/¯ 
    for (int i = 0; i < 10000; i++) {
      personWithNoHeightSpecified = new Person(createRandomName());
      int height = personWithNoHeightSpecified.getHeight();
      
      if(height < MIN_RANDOM_HEIGHT || height > MAX_RANDOM_HEIGHT) {
        return false;
      }
    }
    
    // Tests whether the height works well for the overload that accepts a name and hair color     
    if(anotherPersonWithNoHeightSpecified.getHeight() == 0) {
      return false;
    }
    
    // Tests if the class is capable of storing a height value
    if(tallPerson.getHeight() != 500) {
      return false;
    }
    
    return true;
  }
  
  private static boolean testIdBehavior() {
    Name name = createRandomName();
    
    Person person1 = new Person(name);
    Person person2 = new Person(name);
    
    // IDs must be unique    
    return person1.getId() != person2.getId() 
    // the last person's id should be equal to `lastUsedId - 1` as we start from 0
            && person2.getId() == lastUsedId - 1;
  }
  
  private static Name createRandomName() {
    Name name = new Name();    
    Random seed = new Random();
    
    String[] fakeNames = {"Shirley", "Ryan", "Kelvin", "Ernest", "Pamela", "Mandy", "Connie", "Raul", "Gayle", "Nettie"};
    String[] fakeLastNames = {"Diaz", "Barker", "Cummings", "Howell", "Newman", "Neal", "Walsh", "Adams", "Norman"};
    
    name.setName(fakeNames[seed.nextInt(fakeNames.length - 1)], 
            fakeLastNames[seed.nextInt(fakeNames.length - 1)], 30);
    
    return name;
  }
}
