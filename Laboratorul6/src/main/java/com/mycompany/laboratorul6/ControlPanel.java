/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Radu
 */
public class ControlPanel extends JPanel{
    
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //to do: create all buttons (Load, Reset, Exit) 
    
    public ControlPanel(MainFrame frame)
    {
        this.frame = frame;
        init();
    }
    
    private void init()
    {
        setLayout(new GridLayout(1,4));
        
        //to do: add all buttons
        
        saveBtn.addActionListener(this::save);
        add(saveBtn);
        //to do: configure listeners for all buttons
    }
    
    private void save(ActionEvent e)
    {
        try
        {
            ImageIO.write(frame.canvas.image,"PNG", new File("e:/test.png"));
        }
        catch(IOException ex)
        {
            System.err.println(ex);
        }
    }
    
    
}
