/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec06;

/**
 *
 * @author tsvang
 */
public class Subclass extends Superclass {
  public void print() {
    System.out.println("sub");
  }
  
  public static void main(String[] args) {
//    Superclass obj3 = new Superclass();
//    ((Subclass) obj3).print();
    
    Subclass obj4 = new Subclass();
    ((Superclass) obj4).print();
  }
}
