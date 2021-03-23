/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul6;

import static java.awt.BorderLayout.CENTER;
import javax.swing.JFrame;

/**
 *
 * @author Radu
 */
public class MainFrame extends JFrame {
    
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    
    public MainFrame()
    {
        super("My drawing application");
        init();
    }
            
    private void init()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        canvas = new DrawingPanel(this);
        //to do: create the components
        
        add(canvas, CENTER);
        //to do: arrange the components in the container(frame)
        
        pack();
    }
}
