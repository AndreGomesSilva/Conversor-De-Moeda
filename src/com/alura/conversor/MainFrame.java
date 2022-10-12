package com.alura.conversor;

import javax.swing.*;
import javax.xml.transform.stream.StreamSource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame{
    private JComboBox optionsBox;
    private JPanel Menu;
    private JButton btnSelect;


    public MainFrame() {
        JFrame chooseFrame = new JFrame("Converso");
        chooseFrame.setContentPane (Menu);
        chooseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make visible and set default size
//        frame.pack();
        chooseFrame.setBounds(1000, 500, 300, 200);
        chooseFrame.setVisible(true);

        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (optionsBox.getSelectedItem() == "Conversor de Moeda") {
                    new CurrencyConverter();
                    chooseFrame.setVisible(false);
                    dispose();
                }
            }
        });
    }
}
