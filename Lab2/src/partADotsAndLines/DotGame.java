package partADotsAndLines;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class DotGame extends DotsAndLines {
  
  protected boolean closedMode = false;
  private final PointList pointList = new PointList(points);
  protected boolean isGameWon = false;
  private static final String winText = "You win!";
  
  public static void main(String[] args) {
    DotsAndLines me = new DotGame();
  }
  
  // checks if a new point makes the graph closed
  private boolean makesClosed(Point p) {
    if(points.size() < 2) {
      return false;
    }
    
    return closeTo(points.get(0), p);
  }
  
  // This gets called whenever the user presses their mouse button in the window
  @Override
  public void mousePressed(MouseEvent event) {
    // where did the user click?
    Point p_clicked = new Point(event.getX(), event.getY());
    
    if(!isGameWon) {
      if(!closedMode) {
        if(makesClosed(p_clicked)) {
          closedMode = true;
        } else {
          points.add(new Point(p_clicked));
        } 

        pointList.rebuildConnections(closedMode);
      } else {
        for (Point point : points) {
          if(closeTo(point, p_clicked)) {
            pointList.togglePoint(point);
          }
        }
      }
      
      if(pointList.getVisibleConnections().isEmpty() && closedMode) {
        isGameWon = true;
      }
    }
       
    repaint();
  }
  
  // This gets called whenever Java needs to draw to the window.  
  //   Basic method: first erase the window, then redraw it.  Simple!
  @Override
  public void paintComponent(Graphics g) {
    // erase the window
    erase(g);
    
    if(isGameWon) {
      g.setFont(new Font("Arial", Font.BOLD, 24)); 
      
      FontMetrics fm = g.getFontMetrics();
      int left = (int) myWindowWidth / 2 - fm.stringWidth(winText) / 2;
      int top = (int) myWindowHeight / 2 - fm.getHeight() / 2;
      
      g.drawString(winText, left, top);
    } else {
      for (Point point : points) {
        drawPoint(g, point);
      }

      if(pointList != null) {
        for (Line line : pointList.getConnections()) {
          line.draw(g, Color.black);
        }
      }
    }
  }
}
