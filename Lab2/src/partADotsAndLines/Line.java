package partADotsAndLines;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line {
  protected boolean isShown = true;
  protected Point p1, p2;
  
  public void toggle(boolean state) {
    isShown = state;
  }
  
  public boolean isShown() {
    return isShown;
  }
  
  public void toggle() {
    toggle(!isShown);
  }
  
  Line(Point p1, Point p2) {
    this.p1 = p1;
    this.p2 = p2;
  }
  
  public boolean touches(Point point) {
    return point == p1 || point == p2;
  }
  
  // draws a line of a certain color
  protected void draw(Graphics g, Color c) {
    if(isShown) {
      g.setColor(c);
      g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
  }  
}
