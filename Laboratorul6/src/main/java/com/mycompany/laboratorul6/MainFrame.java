/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul6;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
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
        
        //to do: create the components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        
        //to do: arrange the components in the container(frame)
        add(canvas, CENTER);
        add(configPanel, NORTH);
        add(controlPanel, SOUTH);
        
        
        pack();
    }
}
