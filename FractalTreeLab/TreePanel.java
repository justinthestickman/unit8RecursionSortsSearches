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
   public void drawFractal (int order, double x1, double y1, double length, double angleRelativeVertical, Graphics2D g2)
   {
      double x2, y2, x3, y3;
      
      if (order == 1)
      {
         Line2D.Double line = new Line2D.Double(x1, y1, x1, y1-length);
         g2.draw(line);
      }
      else
      {
         x2 = x1 - (length * Math.sin(angleRelativeVertical));
         y2 = y1 - (length * Math.cos(angleRelativeVertical));
         x3 = x1 + (length * Math.sin(angleRelativeVertical));
         y3 = y1 - (length * Math.cos(angleRelativeVertical));
         drawFractal(order-1, x2, y2, length*LSCALE, angleRelativeVertical+ANGLE, g2);
         drawFractal(order-1, x3, y3, length*LSCALE, angleRelativeVertical+ANGLE, g2);
      }
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);

      page.setColor (Color.green);

      
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