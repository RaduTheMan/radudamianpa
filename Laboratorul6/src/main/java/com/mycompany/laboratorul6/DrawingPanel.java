/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul6;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

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
        
    }
    
    private void init()
    {
        
    }
    
}