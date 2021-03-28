/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul6;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Radu
 */
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JLabel sizeLabel;
    JSpinner sizeField;
    JLabel colorLabel;
    JComboBox colorCombo;
    
    public ConfigPanel(MainFrame frame)
    {
        this.frame = frame;
        init();
    }
    
    private void init()
    {
        sizeLabel = new JLabel("Size:");
        sizeField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sizeField.setValue(6);
        String[] colorOptions = {"Random", "Black"};
        
        //to do; create the colorCombo, containing the values: Random and Black
        colorLabel = new JLabel("Color:");
        colorCombo = new JComboBox(colorOptions);
        
        add(sizeLabel);
        add(sizeField);
        add(colorLabel);
        add(colorCombo);
        
    }
    
}
