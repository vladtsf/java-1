package lec05;

import java.util.ArrayList;

public class Explore {
  static void test1() {
    ArrayList<Wug> wugs;
    wugs = new ArrayList<>();
    wugs.add(new Wug("Joe"));
    System.out.println(wugs.get(0));
    wugs.add(0, new Wug("mary"));
    System.out.println(wugs.get(0));
    System.out.println(wugs.get(1));
    System.out.println(wugs.size());
  }
  
  static void test2() {
    ArrayList<String> flavors;
    flavors = new ArrayList<>();
    
    flavors.add("joe");
    flavors.add(0, "mary");
    flavors.add("sam");
    flavors.add("baron");
    
    flavors.remove("sam");
    flavors.remove(0);
    
    System.out.println(flavors.size());
    System.out.println(flavors);
  }
  
  static void test3(String... foo) {
    ArrayList<Double> nums = new ArrayList<>();
    ArrayList<ArrayList<Integer>> ints;
    
    for(int i = 0; i < 100000; i++) {
      nums.add(Math.random());
    }
    
    double currentMax = 0;
    
    for (Double num : nums) {
      if(num > currentMax) {
        currentMax = num;
      }
    }
    
    System.out.println(nums);
    System.out.println(currentMax);
  }
    
  static void test4() {
    String[] flavors;
    flavors = new String[10];
    
    for (int i = 0; i < 10; i++) {
      flavors[i] = "vanilla";
    }
    
    System.out.println(flavors);
  }
  
  
  public static void main(String[] args) {
//    test1();
//    test2();
//    test3();
    test4();
  }
}
