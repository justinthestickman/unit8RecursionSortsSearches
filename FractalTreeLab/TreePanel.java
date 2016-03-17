//********************************************************************
//  TreePanel.java       Author: Justin Huang
//
//  Represents a drawing surface on which to paint a Fractal Tree.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;

public class TreePanel extends JPanel
{
   private final int PANEL_WIDTH = 400;
   private final int PANEL_HEIGHT = 400;

   private final double LSCALE = 0.75;
   private final double ANGLE = 15;

   private int current; //current order

   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public TreePanel (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void branch(int order, double x1, double y1, double length, double angle, Graphics2D g2)
   {
      if (order == 1)
      {
         //Line2D.Double trunk = new Line2D.Double(x1, y1, x1, y1-length);
         //g2.draw(trunk);
      }
      else
      {
         double x2, y2, x3, y3;
         length *= LSCALE;
         double angle1 = angle + ANGLE;
         double angle2 = angle - ANGLE;
         
         x2 = x1 - (length * Math.sin(Math.toRadians(angle1)));
         y2 = y1 - (length * Math.cos(Math.toRadians(angle1)));
         x3 = x1 + (length * Math.sin(Math.toRadians(angle2)));
         y3 = y1 - (length * Math.cos(Math.toRadians(angle2)));
         
         Line2D.Double line1 = new Line2D.Double(x1, y1, x2, y2);
         Line2D.Double line2 = new Line2D.Double(x1, y1, x3, y3);
         g2.draw(line1);
         g2.draw(line2);
         
         branch(order-1, x2, y2, length, angle1, g2);
         branch(order-1, x3, y3, length, angle2, g2);
      }
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      super.paintComponent(g2);

      g2.setColor(Color.green);
      
      Line2D.Double trunk = new Line2D.Double(200, 400, 200, 300);
      g2.draw(trunk);

      this.branch(current, 200, 300, 100, 0, g2);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}