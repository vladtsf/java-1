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
        
    }
    
    
    
    public static void testOnSeagull() {
        RGBImage seagull = new RGBImage("seagull.jpg");
//        seagull.flipVertical();
//        seagull.makeGreyscale();
//        seagull.threshHolding(130);
        
//        seagull.mirrorHorizontal();
        seagull.addBorder(23);
        
    }
}
