/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.util.Random;

/**
 *
 * @author Radu
 */
public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    
    BufferedImage image;
    Graphics2D graphics;
    
    public DrawingPanel(MainFrame frame)
    {
        this.frame = frame;
        createOffscreenImage();
        init();
    }
    
    private void createOffscreenImage()
    {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    
    private void init()
    {
       setPreferredSize(new Dimension(W, H));
       setBorder(BorderFactory.createEtchedBorder());
       this.addMouseListener(new MouseAdapter()
       {
           @Override
           public void mousePressed(MouseEvent e)
           {
               drawShape(e.getX(),e.getY());
               repaint();
           }
       }
       );
    }
    
    private void drawShape(int x, int y)
    {
        String colorOption =(String) frame.configPanel.colorCombo.getSelectedItem();
        int size = (int) frame.configPanel.sizeField.getValue();
        if(colorOption.equals("Black"))
          graphics.setColor(Color.black);
        else
        {
           Random rand = new Random();
           float r = rand.nextFloat();
           float g = rand.nextFloat();
           float b = rand.nextFloat();
           graphics.setColor(new Color(r,g,b));
        }
        graphics.drawOval(x, y, size, size);
    }
    
    @Override
    public void update(Graphics g)
    {
        
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(image, 0, 0, this);
    }
    
}
