package DotsAndLines;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

// You don't need to know what is going on in here -- you'll learn about it later.
public class MouseListenerDrawer extends JPanel implements MouseListener{
    
    protected int myWindowWidth = 700;
    protected int myWindowHeight = 500;
    
    
    public MouseListenerDrawer() {
        JFrame easel = new JFrame();      
        easel.setSize (myWindowWidth, myWindowHeight);
        easel.add (this);
        easel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener (this);
        easel.setVisible (true);
    }
    
    
    public void erase (Graphics g) {
        g.setColor (Color.white);
        g.fillRect (0, 0, myWindowWidth, myWindowHeight);
        g.setColor (Color.black);
    }
    
    
    // Mouse Listener Stuff
    public void mouseClicked (MouseEvent event) {
    }
    
    public void mouseReleased (MouseEvent event) {
    }
    
    public void mousePressed (MouseEvent event) {
    }
    
    public void mouseEntered (MouseEvent event) {
    }
    
    public void mouseExited (MouseEvent event) {
    }
}
