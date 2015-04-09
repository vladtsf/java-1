/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageProc;

/**
 *
 * @author nate
 */
public class TestRGBImage {

    public static void main(String[] args) {

        testOnSeagull();
        
        // this is to test if addBorder() crashes on a 5x5 picture
//        testOn5x5();
    }
    
    
    
    public static void testOnSeagull() {
        RGBImage seagull = new RGBImage("seagull.jpg");
//        seagull.flipVertical();
//        seagull.makeGreyscale();
//        seagull.threshHolding(130);
        
        seagull.mirrorHorizontal();
        seagull.addBorder();
        seagull.contrastStretch(100);
        
        
        
    }
    
    public static void testOn5x5() {
        RGBImage x5 = new RGBImage("5x5.jpg");
        x5.addBorder(10);
    }
}
